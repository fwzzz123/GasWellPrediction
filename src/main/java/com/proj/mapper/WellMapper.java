package com.proj.mapper;


import com.proj.entity.po.WellPO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface WellMapper {
    int insertWell(WellPO well);

    List<String> getAllWellNames();


}