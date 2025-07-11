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
import java.util.stream.Collectors;

@RestController
@RequestMapping("/folder")
@CrossOrigin
public class FolderController {

    @Autowired
    private FolderPOService folderPOService;

    @Autowired
    private WellInfoService wellInfoService;

    //添加文件夹名
    @PostMapping("/add")
    public ResponseEntity<String> addFolder(@RequestParam String folderName){
        if(folderName==null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        folderPOService.addFolder(folderName);
        return  ResponseEntity.ok("添加成功");
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
    @PostMapping("getWellNameByFolderName")
    public List<String> getWellNameByFolderName(@RequestParam String folderName){
        LambdaQueryWrapper<WellInfoPO> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(WellInfoPO::getFolderName, folderName);
        queryWrapper.select(WellInfoPO::getWellId); // 只查询 well_id 字段

        return wellInfoService.list(queryWrapper)
                .stream()
                .map(WellInfoPO::getWellId)
                .collect(Collectors.toList());
    }
}
