package com.proj.entity.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.proj.utils.CommentUtils;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.security.Timestamp;

/**
 * @description: TODO 
 * @author fw
 * @date 2025/5/4 下午6:06
 * @version 1.0
 */

/**
 * @description: 实体类，映射 pvt_test_data 表（电缆地层测试压力数据）
 * @author fw
 * @date 2025/5/4 下午6:06
 * @version 1.0
 */
@Data
@TableName("pvt_test_data")
public class PvtTestDataPO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键 ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 关联井 ID（外键）
     */
    @CommentUtils("井ID")
    @TableField("well_id")
    private String wellId;

    /**
     * 实测深度（m）
     */
    @CommentUtils("实测深度")
    @TableField("measured_depth")
    private BigDecimal measuredDepth;

    /**
     * 测前泥浆柱（MPa）
     */
    @CommentUtils("测前泥浆柱")
    @TableField("pre_mud_pressure")
    private BigDecimal preMudPressure;

    /**
     * 地层压力（MPa）
     */
    @CommentUtils("地层压力")
    @TableField("formation_pressure")
    private BigDecimal formationPressure;

    /**
     * 测后泥浆柱（MPa）
     */
    @CommentUtils("测后泥浆柱")
    @TableField("post_mud_pressure")
    private BigDecimal postMudPressure;

    /**
     * 估算流动性
     */
    @CommentUtils("流度")
    @TableField("estimated_mobility")
    private BigDecimal estimatedMobility;

    /**
     * 压力点类型（例如：初始测试点、重复测试点）
     */
    @CommentUtils("压力点类型")
    @TableField("pressure_point_type")
    private String pressurePointType;

    /**
     * 渗透性泥浆压力（MPa）
     */
    @CommentUtils("渗透性泥浆压力")
    @TableField("permeability_mud_pressure")
    private BigDecimal permeabilityMudPressure;

    /**
     * 地层温度（℃ 或 K）
     */
    @CommentUtils("地层温度")
    @TableField("reservoir_temperature")
    private BigDecimal reservoirTemperature;

    /**
     * 创建时间
     */
    @TableField("create_time")
    private Timestamp createTime;

    /**
     * 更新时间
     */
    @TableField("update_time")
    private Timestamp updateTime;

    @CommentUtils("渗透性评价")
    @TableField("permeability_evaluation")
    private String permeabilityEvaluation;

    @CommentUtils("粘度")
    @TableField("pvt_viscosity")
    private BigDecimal pvtViscosity;

    @CommentUtils("偏差因子")
    @TableField("pvt_z_factor")
    private BigDecimal pvtZFactor;

    @CommentUtils("压力")
    @TableField("pvt_pressure")
    private BigDecimal pvtPressure;

}