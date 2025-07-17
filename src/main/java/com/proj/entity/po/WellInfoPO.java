package com.proj.entity.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 
 * @TableName Well_Info
 */
@TableName(value ="well_info")
@Data
public class WellInfoPO implements Serializable {

    /**
     * 主键：井ID
     */
    @TableId("well_id")
    private String wellId;


    /**
     * 产能
     */
    @TableField("absolute_open_flow")
    private BigDecimal capacity;

    /**
     * 井类型
     */
    @TableField("well_type")
    private String wellType;



    /**
     * 泥质度
     */
    @TableField("shale_content")
    private BigDecimal mudContent;

    // 新增字段

    /**
     * 单位转换系数
     */
    @TableField("c_unit")
    private BigDecimal cUnit;

    /**
     * 渗透率 (mD)
     */
    @TableField("permeability_effective")
    private BigDecimal k;

    /**
     * 储层厚度 (m)
     */
    @TableField("thickness")
    private BigDecimal h;

    /**
     * 平均气体流动性 (λ̃g)
     */
    @TableField("lambda_g")
    private BigDecimal lambdaGAvg;

    /**
     * 边界压力 (MPa)
     */
    @TableField("pressure_boundary")
    private BigDecimal pE;

    /**
     * 井底压力 (MPa)
     */
    @TableField("pressure_borehole")
    private BigDecimal pBH;

    /**
     * 边界半径 (m)
     */
    @TableField("radius_border")
    private BigDecimal rE;

    /**
     * 井筒半径 (m)
     */
    @TableField("radius_well")
    private BigDecimal rW;

    /**
     * 平均气体压缩因子 (f̃g)
     */
    @TableField("factor_gas_compression")
    private BigDecimal fGAvg;

    /**
     * 孔隙度 (ϕ)
     */
    @TableField("porosity")
    private BigDecimal phi;

    /**
     * 平均水相流度 (λ̃w)
     */
    @TableField("lambda_w")
    private BigDecimal lambdaWAvg;

    /**
     * 气相相对渗透率
     */
    @TableField("permeability_relative_gas")
    private BigDecimal kRg;

    /**
     * 气体黏度 (cP)
     */
    @TableField("viscosity_gas")
    private BigDecimal muG;

    /**
     * 气体体积系数
     */
    @TableField("factor_gas_volume")
    private BigDecimal bG;

    /**
     * 气体压缩系数 (1/MPa)
     */
    @TableField("factor_gas_compression_")
    private BigDecimal cG;

    /**
     * 气相饱和度
     */
    @TableField("saturation_gas")
    private BigDecimal sG;

    /**
     * 压力变化率 (MPa/day)
     */
    @TableField("dpg_dt")
    private BigDecimal dpGdt;

    /**
     * 含水饱和度
     */
    @TableField("saturation_water")
    private BigDecimal sW;

    /**
     * 含水饱和度变化率 (1/day)
     */
    @TableField("dsw_dt")
    private BigDecimal dSWdt;

    /**
     * 综合动态参数 (θ)
     */
    @TableField("theta")
    private BigDecimal theta;

//    @TableField(exist = false)
//    private static final long serialVersionUID = 1L;

    @TableField("folder_name")
    private String folderName;


    /**
     * 测井孔隙度（Log Porosity）
     */
    @TableField("porosity_log")
    private BigDecimal logPorosity;

    /**
     * 水平段有效长度（Effective Horizontal Length）
     */
    @TableField("effective_horizontal_length")
    private BigDecimal effectiveHorizontalLength;



    /**
     * C1含量（C1 Content）
     */
    @TableField("c1_content")
    private BigDecimal C1Content;

    /**
     * C2含量（C2 Content）
     */
    @TableField("c2_content")
    private BigDecimal C2Content;

    /**
     * C3含量（C3 Content）
     */
    @TableField("c3_content")
    private BigDecimal C3Content;

    /**
     * C4+含量（C4Plus Content）
     */
    @TableField("c4plus_content")
    private BigDecimal C4PlusContent;

    /**
     * CO2含量（CO2 Content）
     */
    @TableField("co2_content")
    private BigDecimal CO2Content;

    /**
     * N2含量（N2 Content）
     */
    @TableField("n2_content")
    private BigDecimal N2Content;


    /**
     * 温度（Temperature）
     */
    @TableField("temperature")
    private BigDecimal temperature;

    /**
     * 测井渗透率（Effective Permeability）
     */
    @TableField("permeability_log")
    private BigDecimal logPermeability;

}