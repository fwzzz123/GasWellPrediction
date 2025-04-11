package com.proj.controller;


import com.proj.entity.po.WellInfoPO;
import com.proj.entity.po.WellLasPO;
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

            String wellID = file.getOriginalFilename().split("_")[0];
            //检验是否存在，不存在则添加到WellInfo表中
            if(wellInfoService.getByWellId(wellID)==null){
                WellInfoPO wellInfo = new WellInfoPO();
                wellInfo.setWellId(wellID);
                if(wellID.startsWith("BD")){
                    wellInfo.setReservoirId(1);
                }
                if(wellID.startsWith("DF1-")){
                    wellInfo.setReservoirId(2);
                }
                if(wellID.startsWith("DF13")){
                    wellInfo.setReservoirId(3);
                }
                wellInfoService.insert(wellInfo);
            }
            wellLasInfoMap.put("wellId",wellID);

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
            int lasInfoId = wellLasInfoService.savelas(wellLasInfoMap);
            wellLasCurveInfoService.savelas(file,lasInfoId);
        }
        return ResponseEntity.ok("ok");
    }
}
