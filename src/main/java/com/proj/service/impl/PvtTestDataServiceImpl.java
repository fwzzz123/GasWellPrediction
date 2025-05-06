package com.proj.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.proj.entity.dto.PvtTestDataImportDTO;
import com.proj.entity.dto.PvtTestDataPointDTO;
import com.proj.entity.po.PvtTestDataPO;
import com.proj.mapper.PvtTestDataMapper;
import com.proj.service.PvtTestDataService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: TODO 
 * @author fw
 * @date 2025/5/5 下午3:24
 * @version 1.0
 */

@Service
public class PvtTestDataServiceImpl extends ServiceImpl<PvtTestDataMapper, PvtTestDataPO> implements PvtTestDataService {


    @Override
    public void importPvtTestData(PvtTestDataImportDTO dto) {
        String wellId = dto.getWellId();

        // 获取数据点列表并转换为 PvtTestDataPO 列表
        List<PvtTestDataPO> testDataList = convertToPvtTestDataPOList(dto.getDataPoints(), wellId);

        // 批量插入数据
        this.saveBatch(testDataList);
    }

    @Override
    public List<PvtTestDataPO> convertToPvtTestDataPOList(List<PvtTestDataPointDTO> dataPoints, String wellId) {
        List<PvtTestDataPO> testDataList = new ArrayList<>();

        for (PvtTestDataPointDTO pointDTO : dataPoints) {
            PvtTestDataPO testData = new PvtTestDataPO();
            testData.setWellId(wellId);
            testData.setMeasuredDepth(pointDTO.getMeasuredDepth());
            testData.setPreMudPressure(pointDTO.getPreMudPressure());
            testData.setFormationPressure(pointDTO.getFormationPressure());
            testData.setPostMudPressure(pointDTO.getPostMudPressure());
            testData.setEstimatedMobility(pointDTO.getEstimatedMobility());
            testData.setPressurePointType(pointDTO.getPressurePointType());
            testData.setPermeabilityMudPressure(pointDTO.getMudPressureCoefficient());
            testData.setReservoirTemperature(pointDTO.getReservoirTemperature());
            testData.setPvtViscosity(pointDTO.getPvt_viscosity());
            testData.setPvtZFactor(pointDTO.getPvt_z_factor());
            testData.setPvtPressure(pointDTO.getPvt_pressure());

            testDataList.add(testData);
        }

        return testDataList;
    }
}