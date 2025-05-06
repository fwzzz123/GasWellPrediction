package com.proj.lasTest;


import com.proj.entity.po.PvtTestDataPO;
import com.proj.service.WellLogDataService;
import com.proj.service.impl.WellLogDataServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class WellLogDataServiceImplTest {

    @Autowired
    private WellLogDataService wellLogDataService;

    @Autowired

    @BeforeEach
    public void setUp() {
        wellLogDataService = new WellLogDataServiceImpl();
    }
    @Test
    public void testCalculatePseudoPressure() {
        // 输入参数
        double viscosity = 0.02;         // 粘度 μ
        double deviationFactor = 0.9;    // 偏差因子 Z
        double refPressure = 10.0;       // 参考压力 p_ref
        double pressure = 20.0;          // 当前压力 p

        // 调用方法
        double result = wellLogDataService.calculatePseudoPressure(viscosity, deviationFactor, refPressure, pressure);

        // 预期值（手动计算或近似）
        double expected = ((2 * refPressure + 2 * pressure) / (viscosity * deviationFactor)) * (pressure - refPressure) / 2;

        System.out.println("Expected Pseudo Pressure: " + expected);
        System.out.println("Actual Pseudo Pressure: " + result);


        // 断言结果是否接近
        assertEquals(expected, result, 1e-6); // 设置精度误差
    }

    @Test
    void testCalculatePseudoPressure_NormalCase() {
        // Arrange
        List<PvtTestDataPO> pvtTestDataList = new ArrayList<>();

        PvtTestDataPO data1 = new PvtTestDataPO();
        data1.setPvtPressure(BigDecimal.valueOf(1000));
        data1.setPvtViscosity(BigDecimal.valueOf(0.8));
        data1.setPvtZFactor(BigDecimal.valueOf(0.9));

        PvtTestDataPO data2 = new PvtTestDataPO();
        data2.setPvtPressure(BigDecimal.valueOf(2000));
        data2.setPvtViscosity(BigDecimal.valueOf(0.7));
        data2.setPvtZFactor(BigDecimal.valueOf(0.85));

        pvtTestDataList.add(data1);
        pvtTestDataList.add(data2);

        double bottomholePressure = 1500;

        // Act
        double result = wellLogDataService.calculatePseudoPressure(pvtTestDataList, bottomholePressure);

        // Assert
        assertTrue(result > 0);
    }

    @Test
    void testCalculatePseudoPressure_EmptyList_ShouldThrowException() {
        // Arrange
        List<PvtTestDataPO> pvtTestDataList = new ArrayList<>();

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () ->
                wellLogDataService.calculatePseudoPressure(pvtTestDataList, 1000));
    }

    @Test
    void testCalculatePseudoPressure_NullList_ShouldThrowException() {
        // Act & Assert
        assertThrows(IllegalArgumentException.class, () ->
                wellLogDataService.calculatePseudoPressure(null, 1000));
    }

    @Test
    void testCalculatePseudoPressure_InsufficientDataPoints_ShouldThrowException() {
        // Arrange
        List<PvtTestDataPO> pvtTestDataList = new ArrayList<>();

        PvtTestDataPO data = new PvtTestDataPO();
        data.setPvtPressure(BigDecimal.valueOf(1000));
        data.setPvtViscosity(BigDecimal.valueOf(0.8));
        data.setPvtZFactor(BigDecimal.valueOf(0.9));

        pvtTestDataList.add(data);

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () ->
                wellLogDataService.calculatePseudoPressure(pvtTestDataList, 1000));
    }

    @Test
    void testCalculatePseudoPressure_WithInterpolation() {
        // Arrange
        List<PvtTestDataPO> pvtTestDataList = new ArrayList<>();

        PvtTestDataPO data1 = new PvtTestDataPO();
        data1.setPvtPressure(BigDecimal.valueOf(1000));
        data1.setPvtViscosity(BigDecimal.valueOf(0.8));
        data1.setPvtZFactor(BigDecimal.valueOf(0.9));

        PvtTestDataPO data2 = new PvtTestDataPO();
        data2.setPvtPressure(BigDecimal.valueOf(2000));
        data2.setPvtViscosity(BigDecimal.valueOf(0.7));
        data2.setPvtZFactor(BigDecimal.valueOf(0.85));

        pvtTestDataList.add(data1);
        pvtTestDataList.add(data2);

        double bottomholePressure = 1500;

        // Act
        double result = wellLogDataService.calculatePseudoPressure(pvtTestDataList, bottomholePressure);

        // Assert
        assertTrue(result > 0);
    }

    @Test
    void testCalculatePseudoPressure_AllDataBelowBottomholePressure() {
        // Arrange
        List<PvtTestDataPO> pvtTestDataList = new ArrayList<>();

        PvtTestDataPO data1 = new PvtTestDataPO();
        data1.setPvtPressure(BigDecimal.valueOf(1000));
        data1.setPvtViscosity(BigDecimal.valueOf(0.8));
        data1.setPvtZFactor(BigDecimal.valueOf(0.9));

        PvtTestDataPO data2 = new PvtTestDataPO();
        data2.setPvtPressure(BigDecimal.valueOf(1200));
        data2.setPvtViscosity(BigDecimal.valueOf(0.75));
        data2.setPvtZFactor(BigDecimal.valueOf(0.88));

        pvtTestDataList.add(data1);
        pvtTestDataList.add(data2);

        double bottomholePressure = 1500;

        // Act
        double result = wellLogDataService.calculatePseudoPressure(pvtTestDataList, bottomholePressure);

        // Assert
        assertEquals(0, result);
    }

    @Test
    void testCalculatePseudoPressure_WithDataWithNullValues() {
        // Arrange
        List<PvtTestDataPO> pvtTestDataList = new ArrayList<>();

        PvtTestDataPO data1 = new PvtTestDataPO();
        data1.setPvtPressure(BigDecimal.valueOf(1000));
        data1.setPvtViscosity(null); // Invalid data
        data1.setPvtZFactor(BigDecimal.valueOf(0.9));

        PvtTestDataPO data2 = new PvtTestDataPO();
        data2.setPvtPressure(BigDecimal.valueOf(2000));
        data2.setPvtViscosity(BigDecimal.valueOf(0.7));
        data2.setPvtZFactor(null); // Invalid data

        PvtTestDataPO data3 = new PvtTestDataPO();
        data3.setPvtPressure(BigDecimal.valueOf(3000));
        data3.setPvtViscosity(BigDecimal.valueOf(0.6));
        data3.setPvtZFactor(BigDecimal.valueOf(0.8));

        pvtTestDataList.add(data1);
        pvtTestDataList.add(data2);
        pvtTestDataList.add(data3);

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () ->
                wellLogDataService.calculatePseudoPressure(pvtTestDataList, 1000));
    }

    @Test
    void testGenerateViscosityPlotData() {
        WellLogDataServiceImpl service = new WellLogDataServiceImpl();

        double[] temperatureRange = {0, 100};
        double[] mineralizationLevels = {100, 500, 1000};
        double step = 10;

        Map<Double, List<double[]>> result = service.generateViscosityPlotData(temperatureRange, mineralizationLevels, step);

        // 验证结果是否符合预期
        assertNotNull(result);
        assertEquals(3, result.size()); // 应该有三个矿化度的数据

        for (Map.Entry<Double, List<double[]>> entry : result.entrySet()) {
            List<double[]> dataPoints = entry.getValue();
            assertEquals(11, dataPoints.size()); // 从 0 到 100，步长为 10，应该有 11 个数据点

            for (double[] point : dataPoints) {
                assertTrue(point[0] >= 0 && point[0] <= 100); // 温度应在范围内
                assertTrue(point[1] > 0); // 粘度应大于 0
            }
        }
    }

}
