package com.proj.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.proj.entity.po.WellLogCurveMappingPO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface WellLogMatchingMapper extends BaseMapper<WellLogCurveMappingPO> {

    /**
     * 插入新的 wellLogId
     * @param fileName 文件名
     * @return 新生成的 wellLogId
     */
    String insertNewWellLogId(String fileName);

    /**
     * 根据 fileName 获取 wellLogId
     * @param fileName 文件名
     * @return wellLogId
     */
    String getWellLogIdByFileName(String fileName);

    // 插入映射
    void insertBatch(List<WellLogCurveMappingPO> mappings);

    // 根据 wellLogId 查找该井的所有字段
    List<WellLogCurveMappingPO> selectByWellLogId(String wellLogId);
}