package com.proj.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.proj.entity.po.ReservoirBasicInfoPO;
import org.apache.ibatis.annotations.Mapper;

/**
* @author L
* @description 针对表【Reservoir_Basic_Info】的数据库操作Mapper
* @createDate 2025-03-18 14:39:37
* @Entity com.proj.entity.po.ReservoirBasicInfoPO
*/
@Mapper
public interface ReservoirBasicInfoMapper extends BaseMapper<ReservoirBasicInfoPO> {

    Integer selectIdByReservoirName(String reservoirName) ;

    int insertReservoirBasicInfo(ReservoirBasicInfoPO reservoirBasicInfo);

}




