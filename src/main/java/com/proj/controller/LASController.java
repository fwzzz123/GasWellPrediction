package com.proj.controller;


import com.proj.entity.dto.CurveMappingDTO;
import com.proj.entity.po.WellInfoPO;
import com.proj.entity.po.WellLasPO;
import com.proj.entity.po.WellLogCurveMappingPO;
import com.proj.entity.vo.WellLogCurveMappingVO;
import com.proj.service.*;
import com.proj.utils.NamingUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/import")
@CrossOrigin//支持跨域
public class LASController {
    @Autowired
    private WellLasInfoService wellLasInfoService;

    @Autowired
    private WellLogService wellLogService;

    @Autowired
    private WellLasCurveInfoService wellLasCurveInfoService;

    @Autowired
    private WellInfoService wellInfoService;

    @Autowired
    private WellLogDataService wellLogDataService ;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
        try {
            WellLasPO wellLasPO = new WellLasPO();
            wellLasPO.setName(file.getOriginalFilename());
            wellLasPO.setLasFile(file.getBytes());  // 获取文件二进制内容

            wellInfoService.insertWellLAS(wellLasPO);

            return ResponseEntity.ok("文件上传并存入数据库成功，井ID：" + wellLasPO.getId());
        } catch (IOException e) {
            return ResponseEntity.status(500).body("文件上传失败: " + e.getMessage());
        }
    }

    @GetMapping("/download/{id}")
    public ResponseEntity<byte[]> downloadFile(@PathVariable Long id) {
        WellLasPO file = wellInfoService.getById(id);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "attachment; filename=\"" + file.getName() + "\"")
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(file.getLasFile());
    }

    //用户上传las文件，解析las文件内容插入到WellLasInfo和WellLasCurveInfo俩个表中
    //插入到WellLasInfo表中解决外键问题先看wellId是否存在若不存在则插入WellInfo表中
    @PostMapping("/getlasinfo")
    public ResponseEntity<String> getLasInfo(@RequestParam("files") List<MultipartFile> files){
        //Map<String, String> wellInfoMap = new LinkedHashMap<>();
        //Map<String, String> wellInfoDesMap = new LinkedHashMap<>();

        //Map<String, String> curveInfoMap = new LinkedHashMap<>();
        //Map<String, String> curveInfoDesMap = new LinkedHashMap<>();
        //List<WellLasInfo> wellLasInfoList = new ArrayList<>();

        //WellLasInfo wellLasInfo = new WellLasInfo();
        if(files.isEmpty()){
            return ResponseEntity.badRequest().body("未提供文件");
        }
        for(MultipartFile file:files){
            String line;
            Map<String, String> wellLasInfoMap = new LinkedHashMap<>();
            //Map<String, String> curveInfoMap = new LinkedHashMap<>();
            boolean inWellInformationBlock = false;
            //boolean inCurveInformationBlock = false;
            //boolean inDataBlock = false;

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
                            //inCurveInformationBlock = true;
                        }
                        /*if (line.startsWith("~P") || line.startsWith("~O")) {
                            inCurveInformationBlock = false;
                        }
                        if (line.startsWith("~A")) {
                            inCurveInformationBlock = false;
                            inDataBlock = true;
                        }*/


                        if (inWellInformationBlock) {
                            if (!line.startsWith("~")) {
                                String key = NamingUtils.toCamelCase(line.substring(0, line.indexOf(".")).trim());
                                String value = line.substring(line.indexOf(".") + 1).split(":")[0].replaceAll(" ", "");
                                //String description = line.split(":")[1].trim();
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
                                /*if (!wellInfoDesMap.containsKey(key)) {
                                    wellInfoDesMap.put(key, description);
                                }*/
                            }
                        }

                    }
                }

            }catch (IOException e){
                return ResponseEntity.badRequest().body("读取失败");
            }
            System.out.println(wellLasInfoMap);
            String lasInfoId = String.valueOf(wellLasInfoService.savelas(wellLasInfoMap));
            wellLasCurveInfoService.savelas(file,lasInfoId);
        }
        return ResponseEntity.ok("测井表头插入成功");
    }

    //识别~W的表头
    //4.11修改这个service，4。14修改完成
    @PostMapping("/parseWellHeader")
    public ResponseEntity<List<Map<String, Object>>> parseWellHeader(@RequestParam("files") List<MultipartFile> files) {
        if (files.isEmpty()) {
            return ResponseEntity.badRequest().body(null);
        }

        List<Map<String, Object>> result = wellLasInfoService.parseWellHeader(files);
        return ResponseEntity.ok(result);
    }

    //识别~C的曲线表头
    //4.11修改这个service，4。14修改完成
    @PostMapping("/parseCurveHeader")
    public ResponseEntity<List<Map<String, Object>>> parseCurveHeader(@RequestParam("files") List<MultipartFile> files) {
        if (files.isEmpty()) {
            return ResponseEntity.badRequest().body(null);
        }

        List<Map<String, Object>> result = wellLasInfoService.parseCurveHeader(files);
        return ResponseEntity.ok(result);
    }



    @PostMapping("/saveCurveMappings")
    public ResponseEntity<String> saveCurveMappings1(@RequestBody List<CurveMappingDTO> mappingList) {
        if (mappingList == null || mappingList.isEmpty()) {
            return ResponseEntity.badRequest().body("提交内容为空");
        }

        LocalDateTime now = LocalDateTime.now();
        List<WellLogCurveMappingPO> allMappings = new ArrayList<>();

        for (CurveMappingDTO fileMapping : mappingList) {
            String fileName = fileMapping.getFileName();

            // 你可能需要一个方式来获取 wellLogId（根据 fileName）
            Long wellLogId = wellLogService.getWellLogIdByFileName(fileName);

            if (wellLogId == null) {
                continue;
            }

            for (CurveMappingDTO.CurveDTO curve : fileMapping.getCurves()) {
                WellLogCurveMappingPO mappingPO = new WellLogCurveMappingPO();
                mappingPO.setWellLogId(wellLogId);
                mappingPO.setLasCurveName(curve.getLasCurveName());
                mappingPO.setStandardFieldName(curve.getStandardFieldName()); // ✅ 用新的字段名
                mappingPO.setCreateTime(now);
                mappingPO.setUpdateTime(now);

                allMappings.add(mappingPO);
            }
        }

        if (!allMappings.isEmpty()) {
            wellInfoService.insertCurveMapping(allMappings); // 批量插入
        }

        return ResponseEntity.ok("映射关系保存成功");
    }

    //根据mapping映射存储标准化信息
    @PostMapping("/ac_mapping_savewelllogdata")
    public ResponseEntity<String> ac_mapping_savewelllogdata(@RequestParam("files") List<MultipartFile> files){
        if(files.isEmpty()){
            return ResponseEntity.badRequest().body("未提供文件");
        }
       try {
            wellLogDataService.ac_mapping_savewelllogdata(files);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().body("保存失败");
        }

        return ResponseEntity.ok("根据映射关系导入业务信息成功");
    }

}
