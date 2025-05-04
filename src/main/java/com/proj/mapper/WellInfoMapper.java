package com.proj.mapper;

import com.proj.entity.po.WellInfoPO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.proj.entity.po.WellLogCurveMappingPO;
import org.apache.ibatis.annotations.Mapper;

/**
* @author L
* @description 针对表【Well_Info】的数据库操作Mapper
* @createDate 2025-03-18 14:40:26
* @Entity com.proj.entity.WellVO
*/
@Mapper
public interface WellInfoMapper extends BaseMapper<WellInfoPO> {

    boolean existsByWellId(String wellId);

    void insertWellInfo(WellInfoPO wellInfo);

    void deleteByWellId(String wellId);

    void updateByWellId(WellInfoPO wellInfo);

    WellInfoPO selectByWellId(String wellId);

    WellInfoPO createByWellId(String wellId);

    WellInfoPO getByWellName(String wellName);

    void insertCurveMapping(WellLogCurveMappingPO mapping);

}




