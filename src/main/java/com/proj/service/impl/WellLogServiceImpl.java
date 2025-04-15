package com.proj.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.proj.entity.po.WellLogCurveMappingPO;
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
    public void saveMappings(Long wellLogId, List<WellLogCurveMappingPO> mappings) {
        // 实现保存映射的逻辑
        for(WellLogCurveMappingPO mappingPO : mappings) {
            mappingPO.setWellLogId(wellLogId);
        }
        mappingMapper.insertBatch(mappings);
    }

    @Override
    public List<WellLogCurveMappingPO> getMappingsByWellLogId(Long wellLogId) {
        // 实现根据 wellLogId 获取映射的逻辑
        return mappingMapper.selectByWellLogId(wellLogId);
    }

    @Override
    public Long getWellLogIdByFileName(String fileName) {
        Long digital = new Long(1);
        wellLogMapper.getWellLogByFileName(fileName);
        return digital;
    }


}