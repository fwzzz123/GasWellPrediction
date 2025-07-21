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
    private BigDecimal lambdaG;

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
    private BigDecimal lambdaW;

    /**
     * 气相相对渗透率
     */
    @TableField("permeability_relative_gas")
    private BigDecimal krg;

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
    private BigDecimal c1Content;

    /**
     * C2含量（C2 Content）
     */
    @TableField("c2_content")
    private BigDecimal c2Content;

    /**
     * C3含量（C3 Content）
     */
    @TableField("c3_content")
    private BigDecimal c3Content;

    /**
     * C4+含量（C4Plus Content）
     */
    @TableField("c4plus_content")
    private BigDecimal c4PlusContent;

    /**
     * CO2含量（CO2 Content）
     */
    @TableField("co2_content")
    private BigDecimal co2Content;

    /**
     * N2含量（N2 Content）
     */
    @TableField("n2_content")
    private BigDecimal n2Content;


    /**
     * 温度（Temperature）
     */
    @TableField("temperature")
    private BigDecimal temperature;

    /**
     * 测井渗透率
     */
    @TableField("permeability_log")
    private BigDecimal logPermeability;


//    0718后新增字段

    /**
     * 测井含水饱和度
     */
    @TableField("saturation_water_log")
    private BigDecimal saturationWaterLog;

    /**
     * 测井含气饱和度
     */
    @TableField("saturation_gas_log")
    private BigDecimal saturationGasLog;

    /**
     * 伽马测井值
     */
    @TableField("gamma")
    private Double gamma;

    /**
     * 密度测井值
     */
    @TableField("density")
    private Double density;

    /**
     * 中子测井值
     */
    @TableField("neutron")
    private Double neutron;

    /**
     * 纵波速度 (m/s)
     */
    @TableField("vp")
    private Double vp;

    /**
     * 横波速度 (m/s)
     */
    @TableField("vs")
    private Double vs;

    /**
     * 深电阻率 (Ω·m)
     */
    @TableField("deep_resistance")
    private Double deepResistance;

    /**
     * 中电阻率 (Ω·m)
     */
    @TableField("medium_resistance")
    private Double mediumResistance;

    /**
     * 浅电阻率 (Ω·m)
     */
    @TableField("shallow_resistance")
    private Double shallowResistance;

    /**
     * 自然电位 (mV)
     */
    @TableField("sp")
    private Double sp;

    /**
     * 井径 (cm)
     */
    @TableField("caliper")
    private Double caliper;

    /**
     * 光电吸收截面指数
     */
    @TableField("pe_index")
    private Double peIndex;

    /**
     * 渗透率测井值 (mD)
     */
    @TableField("permeability")
    private Double permeability;

    /**
     * 含水饱和度测井值
     */
    @TableField("water_saturation")
    private Double waterSaturation;

    /**
     * 泥质含量测井值
     */
    @TableField("shale_content_log")
    private Double shaleContentLog;


    /**
     * 解释泥质含量
     */
    @TableField("shale_content_explan")
    private Double shaleContentExplan;

    /**
     * 解释孔隙度
     */
    @TableField("porosity_explan")
    private Double porosityExplan;

    /**
     * 解释含水饱和度
     */
    @TableField("water_saturation_explan")
    private Double waterSaturationExplan;

    /**
     * 解释渗透率
     */
    @TableField("permeability_explan")
    private Double permeabilityExplan;

    /**
     * 烃饱和度
     */
    @TableField("hydrocarbon_saturation")
    private Double hydrocarbonSaturation;

    /**
     * 孔喉半径 (μm)
     */
    @TableField("radius_capillary")
    private BigDecimal radiusCapillary;

}