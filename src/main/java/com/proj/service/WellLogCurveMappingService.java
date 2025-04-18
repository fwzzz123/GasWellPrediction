package com.proj.service;

import com.proj.entity.vo.WellLogCurveMappingVO;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author L
* @description 针对表【well_log_curve_mapping】的数据库操作Service
* @createDate 2025-04-17 16:39:24
*/
public interface WellLogCurveMappingService extends IService<WellLogCurveMappingVO> {
    public String find_standard_field_name_byname(String name);
}
