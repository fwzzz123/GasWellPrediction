package com.proj.entity.dto;

import com.proj.entity.po.WellLogCurveMappingPO;
import lombok.Data;

import java.util.List;

/**
 * @description: TODO 
 * @author fw
 * @date 2025/4/9 下午4:52
 * @version 1.0
 */
@Data
public class CurveMappingRequest {
   private String wellLogId;
   private List<WellLogCurveMappingPO> mappingList;
}