package com.proj.service.impl;

import com.proj.entity.po.WellInfoPO;
import com.proj.mapper.ReservoirBasicInfoMapper;
import com.proj.mapper.WellInfoMapper;
import com.proj.mapper.WellMapper;
import com.proj.service.WellDataStorageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Map;

/**
 * @description: TODO 
 * @author fw
 * @date 2025/3/31 下午8:15
 * @version 1.0
 */

@Service
@RequiredArgsConstructor
public class WellDataStorageServiceImpl implements WellDataStorageService {

    private final WellMapper wellMapper;

    private final WellInfoMapper wellInfoMapper;

    private final ReservoirBasicInfoMapper reservoirBasicInfoMapper;
    @Override
    public int saveWell(Map<String, String> wellInfoMap) {
        WellInfoPO wellInfoPO = new WellInfoPO();
        wellInfoPO.setWellName(wellInfoMap.get("wellName"));
        wellInfoPO.setWellType(wellInfoMap.get("wellType"));
        String wellCapacityStr = wellInfoMap.get("wellCapacity");
        if (wellCapacityStr != null) {
            wellInfoPO.setCapacity(new BigDecimal(wellCapacityStr));
        }
        //这里需要添加一个根据reservoir查找id的功能
        String gasReservoirName = wellInfoMap.get("gasReservoir");
        if (gasReservoirName != null) {
            //根据名字查找id
            Integer gasReservoirId = reservoirBasicInfoMapper.selectIdByReservoirName(gasReservoirName);
            if (gasReservoirId != null) {
                wellInfoPO.setReservoirId(gasReservoirId);
            }
        }
        wellInfoMapper.insertWellInfo(wellInfoPO);
        return 1;  // 插入成功返回 1
    }
}