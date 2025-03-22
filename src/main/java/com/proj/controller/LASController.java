package com.proj.controller;


import com.proj.entity.WellLasInfo;
import com.proj.service.WellLasCurveInfoService;
import com.proj.service.WellLasInfoService;
import com.proj.utils.NamingUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/import")
@CrossOrigin//支持跨域
public class LASController {
    private String LasFile = "rightLasFile";

    @Autowired
    private WellLasInfoService wellLasInfoService;

    @Autowired
    private WellLasCurveInfoService wellLasCurveInfoService;

    @GetMapping("/getlas")
    public String getLasFile(){
        return LasFile;
    }
//
//    private static final String UPLOAD_DIR = "/root/LAS";
//
//
//    @PostMapping("/upload")
//    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
//
//        System.out.println("收到上传请求：" + file.getOriginalFilename());
//
//        if (file.isEmpty()) {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("上传失败，文件为空");
//        }
//
//        try {
//            // 确保上传目录存在
//            File uploadDir = new File(UPLOAD_DIR);
//            if (!uploadDir.exists()) {
//                uploadDir.mkdirs();
//            }
//
//            // 目标文件路径
//            String filePath = UPLOAD_DIR + file.getOriginalFilename();
//            File destFile = new File(filePath);
//
//            // 保存文件
//            file.transferTo(destFile);
//            return ResponseEntity.ok("文件上传成功: " + file.getOriginalFilename());
//
//        } catch (IOException e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("文件上传失败: " + e.getMessage());
//        }
//    }
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
