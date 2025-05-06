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
import org.springframework.http.ResponseEntity;
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
    public String savelas(MultipartFile file) {
        String line;
        Map<String, String> wellLasInfoMap = new LinkedHashMap<>();
        boolean inWellInformationBlock = false;
        //从文件名中提取wellId作为主键
        String wellId = file.getOriginalFilename().split("_")[0];

        WellInfoPO existing = wellInfoService.getByWellName(wellId);
        if (existing == null) {
            WellInfoPO wellInfo = new WellInfoPO();
            wellInfo.setWellId(wellId);
            if (wellId.startsWith("BD")) {
                wellInfo.setReservoirId(1);
            } else if (wellId.startsWith("DF1-")) {
                wellInfo.setReservoirId(2);
            } else if (wellId.startsWith("DF13")) {
                wellInfo.setReservoirId(3);
            }else {
                // 如果没有匹配到已知前缀，设置为null或默认值
                wellInfo.setReservoirId(null); // 或者设置一个默认值如：0
            }
            wellInfoService.insert(wellInfo);
        }
        wellLasInfoMap.put("wellId", wellId);
        //让文件名作为唯一主键，方便后续查询指定文件内容
        wellLasInfoMap.put("lasInfoId", file.getOriginalFilename());

        try(BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))){
            while ((line = reader.readLine())!=null){
                if (!line.startsWith("#")){
                    if (line.startsWith("~W")) {
                        inWellInformationBlock = true;
                    }
                    if (line.startsWith("~C")) {
                        inWellInformationBlock = false;
                    }
                    if (inWellInformationBlock) {
                        if (!line.startsWith("~")) {
                            String key = NamingUtils.toCamelCase(line.substring(0, line.indexOf(".")).trim());
                            String value = line.substring(line.indexOf(".") + 1).split(":")[0].replaceAll(" ", "");
                            // 存储到HashMap中，避免重复键
                            if(key.equals("null")){
                                key="absentValue";
                            }
                            if(key.equals("long")){
                                key="wellLong";
                            }
                            if(value.equals("")){
                                value="null";
                            }
                            if (!wellLasInfoMap.containsKey(key)) {
                                wellLasInfoMap.put(key, value);
                            }
                        }
                    }

                }
            }

        }catch (IOException e){
            e.printStackTrace();
        }
        WellLasInfo wellLasInfo = new WellLasInfo();
        BeanMap beanMap = BeanMap.create(wellLasInfo);
        for(Map.Entry<String,String> entry : wellLasInfoMap.entrySet()){
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

                            // ✅ 新增：跳过注释性字段（如 #MNEM、#DEPTH 等）
                            if (lasCurveName.startsWith("#") ||
                                    lasCurveName.toUpperCase().startsWith("#MNEM") ||
                                    "unit".equalsIgnoreCase(lasCurveName) ||
                                    "value".equalsIgnoreCase(lasCurveName)) {
                                continue;
                            }

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




    //    @Override
//    public void insertWellLogFromParsedHeader(List<MultipartFile> files) {
//        // 调用 parseWellHeader 方法生成 parsedHeaders
//        List<Map<String, Object>> parsedHeaders = parseWellHeader(files);
//
//        // 原有逻辑保持不变
//        if (parsedHeaders == null || parsedHeaders.isEmpty()) {
//            throw new IllegalArgumentException("解析后的头部信息为空");
//        }
//
//        for (Map<String, Object> header : parsedHeaders) {
//            String fileName = (String) header.get("fileName");
//            Map<String, Object> wellHeader = (Map<String, Object>) header.get("wellHeader");
//
//            // 提取字段
//            String wellId = fileName;
//            String id = fileName.split("\\(")[0]; // 提取文件名部分
//            Double startDepth = parseDepth((String) wellHeader.get("strt"));
//            Double endDepth = parseDepth((String) wellHeader.get("stop"));
//            Double step = parseStep((String) wellHeader.get("step"));
//
//            // 检查 Well_Info 表中是否存在 Well_ID 为 fileName 的记录
//            boolean wellExists = wellInfoService.existsByWellId(wellId);
//            if (!wellExists) {
//                // 如果不存在，则插入新记录
//                WellInfoPO wellInfo = new WellInfoPO();
//                wellInfo.setWellId(wellId);
//                wellInfoService.createWellInfo(wellInfo);
//            }
//
//            // 创建 WellLogPO 对象
//            WellLogPO wellLogPO = new WellLogPO();
//            wellLogPO.setId(wellId);
//            wellLogPO.setWellId(id);
//            wellLogPO.setStartDepth(startDepth);
//            wellLogPO.setEndDepth(endDepth);
//            wellLogPO.setStep(step);
//            wellLogPO.setCreateTime(LocalDateTime.now());
//            wellLogPO.setUpdateTime(LocalDateTime.now());
//
//            // 插入数据库
//            wellLogMapper.insert(wellLogPO);
//        }
//    }
    @Override
    public void insertWellLogFromParsedHeader(List<MultipartFile> files) {
        List<Map<String, Object>> parsedHeaders = parseWellHeader(files);

        if (parsedHeaders == null || parsedHeaders.isEmpty()) {
            throw new IllegalArgumentException("解析后的头部信息为空");
        }

        for (Map<String, Object> header : parsedHeaders) {
            String fileName = (String) header.get("fileName");
            Map<String, Object> wellHeader = (Map<String, Object>) header.get("wellHeader");

            // id 保持原文件名（如 well1.las）
            String id = fileName;

            // wellId 是去掉 .las/.LAS/.Las 后缀的井名（如 well1）
            String wellId = removeExtension(fileName);

            Double startDepth = parseDepth((String) wellHeader.get("strt"));
            Double endDepth = parseDepth((String) wellHeader.get("stop"));
            Double step = parseStep((String) wellHeader.get("step"));

            // 检查 Well_Info 表是否存在对应记录
            boolean wellExists = wellInfoService.existsByWellId(wellId);
            if (!wellExists) {
                WellInfoPO wellInfo = new WellInfoPO();
                wellInfo.setWellId(wellId);
                wellInfoService.createWellInfo(wellInfo);
            }

            // 创建并保存 WellLogPO
            WellLogPO wellLogPO = new WellLogPO();
            wellLogPO.setId(id);           // 保留原始文件名作为 ID
            wellLogPO.setWellId(wellId);   // 去掉后缀作为井名
            wellLogPO.setStartDepth(startDepth);
            wellLogPO.setEndDepth(endDepth);
            wellLogPO.setStep(step);
            wellLogPO.setCreateTime(LocalDateTime.now());
            wellLogPO.setUpdateTime(LocalDateTime.now());

            wellLogMapper.insert(wellLogPO);
        }
    }

    /**
     * 移除文件名的扩展名（支持 .las/.LAS/.Las 等格式）
     */
    private String removeExtension(String fileName) {
        if (fileName == null || fileName.isEmpty()) {
            return fileName;
        }

        int dotIndex = -1;
        // 从后往前找 .las 或 .LAS 或 .Las
        for (int i = 0; i < 3 && i < fileName.length(); i++) {
            int pos = fileName.length() - 1 - i;
            if ((pos >= 0) && (fileName.charAt(pos) == 's' || fileName.charAt(pos) == 'S')) {
                // 可能是 .las 结尾
                if (pos >= 4 && fileName.regionMatches(true, pos - 3, ".las", 0, 4)) {
                    dotIndex = pos - 3;
                    break;
                }
            }
        }

        if (dotIndex > 0) {
            return fileName.substring(0, dotIndex);
        }

        return fileName;
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




