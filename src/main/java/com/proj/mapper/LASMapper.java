package com.proj.mapper;

import com.proj.domain.po.WellLAS;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

public interface LASMapper {

    @Insert("INSERT INTO wells (name, las_file) VALUES (#{name}, #{lasFile})")
    int insertWellLAS(WellLAS wellLAS);

    @Select("SELECT * FROM wells WHERE id = #{id}")
    WellLAS getWellLASById(Long id);
}
