package com.proj.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.proj.entity.dto.PvtTestDataImportDTO;
import com.proj.entity.dto.PvtTestDataPointDTO;
import com.proj.entity.po.PvtTestDataPO;

import java.util.List;

/**
 * @description: 电缆地层测试压力数据服务接口
 * @author fw
 * @date 2025/5/5 下午3:24
 * @version 1.0
 */
public interface PvtTestDataService extends IService<PvtTestDataPO> {

    void importPvtTestData(PvtTestDataImportDTO dto);

    List<PvtTestDataPO> convertToPvtTestDataPOList(List<PvtTestDataPointDTO> dataPoints, String wellId);

}