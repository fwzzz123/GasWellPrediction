package com.proj.entity.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class WellInfoDTO {

    private String wellId;
//    private Integer reservoirId;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private BigDecimal capacity;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private String wellType;


    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private BigDecimal mudContent;

    // 新增字段全部加 @JsonFormat(shape = Shape.STRING)

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private BigDecimal cUnit;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private BigDecimal k;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private BigDecimal h;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private BigDecimal lambdaGAvg;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private BigDecimal pE;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private BigDecimal pBh;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private BigDecimal rE;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private BigDecimal rW;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private BigDecimal fGAvg;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private BigDecimal phi;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private BigDecimal lambdaWAvg;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private BigDecimal kRg;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private BigDecimal muG;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private BigDecimal bG;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private BigDecimal cG;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private BigDecimal sG;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private BigDecimal dpGdt;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private BigDecimal sW;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private BigDecimal dSWdt;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private BigDecimal theta;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private String folderName;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private BigDecimal logPorosity;

    /**
     * 水平段有效长度（Effective Horizontal Length）
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private BigDecimal effectiveHorizontalLength;


    /**
     * C1含量（C1 Content）
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private BigDecimal C1Content;

    /**
     * C2含量（C2 Content）
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private BigDecimal C2Content;

    /**
     * C3含量（C3 Content）
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private BigDecimal C3Content;

    /**
     * C4+含量（C4Plus Content）
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private BigDecimal C4PlusContent;

    /**
     * CO2含量（CO2 Content）
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private BigDecimal CO2COntent;

    /**
     * N2含量（N2 Content）
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private BigDecimal N2Content;

    /**
     * 伪压力（Pseudo Pressure）
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private BigDecimal pseudoPressure;

    /**
     * 温度（Temperature）
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private BigDecimal temperature;

    /**
     * 有效渗透率（Effective Permeability）
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private BigDecimal effectivePermeability;




}
