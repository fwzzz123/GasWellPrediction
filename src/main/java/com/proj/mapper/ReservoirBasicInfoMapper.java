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

    /**
     * 根据名称创建气藏信息
     * @param reservoirName 气藏名称
     * @return 创建的气藏 ID
     */
    int insert(ReservoirBasicInfoPO reservoir);

    /**
     * 根据 ID 删除气藏信息
     * @param reservoirId 气藏 ID
     * @return 删除的记录数
     */
    int deleteById(int reservoirId);

    /**
     * 根据 ID 更新气藏信息
     * @param reservoir 气藏对象
     * @return 更新的记录数
     */
    int updateById(ReservoirBasicInfoPO reservoir);

    /**
     * 根据 ID 查询气藏信息
     * @param reservoirId 气藏 ID
     * @return 气藏对象
     */
    ReservoirBasicInfoPO selectById(int reservoirId);

}




