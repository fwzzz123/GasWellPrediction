package com.proj.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.proj.entity.po.WellLogCurveMappingPO;
import com.proj.entity.po.WellLogPO;
import com.proj.mapper.WellLogMapper;
import com.proj.mapper.WellLogMatchingMapper;
import com.proj.service.WellLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WellLogServiceImpl extends ServiceImpl<WellLogMatchingMapper, WellLogCurveMappingPO>
        implements WellLogService {

    @Autowired
    private WellLogMatchingMapper mappingMapper;

    @Autowired
    private WellLogMapper wellLogMapper;

    @Override
    public void saveMappings(List<WellLogCurveMappingPO> mappings) {
        mappingMapper.insertBatch(mappings);
    }

    @Override
    public List<WellLogCurveMappingPO> getMappingsByWellLogId(String wellLogId) {
        return mappingMapper.selectByWellLogId(wellLogId);
    }

    @Override
    public String checkAndInsertWellLog(String fileName) {
        // 检查 fileName 是否已存在
        String existingWellLogId = wellLogMapper.getWellLogIdByFileName(fileName);
        if (existingWellLogId != null) {
            return existingWellLogId;
        }
        // 如果不存在，则插入新记录
        WellLogPO newWellLog = new WellLogPO();
        newWellLog.setId(fileName); // 生成唯一 ID
        newWellLog.setStartDepth(0.0);
        newWellLog.setEndDepth(0.0);
        newWellLog.setStep(0.0);
        wellLogMapper.insert(newWellLog);
        return newWellLog.getId();
    }

    @Override
    public String getWellLogIdByFileName(String fileName) {
        return mappingMapper.getWellLogIdByFileName(fileName);
    }
}