package com.proj.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.proj.entity.po.WellInfoPO;
import com.proj.entity.po.WellLasPO;

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
}
