package com.proj.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.proj.entity.po.WellLogCurveMappingPO;

import java.util.List;

/**
 * @description: TODO 
 * @author fw
 * @date 2025/4/9 上午10:59
 * @version 1.0
 */

public interface WellLogService extends IService<WellLogCurveMappingPO> {

    void saveMappings(Long wellLogId, List<WellLogCurveMappingPO> mappings);

    List<WellLogCurveMappingPO> getMappingsByWellLogId(Long wellLogId);

    Long getWellLogIdByFileName(String fileName);
}