package com.proj.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.proj.entity.po.FolderPO;
import com.proj.entity.po.WellInfoPO;
import com.proj.service.FolderPOService;
import com.proj.service.WellInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/folder")
@CrossOrigin
public class FolderController {

    @Autowired
    private FolderPOService folderPOService;

    @Autowired
    private WellInfoService wellInfoService;

    @PostMapping("/add")
    public ResponseEntity<String> addFolder(@RequestBody Map<String, String> request) {
        // 1. 从 JSON 请求中获取 folderName
        String folderName = request.get("folderName");

        // 2. 打印原始接收值用于调试
        System.out.println("实际接收到的值：" + folderName);

        // 3. 校验参数
        if (folderName == null || folderName.trim().isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("文件夹名称不能为空");
        }

        // 4. 检查文件夹是否已存在
        if (folderPOService.existsByFolderName(folderName)) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("文件夹已存在");
        }

        // 5. 创建并保存文件夹对象
        FolderPO folderPO = new FolderPO();
        folderPO.setFolderName(folderName);
        folderPOService.save(folderPO);

        return ResponseEntity.ok("添加成功");
    }


    //获取所有文件夹名
    @GetMapping("/getAll")
    public List<String> getAll(){
        LambdaQueryWrapper<FolderPO> query = new LambdaQueryWrapper<>();
        query.select(FolderPO::getFolderName);

        List<FolderPO> list = folderPOService.list(query);
        return list.stream()
                .map(FolderPO::getFolderName)
                .collect(Collectors.toList());
    }

    //根据文件夹名查询井名
    @PostMapping("/getWellNameByFolderName")
    public List<String> getWellNameByFolderName(@RequestParam String folderName){
        LambdaQueryWrapper<WellInfoPO> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(WellInfoPO::getFolderName, folderName);
        queryWrapper.select(WellInfoPO::getWellId); // 只查询 well_id 字段

        return wellInfoService.list(queryWrapper)
                .stream()
                .map(WellInfoPO::getWellId)
                .collect(Collectors.toList());
    }

    @PostMapping("/delFolderByFolderName")
    public ResponseEntity<String> delWellByFolderName(@RequestParam List<String> folderNames){
        if (folderNames == null || folderNames.isEmpty()) {
            return ResponseEntity.badRequest().body("文件夹名称不能为空");
        }

        for (String folderName : folderNames) {
            //判断文件夹是否为空：查询该文件夹下的所有井
            if (wellInfoService.existsByFolderName(folderName)) {
                return ResponseEntity.status(HttpStatus.CONFLICT).body("文件夹 [" + folderName + "] 不为空，无法删除");
            }
        }
        boolean success = folderPOService.removeBatchByFolderNames(folderNames);

        if (success) {
            return ResponseEntity.ok("删除文件夹成功!");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("删除失败,文件名可能不存在!");
        }
    }

    @PostMapping("/renameFolder")
    public ResponseEntity<String> renameFolder(@RequestParam String oldFolderName, @RequestParam String newFolderName) {
        if (!folderPOService.renameFolder(oldFolderName, newFolderName)) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("文件夹重命名失败，请检查文件名重复！");
        }
        return ResponseEntity.ok("文件夹重命名成功");
    }
}
