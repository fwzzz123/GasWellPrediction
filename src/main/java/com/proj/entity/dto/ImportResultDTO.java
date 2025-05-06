package com.proj.entity.dto;

import lombok.Data;

import java.util.List;

/**
 * @description: TODO 
 * @author fw
 * @date 2025/5/5 下午12:54
 * @version 1.0
 */

@Data
public class ImportResultDTO {
    private boolean success;
    private String message;
    private List<String> mappedFields;
    private List<String> unmappedFields;
    private List<String> missingMappingFields;

    // Getters and Setters
}