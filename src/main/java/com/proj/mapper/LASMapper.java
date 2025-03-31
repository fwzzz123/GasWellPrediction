package com.proj.mapper;

import com.proj.entity.WellLAS;
import org.apache.ibatis.annotations.Mapper;

;

@Mapper
public interface LASMapper {

    int insertWellLAS(WellLAS wellLAS);

    WellLAS getWellLASById(Long id);
}
