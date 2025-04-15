package com.proj.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kingbase8.util.KSQLException;
import com.proj.entity.po.ReservoirBasicInfoPO;
import com.proj.mapper.ReservoirBasicInfoMapper;
import com.proj.service.ReservoirBasicInfoService;
import com.proj.utils.exception.DuplicateFileNameException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author L
* @description 针对表【Reservoir_Basic_Info】的数据库操作Service实现
* @createDate 2025-03-18 14:39:37
*/
@Service
public class ReservoirBasicInfoServiceImpl extends ServiceImpl<ReservoirBasicInfoMapper, ReservoirBasicInfoPO>
    implements ReservoirBasicInfoService{

    @Autowired
    private ReservoirBasicInfoMapper reservoirBasicInfoMapper;
    @Override
    public List<ReservoirBasicInfoPO> getReservoirs() {
        return reservoirBasicInfoMapper.selectList(null);
    }

    @Override
    public int insertReservoirBasicInfo(ReservoirBasicInfoPO reservoirBasicInfo) {
        try {
            reservoirBasicInfoMapper.insertReservoirBasicInfo(reservoirBasicInfo);
        } catch (DataIntegrityViolationException e) {
            if (e.getCause() instanceof KSQLException) {
                KSQLException ksqlEx = (KSQLException) e.getCause();
                if (ksqlEx.getMessage().contains("unique_reservoir_name")) {
                    throw new DuplicateFileNameException("气藏 '" + reservoirBasicInfo.getReservoirName() + "' 已存在");
                }
            }
            throw e;
        }
        return 0;
    }
}




