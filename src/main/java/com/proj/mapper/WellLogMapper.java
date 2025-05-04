package com.proj.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.proj.entity.po.WellLogCurveMappingPO;
import com.proj.entity.po.WellLogPO;

import java.util.List;

public interface WellLogMapper extends BaseMapper<WellLogCurveMappingPO> {

    /**
     * 根据 fileName 查询对应的 wellLogId
     * @param fileName 文件名
     * @return wellLogId
     */
    String getWellLogIdByFileName(String fileName);

    /**
     * 插入新的 Well_Log 记录
     * @param wellLogPO Well_Log 实体
     */
    void insert(WellLogPO wellLogPO);

    // 方法签名改为返回List<WellLogCurveMappingPO>
    List<WellLogCurveMappingPO> getWellLogByFileName(String fileName);
}
