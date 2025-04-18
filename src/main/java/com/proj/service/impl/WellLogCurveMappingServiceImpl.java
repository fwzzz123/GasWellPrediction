package com.proj.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.proj.entity.vo.WellLogCurveMappingVO;
import com.proj.service.WellLogCurveMappingService;
import com.proj.mapper.WellLogCurveMappingMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* @author L
* @description 针对表【well_log_curve_mapping】的数据库操作Service实现
* @createDate 2025-04-17 16:39:24
*/
@Service
public class WellLogCurveMappingServiceImpl extends ServiceImpl<WellLogCurveMappingMapper, WellLogCurveMappingVO>
    implements WellLogCurveMappingService{

    @Autowired
    WellLogCurveMappingMapper wellLogCurveMappingMapper;
    @Override
    public String find_standard_field_name_byname(String name) {

        return wellLogCurveMappingMapper.find_standard_field_name_byname(name);
    }
}




