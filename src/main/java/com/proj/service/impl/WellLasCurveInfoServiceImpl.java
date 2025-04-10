package com.proj.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.proj.entity.po.WellLasCurveInfoPO;
import com.proj.service.WellLasCurveInfoService;
import com.proj.mapper.WellLasCurveInfoMapper;
import com.proj.utils.NamingUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.beans.BeanMap;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* @author L
* @description 针对表【Well_Las_Curve_Info】的数据库操作Service实现
* @createDate 2025-03-18 15:07:36
*/
@Service
public class WellLasCurveInfoServiceImpl extends ServiceImpl<WellLasCurveInfoMapper, WellLasCurveInfoPO>
    implements WellLasCurveInfoService{
    @Autowired
    private WellLasCurveInfoMapper wellLasCurveInfoMapper;

    //savelas这里要加几个逻辑：首先用户存入las数据时，要返回curveInfoList让用户将选择的数据与我们解析到的las文件对应。这里我们将我们解析的表头传回前端，
    //然后前端让用户进行数据对应之后传回后端，后端再进行Curve表头与用户选定表头的对应。
    // 有了这个类之后，进行业务方法的编写。
    //所以一共是三个步骤
    //1. 接收请求，将我们解析的表头传回前端
    //2. 处理前端传回的表头对应数据，构建WellLasCurveMatchInfo数据表，将数据入库
    //3. 业务逻辑处理
    @Override
    public void savelas(MultipartFile file, int lasInfoId) {
        String line;
        ArrayList<String> curveInfoList = new ArrayList<>();
        Map<String,String> cureveInfoMap= new HashMap<>();
        List<WellLasCurveInfoPO> wellLasCurveInfoList = new ArrayList<WellLasCurveInfoPO>();
        boolean inCurveInformationBlock = false;
        boolean inDataBlock = false;
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))){
            while((line = reader.readLine())!=null){
                if(!line.startsWith("#")){
                    if (line.startsWith("~C")) {
                        //inWellInformationBlock = false;
                        inCurveInformationBlock = true;
                    }
                    if (line.startsWith("~P") || line.startsWith("~O")) {
                        inCurveInformationBlock = false;
                    }
                    if (line.startsWith("~A")) {
                        inCurveInformationBlock = false;
                        inDataBlock = true;
                    }

                    if (inCurveInformationBlock) {
                        if (!line.startsWith("~")) {
                            String key = NamingUtils.toCamelCase(line.substring(0, line.indexOf(".")).trim());
                            curveInfoList.add(key);
                            /*String value = line.substring(line.indexOf(".") + 1).split(":")[0].replaceAll(" ", "");
                            //String description = line.split(":")[1].trim();

                            // 存储到HashMap中，避免重复键
                            if (!curveInfoMap.containsKey(key)) {
                                curveInfoMap.put(key, value);
                            }*/
                            /*if (!curveInfoDesMap.containsKey(key)) {
                                curveInfoDesMap.put(key, description);
                            }*/
                        }
                    }
                    if (inDataBlock) {
                        if (!line.startsWith("~")) {
                            String[] data = line.trim().split("\\s+");

                            for (int i = 0; i < data.length; i++) {
                                cureveInfoMap.put(curveInfoList.get(i),data[i]);
                            }
                            //System.out.println(cureveInfoMap);
                            wellLasCurveInfoList.add(mapToEntity(cureveInfoMap,lasInfoId));
                            if(wellLasCurveInfoList.size()>=1000){
                                this.saveBatch(wellLasCurveInfoList);
                                wellLasCurveInfoList.clear();
                            }
                        }
                    }
                }
            }
            if(!wellLasCurveInfoList.isEmpty()){
                this.saveBatch(wellLasCurveInfoList);
                wellLasCurveInfoList.clear();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }



    public WellLasCurveInfoPO mapToEntity(Map<String,String> curveInfoMap, int lasInfoId){
        WellLasCurveInfoPO wellLasCurveInfo = new WellLasCurveInfoPO();
        BeanMap beanMap = BeanMap.create(wellLasCurveInfo);
        beanMap.put("lasInfoId",lasInfoId);
        for (Map.Entry<String,String> entry : curveInfoMap.entrySet()){
            if(beanMap.containsKey(entry.getKey())){
                beanMap.put(entry.getKey(),new BigDecimal(entry.getValue()));
            }
        }
        return wellLasCurveInfo;
    }
}




