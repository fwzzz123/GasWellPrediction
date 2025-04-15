package com.proj.service;

import com.proj.entity.po.ReservoirBasicInfoPO;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author L
* @description 针对表【Reservoir_Basic_Info】的数据库操作Service
* @createDate 2025-03-18 14:39:37
*/
public interface ReservoirBasicInfoService extends IService<ReservoirBasicInfoPO> {

    List<ReservoirBasicInfoPO> getReservoirs();

    int insertReservoirBasicInfo(ReservoirBasicInfoPO reservoirBasicInfo);
}
