package com.proj.controller;

import com.proj.entity.dto.CurveMappingRequest;
import com.proj.entity.dto.WellInfoDTO;
import com.proj.entity.po.WellInfoPO;
import com.proj.entity.po.WellLogCurveMappingPO;
import com.proj.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/well")
@RequiredArgsConstructor
public class WellController {
    private final CapacityCalculateService capacityCalculateService;
    private final WellInfoService wellInfoService;
    private final WellLogService wellLogService;


    //接受表单数据插入数据库
    @PostMapping("/add")
    public ResponseEntity<String> addWell(@RequestBody WellInfoDTO dto) {

        System.out.println("接收到的 DTO: " + dto);

        boolean result = wellInfoService.addWellInfo(dto);
        return result ? ResponseEntity.ok("井数据插入成功！") : ResponseEntity.status(500).body("井数据插入失败！");
    }



    //这个函数检查well_Las_Info的外键well_id然后根据well的缺失值，补全表Well_Las_Info的well_id的函数
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

    //
    @PostMapping("/saveMatchingwells")
    public String saveCurveMappingWells(@RequestBody CurveMappingRequest request) {
        System.out.println(request.getMappingList());
        wellLogService.saveMappings(request.getMappingList());
        return "保存成功";
    }
    @PostMapping("/{wellLogId}")
    public List<WellLogCurveMappingPO> getMapping(@PathVariable String wellLogId) {
        return wellLogService.getMappingsByWellLogId(wellLogId);
    }


    // @陈义嘉，即得到所有井名
    @GetMapping("/getAllWellIds")
    public ResponseEntity<List<String>> getAllWellIds() {
        List<String> wellIds = wellInfoService.getAllWellIds();
        return ResponseEntity.ok(wellIds);
    }

    //将WellInfoPO转化
    @GetMapping("/getWellInfoList")
    public ResponseEntity<List<WellInfoDTO>> getWellInfoList() {
        // 1. 获取所有井名
        List<String> wellIds = wellInfoService.getAllWellIds();
        if (wellIds == null || wellIds.isEmpty()) {
            return ResponseEntity.ok(Collections.emptyList()); // Java 8 兼容写法
        }

        // 2. 根据井名批量查询 WellInfoPO
        List<WellInfoPO> wellInfoPOs = wellInfoService.queryWellInfoList(wellIds);

        // 3. 转换为 DTO
        List<WellInfoDTO> wellInfoDTOs = wellInfoService.convertToWellInfoDTOList(wellInfoPOs);

        return ResponseEntity.ok(wellInfoDTOs);
    }
    @PostMapping("/getWellInfoListByWellNames")
    public ResponseEntity<List<WellInfoDTO>> getWellInfoListByWellNames(@RequestBody List<String> wellNames) {
        if (wellNames == null || wellNames.isEmpty()) {
            return ResponseEntity.ok(Collections.emptyList());
        }

        // 1. 根据井名批量查询 WellInfoPO
        List<WellInfoPO> wellInfoPOs = wellInfoService.queryWellInfoList(wellNames);

        // 2. 转换为 DTO
        List<WellInfoDTO> wellInfoDTOs = wellInfoService.convertToWellInfoDTOList(wellInfoPOs);

        return ResponseEntity.ok(wellInfoDTOs);
    }


    //拟稳态产能公式
    @RequestMapping("/NiwentaiAOF")
    public ResponseEntity<BigDecimal> calculateAOF(@RequestParam String wellName) {
        // 1. 查询井信息
        WellInfoPO wellInfo = wellInfoService.queryWellInfo(wellName);
        if (wellInfo == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        // 2. 调用产能计算服务
        BigDecimal aof = capacityCalculateService.calculateSteadyStateCapacity(wellInfo);

        return ResponseEntity.ok(aof);
    }


    @PostMapping("/updateFields")
    public ResponseEntity<String> updateWellInfoFields(@RequestBody List<WellInfoDTO> wellInfoDTOList) {
        List<String> updateCnt = new ArrayList<>();
        List<String> failedIds = new ArrayList<>();

        if (wellInfoDTOList == null || wellInfoDTOList.isEmpty()) {
            return ResponseEntity.badRequest().body("请求数据为空");
        }
        for (WellInfoDTO wellInfoDTO : wellInfoDTOList){
            if (wellInfoDTO == null || wellInfoDTO.getWellId() == null) {
                failedIds.add("null_dto_or_id");
                continue;
            }

            WellInfoPO wellInfoPO = wellInfoService.convertToPO(wellInfoDTO);
            boolean success = wellInfoService.updateWellInfo(wellInfoPO);

            if (success) {
                updateCnt.add(wellInfoDTO.getWellId());
            } else {
                failedIds.add(wellInfoDTO.getWellId());
            }
        }
        String message = " 更新成功：" + updateCnt.size() +
                "， 失败：" + failedIds.size() +
                "，失败ID列表：" + failedIds;

        return ResponseEntity.ok(message);
    }

    @PostMapping("/deleteWellInfo")
    ResponseEntity<String> deletWellInfo(@RequestBody String wellId){
        //1. 参数校验
        if (wellId == null || wellId.isEmpty()) {
            return ResponseEntity.badRequest().body("wellId不能为空");
        }

        ResponseEntity<String> response = wellInfoService.deleteWellInfo(wellId);
        if (response.getStatusCode() == HttpStatus.OK && "1".equals(response.getBody())) {
            return ResponseEntity.ok("删除成功");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("删除失败");
        }
    }

}
