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

    void saveMappings(List<WellLogCurveMappingPO> mappings);

    List<WellLogCurveMappingPO> getMappingsByWellLogId(String wellLogId);

    /**
     * 获取或创建 wellLogId
     * @param fileName 文件名
     * @return wellLogId
     */
//    String getOrCreateWellLogId(String fileName);

    /**
     * 检查 fileName 是否存在于 Well_Log 表中，如果不存在则插入新记录
     * @param fileName 文件名
     * @return 对应的 wellLogId
     */
    String checkAndInsertWellLog(String fileName);

    String getWellLogIdByFileName(String fileName);


}