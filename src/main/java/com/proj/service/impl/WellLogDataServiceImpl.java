package com.proj.service.impl;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.proj.entity.dto.FieldCommentDTO;
import com.proj.entity.dto.ImportResultDTO;
import com.proj.entity.po.PvtTestDataPO;
import com.proj.entity.po.WellLogDataPO;
import com.proj.entity.vo.WellLogDataVO;
import com.proj.mapper.PvtTestDataMapper;
import com.proj.mapper.WellLogCurveMappingMapper;
import com.proj.mapper.WellLogDataMapper;
import com.proj.service.WellLogDataService;
import com.proj.utils.CommentUtils;
import com.proj.utils.NamingUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.beans.BeanMap;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.util.*;
import java.util.stream.Collectors;

/**
* @author L
* @description 针对表【well_log_data】的数据库操作Service实现
* @createDate 2025-04-17 16:33:41
*/
@Service
public class WellLogDataServiceImpl extends ServiceImpl<WellLogDataMapper, WellLogDataVO>
    implements WellLogDataService{

    @Autowired
    private WellLogDataMapper wellLogDataMapper;
    @Autowired
    private WellLogCurveMappingMapper wellLogCurveMappingMapper;

    @Autowired
    private PvtTestDataMapper pvtTestDataMapper;

    @Override
    public ResponseEntity<ImportResultDTO> ac_mapping_savewelllogdata(List<MultipartFile> files) {
        Set<String> unmappedFields = new HashSet<>();
        Set<String> missingMappingFields = new HashSet<>();
        Set<String> mappedFields = new HashSet<>();
        StringBuilder resultMessage = new StringBuilder();
        List<WellLogDataVO> wellLogDataList = new ArrayList<>();

        int totalValidRecords = 0;

        for (MultipartFile file : files) {
            String line;
            List<String> standard_field_name = new ArrayList<>();
            Map<String, String> wellLogDataMap = new HashMap<>();
            boolean inCurveInformationBlock = false;
            boolean inDataBlock = false;
            String well_log_id = file.getOriginalFilename();
            int validRecords = 0;

            try (BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
                while ((line = reader.readLine()) != null) {
                    if (line.startsWith("#")) continue;

                    // 状态块判断
                    if (line.startsWith("~C")) {
                        inCurveInformationBlock = true;
                        inDataBlock = false;
                    } else if (line.startsWith("~P") || line.startsWith("~O")) {
                        inCurveInformationBlock = false;
                    } else if (line.startsWith("~A")) {
                        inCurveInformationBlock = false;
                        inDataBlock = true;
                    }

                    // 解析曲线定义部分（~C）
                    if (inCurveInformationBlock && !line.startsWith("~")) {
                        String curveName = line.substring(0, line.indexOf(".")).trim();
                        String standardName = wellLogCurveMappingMapper.find_standard_field_name_byname(curveName);

                        if (standardName == null) {
                            // ✅ 这里记录原始未映射字段名（用于 missingMappingFields）
                            missingMappingFields.add(curveName);
                            standardName = "unmapped_" + curveName;
                        } else {
                            standardName = NamingUtils.toCamelCase(standardName);
                        }

                        if (standardName.startsWith("unmapped_")) {
                            // 🔁 删除 "unmapped_" 前缀后再加入 unmappedFields
                            String rawName = standardName.replaceFirst("unmapped_", "");
                            unmappedFields.add(rawName);
                        } else {
                            mappedFields.add(standardName);
                        }

                        standard_field_name.add(standardName);
                    }

                    // 解析数据部分（~A）
                    if (inDataBlock && !line.startsWith("~")) {
                        String[] data = line.trim().split("\\s+");
                        if (data.length == standard_field_name.size()) {
                            for (int i = 0; i < data.length; i++) {
                                wellLogDataMap.put(standard_field_name.get(i), data[i]);
                            }

                            WellLogDataVO entity = mapToEntity(wellLogDataMap, well_log_id);
                            wellLogDataList.add(entity);
                            validRecords++;
                            totalValidRecords++;

                            if (wellLogDataList.size() >= 1000) {
                                this.saveBatch(wellLogDataList);
                                wellLogDataList.clear();
                            }
                        }
                    }
                }

                // 插入剩余的数据
                if (!wellLogDataList.isEmpty()) {
                    this.saveBatch(wellLogDataList);
                    wellLogDataList.clear();
                }

                resultMessage.append("文件 ")
                        .append(well_log_id)
                        .append(" 处理完成，成功导入 ")
                        .append(validRecords)
                        .append(" 条记录。");

            } catch (IOException e) {
                resultMessage.append("文件 ").append(well_log_id).append(" 处理出错: ").append(e.getMessage());
                e.printStackTrace();
            }
        }

        // 构建 DTO 响应
        ImportResultDTO dto = new ImportResultDTO();
        dto.setSuccess(totalValidRecords > 0);
        dto.setMessage(resultMessage.toString());

        dto.setMappedFields(new ArrayList<>(mappedFields));
        dto.setUnmappedFields(new ArrayList<>(unmappedFields));
        dto.setMissingMappingFields(new ArrayList<>(missingMappingFields));

        return ResponseEntity.ok(dto);
    }




    @Override
    public List<FieldCommentDTO> selectAllTableHeaders() {
        Field[] fields = WellLogDataPO.class.getDeclaredFields();
        return Arrays.stream(fields)
                .map(field -> {
                    // 获取 @TableField 注解
                    TableField tableField = field.getAnnotation(TableField.class);
                    // 获取 @CommentUtils 注解
                    CommentUtils comment = field.getAnnotation(CommentUtils.class);

                    // 如果有 @TableField 注解，则使用它的 value，否则使用字段名
                    String dbFieldName = (tableField != null && !tableField.value().isEmpty())
                            ? tableField.value()
                            : field.getName();

                    // 评论内容
                    String commentValue = (comment != null) ? comment.value() : dbFieldName;

                    return new FieldCommentDTO(dbFieldName, commentValue);
                })
                .filter(dto -> !dto.getField().equals("id") &&
                        !dto.getField().equals("well_log_id") &&
                        !dto.getField().equals("serialVersionUID") &&
                        !dto.getField().equals("create_time") &&
                        !dto.getField().equals("update_time"))
                .collect(Collectors.toList());
    }


    @Override
    public List<FieldCommentDTO> selectAllPvtTableHeaders() {
        Field[] fields = PvtTestDataPO.class.getDeclaredFields();
        return Arrays.stream(fields)
                .map(field -> {
                    // 获取 @TableField 注解
                    TableField tableField = field.getAnnotation(TableField.class);
                    // 获取 @CommentUtils 注解
                    CommentUtils comment = field.getAnnotation(CommentUtils.class);

                    // 如果有 @TableField 注解，则使用它的 value，否则使用字段名
                    String dbFieldName = (tableField != null && !tableField.value().isEmpty())
                            ? tableField.value()
                            : field.getName();

                    // 评论内容
                    String commentValue = (comment != null) ? comment.value() : dbFieldName;

                    return new FieldCommentDTO(dbFieldName, commentValue);
                })
                .filter(dto -> !dto.getField().equals("id") &&
                        !dto.getField().equals("serialVersionUID") &&
                        !dto.getField().equals("create_time") &&
                        !dto.getField().equals("update_time"))
                .collect(Collectors.toList());
    }



    @Override
    public double calculatePseudoPressure(double viscosity, double deviationFactor, double refPressure, double pressure) {
        int numIntervals = 1000; // 积分区间分割数，越大越精确
        double dp = (pressure - refPressure) / numIntervals;
        double integral = 0.0;

        for (int i = 0; i < numIntervals; i++) {
            double p1 = refPressure + i * dp;
            double p2 = refPressure + (i + 1) * dp;
            double f1 = (2 * p1) / (viscosity * deviationFactor);
            double f2 = (2 * p2) / (viscosity * deviationFactor);
            integral += (f1 + f2) * dp / 2; // 梯形法
        }

        return integral;
    }

    @Override
    public double calculatePseudoPressure(List<PvtTestDataPO> pvtTestDataList, double bottomholePressure) {
        if (pvtTestDataList == null || pvtTestDataList.isEmpty()) {
            throw new IllegalArgumentException("PVT测试数据为空");
        }
        // 过滤出有效的数据点（确保 viscosity 和 zFactor 不为空）
        List<double[]> dataPoints = pvtTestDataList.stream()
                .filter(pvt -> pvt.getPvtViscosity() != null && pvt.getPvtZFactor() != null && pvt.getPvtPressure() != null)
                .map(pvt -> new double[]{
                        pvt.getPvtPressure().doubleValue(),       // pressure
                        pvt.getPvtViscosity().doubleValue(),      // viscosity
                        pvt.getPvtZFactor().doubleValue()         // zFactor
                })
                .sorted(Comparator.comparingDouble(d -> d[0])) // 按照压力升序排列
                .collect(Collectors.toList());

        if (dataPoints.size() < 2) {
            throw new IllegalArgumentException("至少需要两个有效 PVT 数据点进行积分");
        }

        double integral = 0.0;
        for (int i = 1; i < dataPoints.size(); i++) {
            double p1 = dataPoints.get(i - 1)[0];
            double mu1 = dataPoints.get(i - 1)[1];
            double z1 = dataPoints.get(i - 1)[2];

            double p2 = dataPoints.get(i)[0];
            double mu2 = dataPoints.get(i)[1];
            double z2 = dataPoints.get(i)[2];

            // 如果积分区间不包含当前子区间，则跳过
            if ((p2 < bottomholePressure && p1 < bottomholePressure) ||
                    (p2 > bottomholePressure && p1 > bottomholePressure)) {
                continue;
            }

            // 线性插值找出 bottomholePressure 所在区间的边界
            if (p1 < bottomholePressure && p2 > bottomholePressure) {
                double frac = (bottomholePressure - p1) / (p2 - p1);
                mu2 = mu1 + frac * (mu2 - mu1);
                z2 = z1 + frac * (z2 - z1);
                p2 = bottomholePressure;
            } else if (p1 < bottomholePressure) {
                p1 = bottomholePressure;
            }

            // 计算梯形面积：f(p) = 2p / (μ·Z)
            double dp = p2 - p1;
            double f1 = (2 * p1) / (mu1 * z1);
            double f2 = (2 * p2) / (mu2 * z2);

            integral += (f1 + f2) * dp / 2;
        }

        return integral;
    }

    @Override
    public Map<Double, List<double[]>> generateViscosityPlotData(double[] temperatureRange, double[] mineralizationLevels, double step) {
        Map<Double, List<double[]>> result = new HashMap<>();

        for (double kCi : mineralizationLevels) {
            List<double[]> dataPoints = new ArrayList<>();
            for (double t = temperatureRange[0]; t <= temperatureRange[1]; t += step) {
                double mu = calculateViscosity(kCi, t);
                dataPoints.add(new double[]{t, mu});
            }
            result.put(kCi, dataPoints);
        }

        return result;
    }

    private double calculateViscosity(double kCi, double t) {
        double base = 1 + 2.0833 * kCi * 1e-6;
        double exponent = 0.55 - 0.0243 * t + 0.642e-4 * t * t;
        return base * Math.exp(exponent);
    }


    @Override
    public double calculateGasWellProductivity(WellLogDataPO wellLogDataPO, double h) {
        // 从 WellLogDataPO 获取基础参数并转为 double
        double permeability = wellLogDataPO.getPermeability().doubleValue();       // k
        double reservoirTemperature = wellLogDataPO.getReservoirTemperature().doubleValue(); // T
        double wellboreRadius = wellLogDataPO.getWellboreRadius().doubleValue();   // r_w
        double drainageRadius = wellLogDataPO.getDrainageRadius().doubleValue();   // r_e
        double reservoirPressure = wellLogDataPO.getReservoirPressure().doubleValue(); // p_ref
        double bottomholePressure = wellLogDataPO.getBottomholePressure().doubleValue(); // p_wf
        double skinFactor = wellLogDataPO.getSkinFactor().doubleValue();           // S

        // 假设 Le = re（泄气半径），可根据模型调整
        double Le = drainageRadius;

        // 从 DAO 层获取当前井的 PVT 测试数据

        List<PvtTestDataPO> pvtTestDataList = pvtTestDataMapper.selectList(new LambdaQueryWrapper<PvtTestDataPO>()
                .eq(PvtTestDataPO::getWellId, wellLogDataPO.getId()));

        if (pvtTestDataList == null || pvtTestDataList.isEmpty()) {
            throw new IllegalArgumentException("未找到对应的 PVT 测试数据");
        }

        // 计算拟压力差 Δm(p)
        double pseudoPressureRes = calculatePseudoPressure(pvtTestDataList, reservoirPressure);
        double pseudoPressureWf = calculatePseudoPressure(pvtTestDataList, bottomholePressure);
        double deltaPseudoPressure = pseudoPressureRes - pseudoPressureWf;

        // 分母部分：ln((Le² + re²)/rw²) - 0.75 + S
        double denominator = Math.log((Math.pow(Le, 2) + Math.pow(drainageRadius, 2)) / Math.pow(wellboreRadius, 2))
                - 0.75 + skinFactor;

        // 分子部分：2πk·h·Δm(p)
        double numerator = (2 * Math.PI * permeability * h * deltaPseudoPressure);

        // 系数：1422·T（温度单位应为华氏度°F）
        double coefficient = 1422 * reservoirTemperature;

        // 最终产能计算
        return numerator / (coefficient * denominator);
    }



    //    public WellLogDataVO mapToEntity(Map<String,String> curveInfoMap, String well_log_id){
//        WellLogDataVO wellLogDataVO = new WellLogDataVO();
//        BeanMap beanMap = BeanMap.create(wellLogDataVO);
//        beanMap.put("wellLogId",well_log_id);
//        for (Map.Entry<String,String> entry : curveInfoMap.entrySet()){
//            if(beanMap.containsKey(entry.getKey())){
//                beanMap.put(entry.getKey(),new Double(entry.getValue()));
//            }
//        }
//        return wellLogDataVO;
//    }
    public WellLogDataVO mapToEntity(Map<String, String> curveInfoMap, String well_log_id){
        WellLogDataVO wellLogDataVO = new WellLogDataVO();
        wellLogDataVO.setWellLogId(well_log_id);

        BeanMap beanMap = BeanMap.create(wellLogDataVO);
        for (Map.Entry<String, String> entry : curveInfoMap.entrySet()){
            if(beanMap.containsKey(entry.getKey())){
                try {
                    beanMap.put(entry.getKey(), Double.valueOf(entry.getValue()));
                } catch (NumberFormatException ex) {
                    // 忽略无法转换为 double 的字段
                }
            }
        }
        return wellLogDataVO;
    }
    @Override
    public Map<String, List<double[]>> generateEffectivePermeabilityPlotData() {
        Map<String, List<double[]>> result = new HashMap<>();

        // 1. 获取所有井的数据
        List<WellLogDataVO> wellLogDataList = wellLogDataMapper.selectList(null);

//        // 2. 按井名分组
//        Map<String, List<WellLogDataPO>> groupedByWell = wellLogDataList.stream()
//                .collect(Collectors.groupingBy(WellLogDataPO::getWellName));
//
//        for (Map.Entry<String, List<WellLogDataPO>> entry : groupedByWell.entrySet()) {
//            String wellName = entry.getKey();
//            List<WellLogDataPO> dataPoints = entry.getValue();
//
//            List<double[]> permeabilityData = new ArrayList<>();
//            for (WellLogDataPO data : dataPoints) {
//                double kGas = calculateEffectivePermeability(data);
//                double testPermeability = data.getTestPermeability(); // 假设 WellLogDataPO 中有 getTestPermeability 方法
//
//                permeabilityData.add(new double[]{kGas, testPermeability});
//            }
//
//            result.put(wellName, permeabilityData);
//        }

        return result;
    }

//    [ K_{\text{气}} = \text{测压流度} \times \text{泥浆电镀} \times \frac{\text{气相相对渗透率}}{\text{水相相对渗透率}} ]
    private double calculateEffectivePermeability(WellLogDataPO dataLog, PvtTestDataPO dataPvt) {
        double mobility = dataPvt.getEstimatedMobility().toBigInteger().doubleValue(); // 测压流度
//        double mudElectrolysis = calculateViscosity(); // 粘度
//        double krGas = data.getKrGas(); // 气相相对渗透率
//        double krWater = data.getKrWater(); // 水相相对渗透率
//
//        return mobility * mudElectrolysis * (krGas / krWater);
        return 1;
    }

}




