package com.proj.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.proj.entity.ReservoirBasicInfo;
import org.apache.ibatis.annotations.Mapper;

/**
* @author L
* @description 针对表【Reservoir_Basic_Info】的数据库操作Mapper
* @createDate 2025-03-18 14:39:37
* @Entity com.proj.entity.ReservoirBasicInfo
*/
@Mapper
public interface ReservoirBasicInfoMapper extends BaseMapper<ReservoirBasicInfo> {

    Integer selectIdByReservoirName(String reservoirName) ;


}




