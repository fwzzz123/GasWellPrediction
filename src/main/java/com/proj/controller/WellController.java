package com.proj.controller;

import com.proj.entity.WellInfo;
import com.proj.service.WellDataReceiveService;
import com.proj.service.WellDataStorageService;
import com.proj.service.WellInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/well")
@RequiredArgsConstructor
public class WellController {

    private final WellDataReceiveService wellDataReceiveService;
    private final WellDataStorageService wellDataStorageService;
    private final WellInfoService wellInfoService;

    //接受表单数据插入数据库
    @PostMapping("/add")
    public String addWell(@RequestBody Map<String, String> wellInfoMap) {
        // 先处理表单数据
        Map<String, String> processedData = wellDataReceiveService.processWellFormData(wellInfoMap);

        // 存储到数据库
        int result = wellDataStorageService.saveWell(processedData);

        return result > 0 ? "井数据插入成功！" : "井数据插入失败！";
    }

    @RequestMapping("/sync-wells")
    public ResponseEntity<String> syncWellsFromLasInfo() {
        int insertedCount = wellInfoService.insertMissingWells();
        return ResponseEntity.ok("Inserted " + insertedCount + " new wells.");
    }

    @PostMapping("/updateWellLasInfoWithWellID")
    public ResponseEntity<String> updateWellLasInfoWithWellID() {
        try {
            // 调用 Service 层方法进行更新
            wellInfoService.updateWellIds();

            return ResponseEntity.ok("Well_Las_Info 表更新成功");
        } catch (Exception e) {
            // 处理异常并返回错误信息
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("发生错误: " + e.getMessage());
        }
    }
    //查询井信息
    @PostMapping("getWellInfo")
    public List<WellInfo> getWellInfo(){
        return null;
    }


    //根据wellId查询井信息
    @PostMapping("getWellInfoByWellId")
    public WellInfo getWellInfoByWellId(@RequestParam("wellId") String wellId){
        WellInfo wellInfo=wellInfoService.getByWellId(wellId);
        return wellInfo;
    }

}