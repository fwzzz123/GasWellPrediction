package com.proj.entity.dto;

import lombok.Data;

import java.util.List;

/**
 * @description: TODO 
 * @author fw
 * @date 2025/4/11 下午10:20
 * @version 1.0
 */
@Data
public class CurveMappingDTO {
    private String fileName;
    private List<CurveDTO> curves;

    @Data
    public static class CurveDTO {
        private String lasCurveName;
        private String standardFieldName; // 前端传的标准字段名
    }
}
