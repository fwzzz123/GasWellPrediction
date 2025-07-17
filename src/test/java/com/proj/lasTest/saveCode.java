package com.proj.lasTest;

import com.proj.entity.po.WellInfoPO;
import com.proj.utils.NamingUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class saveCode {
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
            //String lasInfoId = String.valueOf(wellLasInfoService.savelas(wellLasInfoMap));
            //wellLasCurveInfoService.savelas(file,lasInfoId);
        }
        return ResponseEntity.ok("测井表头插入成功");
    }
}
