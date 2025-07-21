package com.proj.entity.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.proj.utils.CommentUtils;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class WellInfoDTO {

    @CommentUtils("井ID")
    private String wellId;

    @CommentUtils("井产能")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private BigDecimal capacity;

    @CommentUtils("井型")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private String wellType;

    @CommentUtils("泥质含量")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private BigDecimal mudContent;

    @CommentUtils("拟稳态公式系数")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private BigDecimal cUnit;

    @CommentUtils("有效渗透率")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private BigDecimal k;

    @CommentUtils("有效层厚")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private BigDecimal h;

    @CommentUtils("气的流度")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private BigDecimal lambdaG;

    @CommentUtils("井的边界压力")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private BigDecimal pE;

    @CommentUtils("井底压力")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private BigDecimal pBH;

    @CommentUtils("井能动半径")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private BigDecimal rE;

    @CommentUtils("井半径")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private BigDecimal rW;

    @CommentUtils("气体压缩因子")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private BigDecimal fGAvg;

    @CommentUtils("孔隙度")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private BigDecimal phi;

    @CommentUtils("水相流度")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private BigDecimal lambdaW;

    @CommentUtils("气体相对渗透率")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private BigDecimal krg;

    @CommentUtils("气体粘度")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private BigDecimal muG;

    @CommentUtils("气体体积系数")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private BigDecimal bG;

    @CommentUtils("气体压缩系数 (1/MPa)")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private BigDecimal cG;

    @CommentUtils("气相渗透率")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private BigDecimal sG;

    @CommentUtils("压力变化率")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private BigDecimal dpGdt;

    @CommentUtils("水相含水饱和度")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private BigDecimal sW;

    @CommentUtils("含水饱和度变化率 (1/day)")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private BigDecimal dSWdt;

    @CommentUtils("拟稳态公式综合动态系数")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private BigDecimal theta;

    @CommentUtils("文件夹名称")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private String folderName;

    @CommentUtils("测井孔隙度")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private BigDecimal logPorosity;

    @CommentUtils("测井渗透率")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private BigDecimal logPermeability;

    /**
     * 水平段有效长度（Effective Horizontal Length）
     */
    @CommentUtils("水平段有效长度")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private BigDecimal effectiveHorizontalLength;

    /**
     * C1含量（C1 Content）
     */
    @CommentUtils("C1含量")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private BigDecimal c1Content;

    /**
     * C2含量（C2 Content）
     */
    @CommentUtils("C2含量")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private BigDecimal c2Content;

    /**
     * C3含量（C3 Content）
     */
    @CommentUtils("C3含量")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private BigDecimal c3Content;

    /**
     * C4+含量（C4Plus Content）
     */
    @CommentUtils("C4+含量")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private BigDecimal c4PlusContent;

    /**
     * CO2含量（CO2 Content）
     */
    @CommentUtils("CO2含量")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private BigDecimal co2Content;

    /**
     * N2含量（N2 Content）
     */
    @CommentUtils("N2含量")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private BigDecimal n2Content;

    /**
     * 伪压力（Pseudo Pressure）
     */
    @CommentUtils("拟压力公式计算值")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private BigDecimal pseudoPressure;

    /**
     * 温度（Temperature）
     */
    @CommentUtils("温度")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private BigDecimal temperature;

    /**
     * 有效渗透率（Effective Permeability）
     */
    @CommentUtils("有效渗透率")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private BigDecimal effectivePermeability;

    /**
     * 测井含水饱和度（Log Water Saturation）
     */
    @CommentUtils("测井含水饱和度")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private BigDecimal saturationWaterLog;

    /**
     * 测井含气饱和度（Log Gas Saturation）
     */
    @CommentUtils("测井含气饱和度")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private BigDecimal saturationGasLog;

    /**
     * 伽马测井值（Gamma Ray）
     */
    @CommentUtils("伽马测井值")
    private Double gamma;

    /**
     * 密度测井值（Density）
     */
    @CommentUtils("密度测井值")
    private Double density;

    /**
     * 中子测井值（Neutron Porosity）
     */
    @CommentUtils("中子测井值")
    private Double neutron;

    /**
     * 纵波速度（Compressional Wave Velocity）
     */
    @CommentUtils("纵波速度")
    private Double vp;

    /**
     * 横波速度（Shear Wave Velocity）
     */
    @CommentUtils("横波速度")
    private Double vs;

    /**
     * 深电阻率（Deep Resistivity）
     */
    @CommentUtils("深电阻率")
    private Double deepResistance;

    /**
     * 中电阻率（Medium Resistivity）
     */
    @CommentUtils("中电阻率")
    private Double mediumResistance;

    /**
     * 浅电阻率（Shallow Resistivity）
     */
    @CommentUtils("浅电阻率")
    private Double shallowResistance;

    /**
     * 自然电位（Spontaneous Potential）
     */
    @CommentUtils("自然电位")
    private Double sp;

    /**
     * 井径（Caliper）
     */
    @CommentUtils("测井井径")
    private Double caliper;

    /**
     * 光电吸收截面指数（PE Index）
     */
    @CommentUtils("光电吸收截面指数")
    private Double peIndex;

    /**
     * 渗透率计算值（Log Permeability）
     */
    @CommentUtils("渗透率计算值")
    private Double permeability;

    /**
     * 含水饱和度计算值（Log Water Saturation）
     */
    @CommentUtils("含水饱和度计算值")
    private Double waterSaturation;

    /**
     * 泥质含量测井值（Log Shale Content）
     */
    @CommentUtils("测井解释泥质含量测井值")
    private Double shaleContentLog;

    /**
     * 解释泥质含量（Interpreted Shale Content）
     */
    @CommentUtils("测井解释泥质含量")
    private Double shaleContentExplan;

    /**
     * 解释孔隙度（Interpreted Porosity）
     */
    @CommentUtils("测井解释孔隙度")
    private Double porosityExplan;

    /**
     * 解释含水饱和度（Interpreted Water Saturation）
     */
    @CommentUtils("测井解释含水饱和度")
    private Double waterSaturationExplan;

    /**
     * 解释渗透率（Interpreted Permeability）
     */
    @CommentUtils("测井解释渗透率")
    private Double permeabilityExplan;

    /**
     * 烃饱和度（Hydrocarbon Saturation）
     */
    @CommentUtils("折算烃饱和度")
    private Double hydrocarbonSaturation;

    /**
     * 孔喉半径（Capillary Radius）
     */
    @CommentUtils("孔喉半径")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private BigDecimal radiusCapillary;



}
