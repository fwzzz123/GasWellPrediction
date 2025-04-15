package com.proj.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.proj.entity.po.WellLogCurveMappingPO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface WellLogMatchingMapper extends BaseMapper<WellLogCurveMappingPO> {
    //插入映射
    void insertBatch(List<WellLogCurveMappingPO> mappings);

    //根据wellLogId查找该井的所有字段
    List<WellLogCurveMappingPO> selectByWellLogId(Long wellLogId);

}
