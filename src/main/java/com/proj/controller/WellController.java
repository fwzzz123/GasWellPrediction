package com.proj.controller;

import com.alibaba.excel.EasyExcel;
import com.proj.entity.dto.CurveMappingRequest;
import com.proj.entity.dto.FieldCommentDTO;
import com.proj.entity.dto.WellInfoDTO;
import com.proj.entity.po.WellInfoPO;
import com.proj.entity.po.WellLogCurveMappingPO;
import com.proj.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Cell;
import org.springframework.web.multipart.MultipartFile;

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
        // 1. 获取井名
        String wellId = dto.getWellId();

        // 2. 检查井名是否为空
        if (wellId == null || wellId.isEmpty()) {
            return ResponseEntity.badRequest().body("井名不能为空");
        }

        // 3. 检查井名是否重复
        if (wellInfoService.existsByWellId(wellId)) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("井名已存在");
        }

        // 4. 插入井数据
        boolean result = wellInfoService.addWellInfo(dto);
        if (result) {
            return ResponseEntity.ok("井数据插入成功！");
        } else {
            return ResponseEntity.status(500).body("井数据插入失败！");
        }
    }


    @GetMapping("/field-comments")
    public ResponseEntity<List<FieldCommentDTO>> getFieldComments() {
        List<FieldCommentDTO> comments = wellInfoService.getFieldComments();
        return ResponseEntity.ok(comments);
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

    //根据ID查询井信息，传入参数：井名List
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

    @GetMapping("/download-template")
    public void downloadTemplate(HttpServletResponse response) throws IOException {
        // 获取字段与注释映射
        List<FieldCommentDTO> fieldComments = wellInfoService.getFieldComments();

        // 构造表头
        List<List<String>> head = fieldComments.stream()
                .map(dto -> Collections.singletonList(dto.getComment()))
                .collect(Collectors.toList());

        // 设置响应头
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setCharacterEncoding("utf-8");
        response.setHeader("Content-disposition", "attachment;filename=well_info_template.xlsx");

        // 写空数据
        EasyExcel.write(response.getOutputStream())
                .head(head)
                .sheet("井数据模板")
                .doWrite(Collections.emptyList());
    }

    @PostMapping("/import")
    public ResponseEntity<?> importWellData(@RequestParam("file") MultipartFile file) {
        try {
            List<WellInfoDTO> dataList = EasyExcel.read(file.getInputStream())
                    .head(WellInfoDTO.class)
                    .sheet()
                    .doReadSync(); // 使用doReadSync()直接返回List

            // 2. 转换为PO列表
            List<WellInfoPO> poList = wellInfoService.convertToWellInfoPOList(dataList);
            // 3. 校验数据（使用PO列表）
            Map<String, Object> validationResult = wellInfoService.validateData(poList);
            if ((Boolean) validationResult.get("hasError")) {
                return ResponseEntity.badRequest().body(validationResult.get("message"));
            }

            // 4. 批量插入
            boolean success = wellInfoService.saveBatch(poList);
            return success ?
                    ResponseEntity.ok("导入成功") :
                    ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("导入失败");

            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body("导入失败: " + e.getMessage());
            }
        }

}
