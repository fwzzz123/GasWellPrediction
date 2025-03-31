package com.proj.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.proj.entity.WellInfo;
import com.proj.entity.WellLAS;
import com.proj.mapper.LASMapper;
import com.proj.mapper.WellInfoMapper;
import com.proj.service.WellInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* @author L
* @description 针对表【Well_Info】的数据库操作Service实现
* @createDate 2025-03-18 14:40:26
*/
@Service
public class WellInfoServiceImpl extends ServiceImpl<WellInfoMapper, WellInfo> implements WellInfoService{

    @Autowired
    private LASMapper lasMapper;

    @Override
    public int insertWellLAS(WellLAS wellLAS) {
        return lasMapper.insertWellLAS(wellLAS);
    }

    @Override
    public WellLAS getById(Long id) {

        return lasMapper.getWellLASById(id);
    }


}




