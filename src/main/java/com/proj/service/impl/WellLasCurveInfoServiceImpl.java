package com.proj.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.proj.entity.WellLasCurveInfo;
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
import java.security.Key;
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
public class WellLasCurveInfoServiceImpl extends ServiceImpl<WellLasCurveInfoMapper, WellLasCurveInfo>
    implements WellLasCurveInfoService{
    @Autowired
    private WellLasCurveInfoMapper wellLasCurveInfoMapper;


    @Override
    public void savelas(MultipartFile file, int lasInfoId) {
        String line;
        ArrayList<String> curveInfoList = new ArrayList<>();
        Map<String,String> cureveInfoMap= new HashMap<>();
        List<WellLasCurveInfo> wellLasCurveInfoList = new ArrayList<WellLasCurveInfo>();
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

    @Override
    public List<WellLasCurveInfo> getCurveByLasInfoId(int lasInfoId) {
        LambdaQueryWrapper<WellLasCurveInfo> lambdaQuery = new LambdaQueryWrapper<>();
        lambdaQuery.eq(WellLasCurveInfo::getLasInfoId, lasInfoId);

        return wellLasCurveInfoMapper.selectList(lambdaQuery);
    }


    public WellLasCurveInfo mapToEntity(Map<String,String> curveInfoMap,int lasInfoId){
        WellLasCurveInfo wellLasCurveInfo = new WellLasCurveInfo();
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




