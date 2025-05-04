package com.proj.controller;

import com.proj.entity.dto.FieldCommentDTO;
import com.proj.service.WellLogDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    // 新增方法：返回 well_log 表的所有字段名称（除了 id 和 wellLogId）
    @GetMapping("/tableHeaders")
    public List<FieldCommentDTO> getLogTableHeader() {
        return wellLogDataService.selectAllTableHeaders();
    }



}