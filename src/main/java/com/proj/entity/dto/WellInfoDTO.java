package com.proj.entity.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.proj.utils.CommentUtils;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class WellInfoDTO {

    @CommentUtils("井名")
    private String wellId;

    @CommentUtils("文件夹名称")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private String folderName;

    @CommentUtils("初始井产能（万方/天）")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private BigDecimal capacityInit;

    @CommentUtils("有效厚度（米）")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private BigDecimal h;

    @CommentUtils("渗透率（毫达西）")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private BigDecimal k;

    @CommentUtils("孔隙度（%）")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private BigDecimal phi;

    @CommentUtils("含气饱和度（%）")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private BigDecimal sG;

    @CommentUtils("含水饱和度（%）")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private BigDecimal sW;

    @CommentUtils("测井渗透率（毫达西）")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private BigDecimal logPermeability;

    @CommentUtils("有效渗透率（毫达西）")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private BigDecimal effectivePermeability;

    @CommentUtils("地层压力（MPa）")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private BigDecimal pE;

    @CommentUtils("温度（摄氏度）")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private BigDecimal temperature;

    @CommentUtils("表皮因子")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private BigDecimal factorSkin;

    @CommentUtils("泥质含量（%）")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private BigDecimal mudContent;

    @CommentUtils("水平段有效长度（m）")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private BigDecimal effectiveHorizontalLength;

    @CommentUtils("气流度（Pa·m）")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private BigDecimal lambdaG;

    @CommentUtils("拟压力")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private BigDecimal pseudoPressure;




    @CommentUtils("井型")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private String wellType;

    @CommentUtils("拟稳态公式系数")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private BigDecimal cUnit;

    @CommentUtils("井底压力（MPa)")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private BigDecimal pBH;

    @CommentUtils("井能动半径(m)")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private BigDecimal rE;

    @CommentUtils("井半径(m)")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private BigDecimal rW;

    @CommentUtils("气体压缩因子")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private BigDecimal fGAvg;

    @CommentUtils("水相流度（D/Pa·s）")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private BigDecimal lambdaW;

    @CommentUtils("气体相对渗透率")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private BigDecimal krg;

    @CommentUtils("气体粘度（Pa·s）")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private BigDecimal muG;

    @CommentUtils("气体体积系数")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private BigDecimal bG;

    @CommentUtils("气体压缩系数 (1/Pa)")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private BigDecimal cG;

    @CommentUtils("储层压力的动态变化率（Pa/s）")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private BigDecimal dpGdt;



    @CommentUtils("含水饱和度变化率 (1/day)")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private BigDecimal dSWdt;

    @CommentUtils("拟稳态公式综合动态系数")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private BigDecimal theta;



    @CommentUtils("测井孔隙度（%）")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private BigDecimal logPorosity;


    @CommentUtils("C1含量（%）")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private BigDecimal c1Content;

    @CommentUtils("C2含量（%）")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private BigDecimal c2Content;

    @CommentUtils("C3含量（%）")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private BigDecimal c3Content;

    @CommentUtils("C4+含量（%）")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private BigDecimal c4PlusContent;

    @CommentUtils("CO2含量（%）")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private BigDecimal co2Content;

    @CommentUtils("N2含量（%）")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private BigDecimal n2Content;


    @CommentUtils("测井含水饱和度（%）")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private BigDecimal saturationWaterLog;

    /**
     * 测井含气饱和度（Log Gas Saturation）
     */
    @CommentUtils("测井含气饱和度（%）")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private BigDecimal saturationGasLog;

    @CommentUtils("伽马测井值")
    private Double gamma;

    @CommentUtils("密度测井值")
    private Double density;

    @CommentUtils("中子测井值")
    private Double neutron;

    @CommentUtils("纵波速度")
    private Double vp;

    @CommentUtils("横波速度")
    private Double vs;

    @CommentUtils("深电阻率")
    private Double deepResistance;

    @CommentUtils("中电阻率")
    private Double mediumResistance;

    @CommentUtils("浅电阻率")
    private Double shallowResistance;


    @CommentUtils("自然电位")
    private Double sp;

    @CommentUtils("测井井径")
    private Double caliper;

    @CommentUtils("光电吸收截面指数")
    private Double peIndex;

    /**
     * 渗透率计算值（Log Permeability）
     */
    @CommentUtils("渗透率计算值（mD)")
    private Double permeability;

    /**
     * 含水饱和度计算值（Log Water Saturation）
     */
    @CommentUtils("含水饱和度计算值（%）")
    private Double waterSaturation;

    /**
     * 泥质含量测井值（Log Shale Content）
     */
    @CommentUtils("测井解释泥质含量测井值（%）")
    private Double shaleContentLog;

    /**
     * 解释泥质含量（Interpreted Shale Content）
     */
    @CommentUtils("测井解释泥质含量（%）")
    private Double shaleContentExplan;

    /**
     * 解释孔隙度（Interpreted Porosity）
     */
    @CommentUtils("测井解释孔隙度（%）")
    private Double porosityExplan;

    /**
     * 解释含水饱和度（Interpreted Water Saturation）
     */
    @CommentUtils("测井解释含水饱和度（%）")
    private Double waterSaturationExplan;

    /**
     * 解释渗透率（Interpreted Permeability）
     */
    @CommentUtils("测井解释渗透率（mD）")
    private Double permeabilityExplan;

    /**
     * 烃饱和度（Hydrocarbon Saturation）
     */
    @CommentUtils("折算烃饱和度（%）")
    private Double hydrocarbonSaturation;

    /**
     * 孔喉半径（Capillary Radius）
     */
    @CommentUtils("孔喉半径")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private BigDecimal radiusCapillary;

    @CommentUtils("产能预测值（万方/天）")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private BigDecimal capacity;

}
