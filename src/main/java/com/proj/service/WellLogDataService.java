package com.proj.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.proj.entity.dto.FieldCommentDTO;
import com.proj.entity.dto.ImportResultDTO;
import com.proj.entity.po.PvtTestDataPO;
import com.proj.entity.po.WellLogDataPO;
import com.proj.entity.vo.WellLogDataVO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

/**
* @author L
* @description 针对表【well_log_data】的数据库操作Service
* @createDate 2025-04-17 16:33:41
*/
public interface WellLogDataService extends IService<WellLogDataVO> {

//    ResponseEntity<String> ac_mapping_savewelllogdata(List<MultipartFile> files);

//    ResponseEntity<Map<String, Object>> ac_mapping_savewelllogdata(List<MultipartFile> files);

    ResponseEntity<ImportResultDTO> ac_mapping_savewelllogdata(List<MultipartFile> files);


    // 新增方法：返回 WellLogDataPO 中除了 id 和 wellLogId 之外的所有字段名称
    List<FieldCommentDTO> selectAllTableHeaders();

    // 新增方法：返回 PvtTestDataPO 中除了 id 和 wellLogId 之外的所有字段名称
    List<FieldCommentDTO> selectAllPvtTableHeaders();

    /**
     * 计算拟压力（Pseudo Pressure）的积分值
     *
     * @param viscosity 粘度 μ
     * @param deviationFactor 偏差因子 Z
     * @param refPressure 参考压力 p_ref
     * @param pressure 当前压力 p
     * @return 拟压力值
     */
    double calculatePseudoPressure(double viscosity, double deviationFactor, double refPressure, double pressure);

    /**
     * 使用拟压力法计算直井产能
     *
     * @param wellLogDataPO 包含所有输入参数的实体类
     * @param h             油层厚度（单位：m）
     * @return 产能 q（单位：m³/day 或其他）
     */
    double calculateGasWellProductivity(WellLogDataPO wellLogDataPO, double h);


    double calculatePseudoPressure(List<PvtTestDataPO> pvtTestDataList, double bottomholePressure);

    /**
     * 生成粘度图版数据
     * @param temperatureRange 温度范围（例如：new double[]{0, 100} 表示 0 到 100 摄氏度）
     * @param mineralizationLevels 矿化度水平（单位：mg/L）
     * @param step 温度步长
     * @return Map<矿化度, List<温度-粘度数据点>>
     */
    Map<Double, List<double[]>> generateViscosityPlotData(double[] temperatureRange, double[] mineralizationLevels, double step);


    /**
     * 生成有效渗透率图版数据
     * @return Map<井名, List<气相有效渗透率-试井渗透率数据点>>
     */
    Map<String, List<double[]>> generateEffectivePermeabilityPlotData();

}
