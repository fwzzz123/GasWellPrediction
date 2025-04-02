package com.proj.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.proj.entity.WellLasInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author L
* @description 针对表【Well_Las_Info】的数据库操作Mapper
* @createDate 2025-03-21 13:32:45
* @Entity com.proj.entity.WellLasInfo
*/
@Mapper
public interface WellLasInfoMapper extends BaseMapper<WellLasInfo> {

    List<String> getAllWellNames();

    int updateWellIdInLasInfo();
}




