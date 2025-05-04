package com.proj.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.proj.entity.WellLasInfo;
import com.proj.entity.po.WellInfoPO;
import com.proj.entity.po.WellLogPO;
import com.proj.mapper.WellLasInfoMapper;
import com.proj.mapper.WellLogMapper;
import com.proj.mapper.WellMapper;
import com.proj.service.WellInfoService;
import com.proj.service.WellLasInfoService;
import com.proj.utils.NamingUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.beans.BeanMap;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
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

    @Autowired
    private WellLogMapper wellLogMapper;

    @Autowired
    private WellInfoService wellInfoService;

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




    @Override
    public void insertWellLogFromParsedHeader(List<MultipartFile> files) {
        // 调用 parseWellHeader 方法生成 parsedHeaders
        List<Map<String, Object>> parsedHeaders = parseWellHeader(files);

        // 原有逻辑保持不变
        if (parsedHeaders == null || parsedHeaders.isEmpty()) {
            throw new IllegalArgumentException("解析后的头部信息为空");
        }

        for (Map<String, Object> header : parsedHeaders) {
            String fileName = (String) header.get("fileName");
            Map<String, Object> wellHeader = (Map<String, Object>) header.get("wellHeader");

            // 提取字段
            String wellId = fileName;
            String id = fileName.split("\\(")[0]; // 提取文件名部分
            Double startDepth = parseDepth((String) wellHeader.get("strt"));
            Double endDepth = parseDepth((String) wellHeader.get("stop"));
            Double step = parseStep((String) wellHeader.get("step"));

            // 检查 Well_Info 表中是否存在 Well_ID 为 fileName 的记录
            boolean wellExists = wellInfoService.existsByWellId(wellId);
            if (!wellExists) {
                // 如果不存在，则插入新记录
                WellInfoPO wellInfo = new WellInfoPO();
                wellInfo.setWellId(wellId);
                wellInfoService.createWellInfo(wellInfo);
            }

            // 创建 WellLogPO 对象
            WellLogPO wellLogPO = new WellLogPO();
            wellLogPO.setId(id);
            wellLogPO.setWellId(wellId);
            wellLogPO.setStartDepth(startDepth);
            wellLogPO.setEndDepth(endDepth);
            wellLogPO.setStep(step);
            wellLogPO.setCreateTime(LocalDateTime.now());
            wellLogPO.setUpdateTime(LocalDateTime.now());

            // 插入数据库
            wellLogMapper.insert(wellLogPO);
        }
    }

    /**
     * 解析深度字段（去除前缀 M 并转换为数值）
     * @param value 原始值
     * @return 解析后的数值
     */
    private Double parseDepth(String value) {
        if (value == null || !value.startsWith("M")) {
            return null;
        }
        return Double.parseDouble(value.substring(1));
    }

    /**
     * 解析步长字段（去除前缀 M 并转换为数值）
     * @param value 原始值
     * @return 解析后的数值
     */
    private Double parseStep(String value) {
        if (value == null || !value.startsWith("M")) {
            return null;
        }
        return Double.parseDouble(value.substring(1));
    }

}




