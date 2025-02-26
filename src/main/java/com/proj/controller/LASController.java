package com.proj.controller;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/import")
@CrossOrigin//支持跨域
public class LASController {
    private String LasFile = "rightLasFile";

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

}
