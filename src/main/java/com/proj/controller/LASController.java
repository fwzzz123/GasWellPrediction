package com.proj.controller;


import com.proj.entity.WellLAS;
import com.proj.service.WellInfoService;
import com.proj.service.WellLasCurveInfoService;
import com.proj.service.WellLasInfoService;
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
    private WellLasCurveInfoService wellLasCurveInfoService;

    @Autowired
    private WellInfoService wellInfoService;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
        try {
            WellLAS wellLAS = new WellLAS();
            wellLAS.setName(file.getOriginalFilename());
            wellLAS.setLasFile(file.getBytes());  // 获取文件二进制内容

//            int result = lasMapper.insertWellLAS(wellLAS);  // 调用 MyBatis 插入操作

            int result = wellInfoService.insertWellLAS(wellLAS);

            if (result > 0) {
                return ResponseEntity.ok("文件上传并存入数据库成功，井ID：" + wellLAS.getId());
            } else {
                return ResponseEntity.status(500).body("文件上传失败");
            }
        } catch (IOException e) {
            return ResponseEntity.status(500).body("文件上传失败: " + e.getMessage());
        }
    }

//
    @GetMapping("/download/{id}")
    public ResponseEntity<byte[]> downloadFile(@PathVariable Long id) {
        WellLAS file = wellInfoService.getById(id);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "attachment; filename=\"" + file.getName() + "\"")
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(file.getLasFile());
    }


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

            String wellID = file.getOriginalFilename().split("_")[0];
            wellLasInfoMap.put("Well_ID",wellID);

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
            int lasInfoId = wellLasInfoService.savelas(wellLasInfoMap);
            wellLasCurveInfoService.savelas(file,lasInfoId);
        }
        return ResponseEntity.ok("ok");
    }
}
