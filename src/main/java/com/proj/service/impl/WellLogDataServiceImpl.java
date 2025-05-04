package com.proj.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.proj.entity.dto.FieldCommentDTO;
import com.proj.entity.po.WellLogDataPO;
import com.proj.entity.vo.WellLogDataVO;
import com.proj.mapper.WellLogCurveMappingMapper;
import com.proj.mapper.WellLogDataMapper;
import com.proj.service.WellLogDataService;
import com.proj.utils.CommentUtils;
import com.proj.utils.NamingUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.beans.BeanMap;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.util.*;
import java.util.stream.Collectors;

/**
* @author L
* @description 针对表【well_log_data】的数据库操作Service实现
* @createDate 2025-04-17 16:33:41
*/
@Service
public class WellLogDataServiceImpl extends ServiceImpl<WellLogDataMapper, WellLogDataVO>
    implements WellLogDataService{

    @Autowired
    private WellLogDataMapper wellLogDataMapper;
    @Autowired
    private WellLogCurveMappingMapper wellLogCurveMappingMapper;

    @Override
    public ResponseEntity<String> ac_mapping_savewelllogdata(List<MultipartFile> files) {
        for(MultipartFile file:files){
            String line;
            //存储标准表头
            ArrayList<String> standard_field_name = new ArrayList<>();
            //存储数据
            Map<String,String> wellLogDataMap = new HashMap<String,String>();
            List<WellLogDataVO> wellLogDataList = new ArrayList<>();
            boolean inCurveInformationBlock = false;
            boolean inDataBlock = false;


            //处理外键关联问题
            String well_log_id = file.getOriginalFilename();
            //System.out.println(well_log_id);

            try(BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))){
                while ((line=reader.readLine())!=null){
                    if(!line.startsWith("#")){
                        if (line.startsWith("~C")) {
                            inCurveInformationBlock = true;
                        }
                        if (line.startsWith("~P") || line.startsWith("~O")) {
                            inCurveInformationBlock = false;
                        }
                        if (line.startsWith("~A")) {
                            inCurveInformationBlock = false;
                            inDataBlock = true;
                        }
                        if(inCurveInformationBlock){
                            if(!line.startsWith("~")){
                                String find_standard_field_name = wellLogCurveMappingMapper.find_standard_field_name_byname(line.substring(0, line.indexOf(".")).trim());
                                System.out.println(find_standard_field_name);
                                if(find_standard_field_name==null){
                                    return ResponseEntity.badRequest().body("映射不存在");
                                }
                                standard_field_name.add(NamingUtils.toCamelCase(find_standard_field_name));
                            }
                        }

                        if(inDataBlock){
                            if (!line.startsWith("~")){
                                String[] data = line.trim().split("\\s+");
                                for (int i = 0; i < data.length; i++) {
                                    wellLogDataMap.put(standard_field_name.get(i),data[i]);
                                }
                                wellLogDataList.add(mapToEntity(wellLogDataMap,well_log_id));
                                if(wellLogDataList.size()>=1000){
                                    this.saveBatch(wellLogDataList);
                                    wellLogDataList.clear();
                                }
                            }
                        }
                    }
                }
                if(!wellLogDataList.isEmpty()){
                    this.saveBatch(wellLogDataList);
                    wellLogDataList.clear();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        return ResponseEntity.ok("保存成功");
    }


    // 实现 selectAllTableHeaders 方法
//    @Override
//    public List<String> selectAllTableHeaders() {
//        // 获取 WellLogDataPO 类的所有字段
//        Field[] fields = WellLogDataPO.class.getDeclaredFields();
//        return Arrays.stream(fields)
//                .map(Field::getName)
//                .filter(fieldName -> !fieldName.equals("id") &&
//                                 !fieldName.equals("wellLogId") &&
//                                 !fieldName.equals("serialVersionUID") &&
//                                 !fieldName.equals("depth") &&
//                                 !fieldName.equals("createTime") &&
//                                 !fieldName.equals("updateTime"))
//                .collect(Collectors.toList());
//    }
    @Override
    public List<FieldCommentDTO> selectAllTableHeaders() {
        Field[] fields = WellLogDataPO.class.getDeclaredFields();
        return Arrays.stream(fields)
                .map(field -> {
                    CommentUtils comment = field.getAnnotation(CommentUtils.class);
                    String fieldName = field.getName();
                    String commentValue = (comment != null) ? comment.value() : fieldName;
                    return new FieldCommentDTO(fieldName, commentValue);
                })
                .filter(dto -> !dto.getField().equals("id") &&
                        !dto.getField().equals("wellLogId") &&
                        !dto.getField().equals("depth") &&
                        !dto.getField().equals("serialVersionUID") &&
                        !dto.getField().equals("createTime") &&
                        !dto.getField().equals("updateTime"))
                .collect(Collectors.toList());
    }



    public WellLogDataVO mapToEntity(Map<String,String> curveInfoMap, String well_log_id){
        WellLogDataVO wellLogDataVO = new WellLogDataVO();
        BeanMap beanMap = BeanMap.create(wellLogDataVO);
        beanMap.put("wellLogId ",well_log_id);
        for (Map.Entry<String,String> entry : curveInfoMap.entrySet()){
            if(beanMap.containsKey(entry.getKey())){
                beanMap.put(entry.getKey(),new Double(entry.getValue()));
            }
        }
        return wellLogDataVO;
    }

}




