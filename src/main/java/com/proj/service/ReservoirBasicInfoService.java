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

    /**
     * 根据名称创建气藏信息
     * @param reservoirName 气藏名称
     * @return 创建的气藏 ID
     */
    int createReservoirByName(String reservoirName);

    /**
     * 根据 ID 删除气藏信息
     * @param reservoirId 气藏 ID
     * @return 删除的记录数
     */
    int deleteReservoirById(int reservoirId);

    /**
     * 根据 ID 更新气藏信息
     * @param reservoir 气藏对象
     * @return 更新的记录数
     */
    int updateReservoirById(ReservoirBasicInfoPO reservoir);

    /**
     * 根据 ID 查询气藏信息
     * @param reservoirId 气藏 ID
     * @return 气藏对象
     */
    ReservoirBasicInfoPO queryReservoirById(int reservoirId);
}
