package com.proj.mapper;

import com.proj.entity.vo.WellLogCurveMappingVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author L
* @description 针对表【well_log_curve_mapping】的数据库操作Mapper
* @createDate 2025-04-17 16:39:24
* @Entity com.proj.entity.vo.WellLogCurveMapping
*/
@Mapper
public interface WellLogCurveMappingMapper extends BaseMapper<WellLogCurveMappingVO> {

    String find_standard_field_name_byname(String name);
}




