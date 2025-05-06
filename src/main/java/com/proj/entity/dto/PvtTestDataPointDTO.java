package com.proj.entity.dto;

/**
 * @description: TODO 
 * @author fw
 * @date 2025/5/5 下午3:21
 * @version 1.0
 */

import lombok.Data;

import java.math.BigDecimal;

/**
 * @description: 电缆地层测试压力数据点 DTO
 * @author fw
 * @date 2025/5/5 下午3:10
 * @version 1.0
 */
@Data
public class PvtTestDataPointDTO {

    /**
     * 实测深度（m）
     */
    private BigDecimal measuredDepth;

    /**
     * 测前泥浆柱压力（psi）
     */
    private BigDecimal preMudPressure;

    /**
     * 最终测压读值（psi）
     */
    private BigDecimal finalTestPressure;

    /**
     * 地层压力（psi）
     */
    private BigDecimal formationPressure;

    /**
     * 测后泥浆柱压力（psi）
     */
    private BigDecimal postMudPressure;

    /**
     * 估算流动性（MD/CP）
     */
    private BigDecimal estimatedMobility;

    /**
     * 地层压力系数
     */
    private BigDecimal formationPressureCoefficient;

    /**
     * 地层温度（℃）
     */
    private BigDecimal reservoirTemperature;

    /**
     * 压力点类型（例如：初始测试点、重复测试点）
     */
    private String pressurePointType;

    /**
     * 渗透性评价
     */
    private String permeabilityEvaluation;

    /**
     * 泥浆压力系数
     */
    private BigDecimal mudPressureCoefficient;

    /**
     * 粘度
     */
    private BigDecimal pvt_viscosity;

    /**
     * 偏差因子
     */
    private BigDecimal pvt_z_factor;

    /**
     * 压力
     */
    private BigDecimal pvt_pressure;


}