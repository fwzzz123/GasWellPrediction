package com.proj.controller;

import com.proj.entity.dto.FieldCommentDTO;
import com.proj.entity.dto.PvtTestDataImportDTO;
import com.proj.entity.po.WellLogDataPO;
import com.proj.entity.vo.WellLogDataVO;
import com.proj.service.PvtTestDataService;
import com.proj.service.WellLogDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @description: TODO 
 * @author fw
 * @date 2025/4/28 上午10:24
 * @version 1.0
 */

@RestController
@RequestMapping("/log")
@CrossOrigin//支持跨域
public class LogController {

    @Autowired
    private WellLogDataService wellLogDataService;

    @Autowired
    private PvtTestDataService testDataService;

    // 新增方法：返回 well_log 表的所有字段名称（除了 id 和 wellLogId）
    @GetMapping("/tableHeaders")
    public List<FieldCommentDTO> getLogTableHeader() {
        return wellLogDataService.selectAllTableHeaders();
    }

    @GetMapping("/pvtTableHeaders")
    public List<FieldCommentDTO> getPvtTableHeader() {
        return wellLogDataService.selectAllPvtTableHeaders();
    }

    @PostMapping("/pvtImport")
    public String importPvtTestData(@RequestBody PvtTestDataImportDTO dto) {
        testDataService.importPvtTestData(dto);
        return "数据导入成功";
    }

    @PostMapping("/getDataByDept")
    public List<WellLogDataVO> getDataByDept(@RequestParam double start_dept , @RequestParam double stop_dept){
        return wellLogDataService.getDataByDept(start_dept,stop_dept);
    }
}