package com.proj.service.impl;

import com.proj.entity.po.WellPO;
import com.proj.mapper.WellMapper;
import com.proj.service.WellDataStorageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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

    @Override
    public int saveWell(Map<String, String> wellInfoMap) {
        WellPO wellPO = new WellPO();
        wellPO.setWellName(wellInfoMap.get("wellName"));
        wellPO.setWellType(wellInfoMap.get("wellType"));
        wellPO.setWellCapacity(Double.parseDouble(wellInfoMap.get("wellCapacity")));
        wellPO.setGasReservoir(wellInfoMap.get("gasReservoir"));

        wellMapper.insertWell(wellPO);
        return 1;  // 插入成功返回 1
    }
}