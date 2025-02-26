package com.proj.controller;

import com.proj.domain.po.WellLAS;
import com.proj.mapper.LASMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/import")
@CrossOrigin
public class WellController {

    @Autowired
    private LASMapper lasMapper;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
        try {
            WellLAS wellLAS = new WellLAS();
            wellLAS.setName(file.getOriginalFilename());
            wellLAS.setLasFile(file.getBytes());  // 获取文件二进制内容
            int result = lasMapper.insertWellLAS(wellLAS);  // 调用 MyBatis 插入操作

            if (result > 0) {
                return ResponseEntity.ok("文件上传并存入数据库成功，井ID：" + wellLAS.getId());
            } else {
                return ResponseEntity.status(500).body("文件上传失败");
            }
        } catch (IOException e) {
            return ResponseEntity.status(500).body("文件上传失败: " + e.getMessage());
        }
    }

    @GetMapping("/download/{id}")
    public ResponseEntity<byte[]> downloadFile(@PathVariable Long id) {
        WellLAS wellLAS = lasMapper.getWellLASById(id);  // 根据 ID 查询文件

        if (wellLAS != null) {
            return ResponseEntity.ok()
                    .header("Content-Disposition", "attachment; filename=" + wellLAS.getName())
                    .body(wellLAS.getLasFile());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
