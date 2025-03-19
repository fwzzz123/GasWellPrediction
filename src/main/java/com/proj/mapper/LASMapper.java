package com.proj.mapper;

import com.proj.domain.po.WellLAS;

public interface LASMapper {

    int insertWellLAS(WellLAS wellLAS);

    WellLAS getWellLASById(Long id);
}
