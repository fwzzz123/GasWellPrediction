package com.proj.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.proj.entity.po.WellLogCurveMappingPO;

public interface WellLogMapper extends BaseMapper<WellLogCurveMappingPO> {

    void getWellLogByFileName(String fileName);
}
