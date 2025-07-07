package com.proj.entity.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class WellInfoDTO {

    private String wellId;
    private Integer reservoirId;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private BigDecimal capacity;

    private String wellType;
    private String wellCoordinates;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private BigDecimal section;

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
    private BigDecimal pBH;

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
}
