package com.proj.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.proj.entity.ReservoirBasicInfo;
import com.proj.service.ReservoirBasicInfoService;
import com.proj.mapper.ReservoirBasicInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author L
* @description 针对表【Reservoir_Basic_Info】的数据库操作Service实现
* @createDate 2025-03-18 14:39:37
*/
@Service
public class ReservoirBasicInfoServiceImpl extends ServiceImpl<ReservoirBasicInfoMapper, ReservoirBasicInfo>
    implements ReservoirBasicInfoService{

    @Autowired
    private ReservoirBasicInfoMapper reservoirBasicInfoMapper;
    @Override
    public List<ReservoirBasicInfo> getReservoirs() {
        return reservoirBasicInfoMapper.selectList(null);
    }
}




