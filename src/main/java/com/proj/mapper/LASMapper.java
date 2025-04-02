package com.proj.mapper;

import com.proj.entity.po.WellLasPO;
import org.apache.ibatis.annotations.Mapper;

;

@Mapper
public interface LASMapper {

    int insertWellLAS(WellLasPO wellLasPO);

    WellLasPO getWellLASById(Long id);
}
