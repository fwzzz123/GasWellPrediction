package com.proj.controller;


import com.proj.entity.dto.CurveMappingDTO;
import com.proj.entity.dto.ImportResultDTO;
import com.proj.entity.po.WellInfoPO;
import com.proj.entity.po.WellLasPO;
import com.proj.entity.po.WellLogCurveMappingPO;
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

    @Autowired
    private WellLogCurveMappingService wellLogCurveMappingService;

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
    public ResponseEntity<String> getLasInfo(@RequestParam("files") List<MultipartFile> files) {
        if (files == null || files.isEmpty()) {
            return ResponseEntity.badRequest().body("未提供文件");
        }
        try {
            for(MultipartFile file: files) {
                String lasInfoId = wellLasInfoService.savelas(file);
                wellLasCurveInfoService.savelas(file, lasInfoId);
            }
        }catch (Exception e){
            e.printStackTrace();
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

    //根据解析的表头插入Well_Log数据，传入的参数是/parseCurveHeader API的返回参数
    @PostMapping("/insertWellLogFromParsedHeader")
    public ResponseEntity<String> insertWellLogFromParsedHeader(@RequestParam("files") List<MultipartFile> files) {
        try {
            // 调用服务层方法
            wellLasInfoService.insertWellLogFromParsedHeader(files);
            return ResponseEntity.ok("Well_Log 数据插入成功");
        } catch (Exception e) {
            // 打印日志用于排查问题
            e.printStackTrace();

            // 判断是否是唯一约束冲突（主键或唯一索引冲突）
            if (e.getMessage().contains("duplicate key value violates unique constraint")) {
                return ResponseEntity.status(400).body("数据名重复");
            }

            // 其他异常统一返回服务器错误
            return ResponseEntity.status(500).body("Well_Log 数据插入失败: " + e.getMessage());
        }
    }

    //根据las测井文件插入well_log
    @PostMapping("/saveCurveMappings")
    public ResponseEntity<String> saveCurveMappings1(@RequestBody List<CurveMappingDTO> mappingList) {
        if (mappingList == null || mappingList.isEmpty()) {
            return ResponseEntity.badRequest().body("提交内容为空");
        }

        LocalDateTime now = LocalDateTime.now();
        List<WellLogCurveMappingPO> allMappings = new ArrayList<>();

        for (CurveMappingDTO fileMapping : mappingList) {
            String fileName = fileMapping.getFileName();

            // 检查并插入 Well_Log 表
            String wellLogId = wellLogService.checkAndInsertWellLog(fileName);

            for (CurveMappingDTO.CurveDTO curve : fileMapping.getCurves()) {
                WellLogCurveMappingPO mappingPO = new WellLogCurveMappingPO();
                mappingPO.setWellLogId(wellLogId);
                mappingPO.setLasCurveName(curve.getLasCurveName());
                mappingPO.setStandardFieldName(curve.getStandardFieldName());
                mappingPO.setCreateTime(now);
                mappingPO.setUpdateTime(now);

                allMappings.add(mappingPO);
            }
        }

        // 保存 CurveMappings
        if (!allMappings.isEmpty()) {
            wellLogCurveMappingService.saveCurveMappings(allMappings);
        }

        return ResponseEntity.ok("映射关系保存成功");
    }

    //根据mapping映射存储标准化信息
    @PostMapping("/ac_mapping_savewelllogdata")
    public ResponseEntity<ImportResultDTO> ac_mapping_savewelllogdata(@RequestParam("files") List<MultipartFile> files) {
        if (files == null || files.isEmpty()) {
            ImportResultDTO dto = new ImportResultDTO();
            dto.setSuccess(false);
            dto.setMessage("未提供文件");
            return ResponseEntity.badRequest().body(dto);
        }

        try {
            // 调用 service 获取结构化返回值
            ImportResultDTO resultDTO = wellLogDataService.ac_mapping_savewelllogdata(files).getBody();
            return ResponseEntity.ok(resultDTO);
        } catch (Exception e) {
            e.printStackTrace();

            ImportResultDTO dto = new ImportResultDTO();
            dto.setSuccess(false);
            dto.setMessage("保存失败：" + e.getMessage());
            return ResponseEntity.status(500).body(dto);
        }
    }

}
