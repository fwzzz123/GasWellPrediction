package com.proj.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.proj.entity.po.WellLogCurveMappingPO;
import com.proj.entity.vo.WellLogCurveMappingVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author L
* @description 针对表【well_log_curve_mapping】的数据库操作Mapper
* @createDate 2025-04-17 16:39:24
* @Entity com.proj.entity.vo.WellLogCurveMapping
*/
@Mapper
public interface WellLogCurveMappingMapper extends BaseMapper<WellLogCurveMappingVO> {

    String find_standard_field_name_byname(String name);

    /**
     * 批量插入 CurveMappings
     * @param mappings CurveMappings 列表
     */
    void insertBatch(List<WellLogCurveMappingPO> mappings);

}
