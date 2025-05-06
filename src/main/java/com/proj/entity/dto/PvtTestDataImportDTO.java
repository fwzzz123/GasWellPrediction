package com.proj.entity.dto;

import lombok.Data;

import java.util.List;

/**
 * @description: TODO 
 * @author fw
 * @date 2025/5/5 下午3:10
 * @version 1.0
 */

@Data
public class PvtTestDataImportDTO {
    private String wellId;
    private List<PvtTestDataPointDTO> dataPoints; // 使用自定义 DTO
}

