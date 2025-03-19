//package com.proj.lasTest;
//
//
//import org.junit.jupiter.api.Test;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.io.File;
//import java.io.IOException;
//import java.nio.file.Files;
//import java.util.LinkedHashMap;
//import java.util.List;
//import java.util.Map;
//
//
//@SpringBootTest
//class lasDecoder {
//
//    @Test
//    public void lasDecoder() {
//        String folderPath = "D:\\海南项目数据\\LASFile";
//
//        Map<String, String> wellInfoMap = new LinkedHashMap<>();
//        Map<String, String> curveInfoMap = new LinkedHashMap<>();
//        String[] data = null;
//
//        // 获取文件夹内所有的文件
//        File folder = new File(folderPath);
//
//        // 确保这是一个目录
//        if (folder.isDirectory()) {
//            // 获取所有文件
//            File[] files = folder.listFiles();
//
//            // 如果目录内有文件
//            if (files != null) {
//                for (File file : files) {
//                    // 判断是否是文件且扩展名是.txt
//                    if (file.isFile() && file.getName().endsWith(".LAS")) {
//                        // 读取文件内容
//                        List<String> lines = null;
//                        try {
//                            lines = Files.readAllLines(file.toPath());
//                        } catch (IOException e) {
//                            e.printStackTrace();
//                        }
//                        boolean inWellInformationBlock = false;
//                        boolean inCurveInformationBlock = false;
//                        boolean inDataBlock = false;
//
//                        for (String line : lines) {
//                            if (!line.startsWith("#")) {
//                                if (line.startsWith("~W")) {
//                                    inWellInformationBlock = true;
//                                }
//                                if (line.startsWith("~C")) {
//                                    inWellInformationBlock = false;
//                                    inCurveInformationBlock = true;
//                                }
//                                if (line.startsWith("~P") || line.startsWith("~O")) {
//                                    inCurveInformationBlock = false;
//                                }
//                                if (line.startsWith("~A")) {
//                                    inCurveInformationBlock = false;
//                                    inDataBlock = true;
//                                }
//
//                                // 如果在Well Information Block内，提取相关数据
//                                if (inWellInformationBlock) {
//                                    if (!line.startsWith("~")) {
//                                        String key = line.substring(0, line.indexOf(".")).trim();
//                                        String value = line.substring(line.indexOf(".") + 1).split(":")[0].replaceAll(" ", "");
//
//                                        // 存储到HashMap中，避免重复键
//                                        if (!wellInfoMap.containsKey(key)) {
//                                            wellInfoMap.put(key, value);
//                                        }
//                                    }
//                                }
//
//                                if (inCurveInformationBlock) {
//                                    if (!line.startsWith("~")) {
//                                        String key = line.substring(0, line.indexOf(".")).trim();
//                                        String value = line.substring(line.indexOf(".") + 1).split(":")[0].replaceAll(" ", "");
//
//                                        // 存储到HashMap中，避免重复键
//                                        if (!curveInfoMap.containsKey(key)) {
//                                            curveInfoMap.put(key, value);
//                                        }
//                                    }
//                                }
//
//                                if (inDataBlock) {
//                                    if (!line.startsWith("~")) {
//                                        data = line.split("\\s+");
//                                        //for (int i = 0; i < data.length; i++) {
//                                        //后续插入数据只需要根据curveInfoMap的键来对应data插入
//                                        //System.out.println(data[i]);
//                                        //}
//                                    }
//                                }
//                            }
//
//                        }
//                    }
//                }
//            } else {
//                System.out.println(folderPath + " is not a valid directory.");
//            }
//        }
//
//        // 输出HashMap内容
//        System.out.println("Extracted Well Information:");
//        for (Map.Entry<String, String> entry : wellInfoMap.entrySet()) {
//            System.out.println(entry.getKey() + ": " + entry.getValue());
//        }
//
//        System.out.println("------------------------------------------------");
//        System.out.println("Extracted Curve Information:");
//        for (Map.Entry<String, String> entry : curveInfoMap.entrySet()) {
//            System.out.println(entry.getKey() + ": " + entry.getValue());
//        }
//
//    }
//
//
//}
