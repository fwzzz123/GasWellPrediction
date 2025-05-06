package com.proj.entity.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.proj.utils.CommentUtils;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * @description: 实体类，映射 well_log_data 表
 * @author fw
 * @date 2025/4/28 上午10:29
 * @version 1.0
 */
@Data
@TableName("well_log_data")
public class WellLogDataPO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键 ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 井日志 ID
     */
    @TableField("well_log_id")
    private String wellLogId;

    /**
     * 深度
     */
    @CommentUtils("深度")
    @TableField("depth")
    private BigDecimal depth;

    /**
     * 伽马
     */
    @CommentUtils("伽马")
    @TableField("gamma")
    private BigDecimal gamma;

    /**
     * 密度
     */
    @CommentUtils("密度")
    @TableField("density")
    private BigDecimal density;

    /**
     * 中子
     */
    @CommentUtils("中子")
    @TableField("neutron")
    private BigDecimal neutron;

    /**
     * 垂直速度 (VP)
     */
    @CommentUtils("纵波速度")
    @TableField("vp")
    private BigDecimal vp;

    /**
     * 横向速度 (VS)
     */
    @CommentUtils("横波速度")
    @TableField("vs")
    private BigDecimal vs;

    /**
     * 深电阻
     */
    @CommentUtils("深电阻率")
    @TableField("deep_resistance")
    private BigDecimal deepResistance;

    /**
     * 中电阻
     */
    @CommentUtils("中电阻率")
    @TableField("medium_resistance")
    private BigDecimal mediumResistance;

    /**
     * 浅电阻
     */
    @CommentUtils("浅电阻率")
    @TableField("shallow_resistance")
    private BigDecimal shallowResistance;

    /**
     * 自然电位 (SP)
     */
    @CommentUtils("自然电位")
    @TableField("sp")
    private BigDecimal sp;

    /**
     * 井径
     */
    @CommentUtils("井径")
    @TableField("caliper")
    private BigDecimal caliper;

    /**
     * 岩性指数
     */
    @CommentUtils("光电吸收截面指数")
    @TableField("pe_index")
    private BigDecimal peIndex;

    /**
     * 孔隙度
     */
    @CommentUtils("孔隙度")
    @TableField("porosity")
    private BigDecimal porosity;

    /**
     * 渗透率
     */
    @CommentUtils("渗透率")
    @TableField("permeability")
    private BigDecimal permeability;

    /**
     * 含水饱和度
     */
    @CommentUtils("含水饱和度")
    @TableField("water_saturation")
    private BigDecimal waterSaturation;

    /**
     * 泥岩含量
     */
    @CommentUtils("泥岩含量")
    @TableField("shale_content")
    private BigDecimal shaleContent;




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


    /**
     * 气藏温度（ 或 K，根据单位）
     */
    @CommentUtils("气藏温度")
    @TableField("reservoir_temperature")
    private BigDecimal reservoirTemperature;

    /**
     * 气体黏度（mPa·s）
     */
    @CommentUtils("气体黏度")
    @TableField("gas_viscosity")
    private BigDecimal Viscosity;

    /**
     * 偏差因子 Z
     */
    @CommentUtils("偏差因子 Z")
    @TableField("gas_deviation_factor")
    private BigDecimal DeviationFactor;

    /**
     * 气井半径（m）
     */
    @CommentUtils("气井半径")
    @TableField("wellbore_radius")
    private BigDecimal wellboreRadius;

    /**
     * 泄气半径（m）
     */
    @CommentUtils("泄气半径")
    @TableField("drainage_radius")
    private BigDecimal drainageRadius;

    /**
     * 表皮因子
     */
    @CommentUtils("表皮因子")
    @TableField("skin_factor")
    private BigDecimal skinFactor;

    /**
     * 地层压力（MPa）
     */
    @CommentUtils("地层压力")
    @TableField("reservoir_pressure")
    private BigDecimal reservoirPressure;

    /**
     * 井底流压（MPa）
     */
    @CommentUtils("井底流压")
    @TableField("bottomhole_pressure")
    private BigDecimal bottomholePressure;

}