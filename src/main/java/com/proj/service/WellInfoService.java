package com.proj.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.proj.entity.dto.WellInfoDTO;
import com.proj.entity.po.WellInfoPO;
import com.proj.entity.po.WellLasPO;
import com.proj.entity.po.WellLogCurveMappingPO;

import java.util.List;

/**
* @author L
* @description 针对表【Well_Info】的数据库操作Service
* @createDate 2025-03-18 14:40:26
*/
public interface WellInfoService extends IService<WellInfoPO> {
//这个函数
    public void insertWellLAS(WellLasPO wellLasPO);

    public WellLasPO getById(Long id);



    //这个函数检查ell_Las_Info的外键well_id然后根据well的缺失值，补全表Well_Las_Info的well_id的函数
    public void updateWellIds();

    //这个函数检查Well_Las_Info表的well_name和Well表的well_name，然后将已有的未插入Well表的函数插入well_name字段
    int insertMissingWells();

    boolean insert(WellInfoPO wellInfo);

    WellInfoPO getByWellName(String wellName);

    void insertCurveMapping(List<WellLogCurveMappingPO> mappingList);

    // 查询是否存在记录
    boolean existsByWellId(String wellId);

    // 新增记录
    void createWellInfo(WellInfoPO wellInfo);

    // 删除记录
    void deleteWellInfo(String wellId);

    // 更新记录
    void updateWellInfo(WellInfoPO wellInfo);

    // 查询单条记录
    WellInfoPO queryWellInfo(String wellId);

    List<WellInfoPO> queryWellInfoList(List<String> wellIds);

    //新增井记录(DTO),从前端拿的DTO数据
    boolean addWellInfo(WellInfoDTO dto);

    List<WellInfoDTO> convertToWellInfoDTOList(List<WellInfoPO> wellInfoPOs) ;

    WellInfoDTO convertToDTO(WellInfoPO po);




        /*
    *@陈
    * 查询所有的井名
    * */
    // 查询所有 well_id
    List<String> getAllWellIds();


}
