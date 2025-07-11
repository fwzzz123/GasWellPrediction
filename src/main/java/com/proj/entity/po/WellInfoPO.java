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
@TableName(value ="Well_Info")
@Data
public class WellInfoPO implements Serializable {

    /**
     * 主键：井ID
     */
    @TableId
    private String wellId;

    /**
     * 外键：储层ID
     */
    private Integer reservoirId;

    /**
     * 产能
     */
    private BigDecimal capacity;

    /**
     * 井类型
     */
    private String wellType;

    /**
     * 井坐标
     */
    private String wellCoordinates;

    /**
     * 井段
     */
    private BigDecimal section;

    /**
     * 泥质度
     */
    private BigDecimal mudContent;

    // 新增字段

    /**
     * 单位转换系数
     */
    @TableField("C_unit")
    private BigDecimal cUnit;

    /**
     * 渗透率 (mD)
     */
    private BigDecimal k;

    /**
     * 储层厚度 (m)
     */
    private BigDecimal h;

    /**
     * 平均气体流动性 (λ̃g)
     */
    private BigDecimal lambdaGAvg;

    /**
     * 边界压力 (MPa)
     */
    @TableField("p_E")
    private BigDecimal pE;

    /**
     * 井底压力 (MPa)
     */
    @TableField("p_BH")
    private BigDecimal pBH;

    /**
     * 边界半径 (m)
     */
    @TableField("r_E")
    private BigDecimal rE;

    /**
     * 井筒半径 (m)
     */
    @TableField("r_w")
    private BigDecimal rW;

    /**
     * 平均气体压缩因子 (f̃g)
     */
    @TableField("f_g_avg")
    private BigDecimal fGAvg;

    /**
     * 孔隙度 (ϕ)
     */
    private BigDecimal phi;

    /**
     * 平均水相流度 (λ̃w)
     */
    private BigDecimal lambdaWAvg;

    /**
     * 气相相对渗透率
     */
    @TableField("k_rg")
    private BigDecimal kRg;

    /**
     * 气体黏度 (cP)
     */
    @TableField("mu_g")
    private BigDecimal muG;

    /**
     * 气体体积系数
     */
    @TableField("B_g")
    private BigDecimal bG;

    /**
     * 气体压缩系数 (1/MPa)
     */
    @TableField("c_g")
    private BigDecimal cG;

    /**
     * 气相饱和度
     */
    @TableField("S_g")
    private BigDecimal sG;

    /**
     * 压力变化率 (MPa/day)
     */
    @TableField("dp_g_dt")
    private BigDecimal dpGdt;

    /**
     * 含水饱和度
     */
    @TableField("S_w")
    private BigDecimal sW;

    /**
     * 含水饱和度变化率 (1/day)
     */
    @TableField("dS_w_dt")
    private BigDecimal dSWdt;

    /**
     * 综合动态参数 (θ)
     */
    private BigDecimal theta;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @TableField("folder_name")
    private String folderName;
    // equals(), hashCode(), toString() 方法可自动生成或保留原有逻辑不变
}