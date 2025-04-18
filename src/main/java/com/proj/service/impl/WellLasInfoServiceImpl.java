package com.proj.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.proj.entity.WellLasInfo;
import com.proj.mapper.WellLasInfoMapper;
import com.proj.mapper.WellMapper;
import com.proj.service.WellLasInfoService;
import com.proj.utils.NamingUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.beans.BeanMap;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
* @author L
* @description 针对表【Well_Las_Info】的数据库操作Service实现
* @createDate 2025-03-21 13:32:45
*/
@Service
public class WellLasInfoServiceImpl extends ServiceImpl<WellLasInfoMapper, WellLasInfo>
    implements WellLasInfoService{

    @Autowired
    private WellLasInfoMapper wellLasInfoMapper;

    @Autowired
    private WellMapper wellMapper;

    @Override
    public String savelas(Map<String, String> wellInfoMap) {
        WellLasInfo wellLasInfo = new WellLasInfo();
        BeanMap beanMap = BeanMap.create(wellLasInfo);
        for(Map.Entry<String,String> entry : wellInfoMap.entrySet()){
            if(beanMap.containsKey(entry.getKey())){
                beanMap.put(entry.getKey(),entry.getValue());
            }
        }
        wellLasInfoMapper.insert(wellLasInfo);
        return  wellLasInfo.getLasInfoId();
    }

    @Override
    public List<WellLasInfo> getWellLas() {
        return wellLasInfoMapper.selectList(null);
    }

    @Override
    public List<WellLasInfo> getWellLasByWellId(String wellId) {
        LambdaQueryWrapper<WellLasInfo> lambdaQuery = new LambdaQueryWrapper<>();
        lambdaQuery.eq(WellLasInfo::getWellId, wellId);
        return wellLasInfoMapper.selectList(lambdaQuery);
    }

    @Override
    public List<Map<String, Object>> parseWellHeader(List<MultipartFile> files) {
        List<Map<String, Object>> result = new ArrayList<>();

        for (MultipartFile file : files) {
            Map<String, String> wellLasInfoMap = new LinkedHashMap<>();
            boolean inWellInformationBlock = false;

            try (BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    if (!line.startsWith("#")) {
                        if (line.startsWith("~W")) {
                            inWellInformationBlock = true;
                            continue;
                        }

                        if (line.startsWith("~") && !line.startsWith("~W")) {
                            inWellInformationBlock = false;
                        }

                        if (inWellInformationBlock && !line.startsWith("~") && line.contains(".")) {
                            try {
                                String key = NamingUtils.toCamelCase(line.substring(0, line.indexOf(".")).trim());
                                String value = line.substring(line.indexOf(".") + 1).split(":")[0].replaceAll(" ", "");
                                if (key.equals("null")) key = "absentValue";
                                if (key.equals("long")) key = "wellLong";
                                if (value.equals("")) value = "null";
                                wellLasInfoMap.putIfAbsent(key, value);
                            } catch (Exception e) {
                                continue;
                            }
                        }
                    }
                }

                Map<String, Object> oneResult = new HashMap<>();
                oneResult.put("fileName", file.getOriginalFilename());
                oneResult.put("wellHeader", wellLasInfoMap);
                result.add(oneResult);

            } catch (IOException e) {
                throw new RuntimeException("解析失败", e);
            }
        }

        return result;
    }

    @Override
    public List<Map<String, Object>> parseCurveHeader(List<MultipartFile> files) {
        List<Map<String, Object>> result = new ArrayList<>();

        for (MultipartFile file : files) {
            Map<String, Object> fileResult = new HashMap<>();
            List<Map<String, String>> curveList = new ArrayList<>();
            boolean inCurveBlock = false;

            try (BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    line = line.trim();
                    if (line.startsWith("~C")) {
                        inCurveBlock = true;
                        continue;
                    }

                    if (inCurveBlock && line.startsWith("~")) {
                        break;
                    }

                    if (inCurveBlock && !line.isEmpty() && line.contains(".")) {
                        try {
                            String lasCurveName = line.substring(0, line.indexOf(".")).trim();
                            String description = line.contains(":") ? line.substring(line.indexOf(":") + 1).trim() : "";

                            Map<String, String> curveInfo = new HashMap<>();
                            curveInfo.put("lasCurveName", lasCurveName);
                            curveInfo.put("description", description);
                            curveList.add(curveInfo);
                        } catch (Exception e) {
                            continue;
                        }
                    }
                }

                fileResult.put("fileName", file.getOriginalFilename());
                fileResult.put("curves", curveList);
                result.add(fileResult);

            } catch (IOException e) {
                throw new RuntimeException("解析失败", e);
            }
        }

        return result;
    }


}




