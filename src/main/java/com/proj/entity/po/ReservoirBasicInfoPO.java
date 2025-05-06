package com.proj.entity.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 
 * @TableName Reservoir_Basic_Info
 */
@TableName(value ="Reservoir_Basic_Info")
@Data
public class ReservoirBasicInfoPO implements Serializable {


    /**
     * 气藏ID，主键
     */
    @TableId(value = "Reservoir_ID", type = IdType.AUTO)
    private Integer reservoirId;

    /**
     * 气藏名称
     */
    @TableField("Reservoir_Name")
    private String reservoirName;

    /**
     * 气藏位置
     */
    @TableField("Location")
    private String location;

    /**
     * 地层类型
     */
    @TableField("Formation_Type")
    private String formationType;

    /**
     * 气藏深度（单位：米）
     */
    @TableField("Depth")
    private BigDecimal depth;

    /**
     * 孔隙度（单位：%）
     */
    @TableField("Porosity")
    private BigDecimal porosity;

    @TableField("Permeability")
    private BigDecimal permeability;

    /**
     * 气藏压力（单位：MPa）
     */
    @TableField("Reservoir_Pressure")
    private BigDecimal reservoirPressure;

    /**
     * 原油粘度（单位：mPa·s）
     */
    @TableField("Oil_Viscosity")
    private BigDecimal oilViscosity;

    /**
     * 初始原油量（单位：百万桶）
     */
    @TableField("Initial_Oil_In_Place")
    private BigDecimal initialOilInPlace;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        ReservoirBasicInfoPO other = (ReservoirBasicInfoPO) that;
        return (this.getReservoirId() == null ? other.getReservoirId() == null : this.getReservoirId().equals(other.getReservoirId()))
            && (this.getReservoirName() == null ? other.getReservoirName() == null : this.getReservoirName().equals(other.getReservoirName()))
            && (this.getLocation() == null ? other.getLocation() == null : this.getLocation().equals(other.getLocation()))
            && (this.getFormationType() == null ? other.getFormationType() == null : this.getFormationType().equals(other.getFormationType()))
            && (this.getDepth() == null ? other.getDepth() == null : this.getDepth().equals(other.getDepth()))
            && (this.getPorosity() == null ? other.getPorosity() == null : this.getPorosity().equals(other.getPorosity()))
            && (this.getPermeability() == null ? other.getPermeability() == null : this.getPermeability().equals(other.getPermeability()))
            && (this.getReservoirPressure() == null ? other.getReservoirPressure() == null : this.getReservoirPressure().equals(other.getReservoirPressure()))
            && (this.getOilViscosity() == null ? other.getOilViscosity() == null : this.getOilViscosity().equals(other.getOilViscosity()))
            && (this.getInitialOilInPlace() == null ? other.getInitialOilInPlace() == null : this.getInitialOilInPlace().equals(other.getInitialOilInPlace()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getReservoirId() == null) ? 0 : getReservoirId().hashCode());
        result = prime * result + ((getReservoirName() == null) ? 0 : getReservoirName().hashCode());
        result = prime * result + ((getLocation() == null) ? 0 : getLocation().hashCode());
        result = prime * result + ((getFormationType() == null) ? 0 : getFormationType().hashCode());
        result = prime * result + ((getDepth() == null) ? 0 : getDepth().hashCode());
        result = prime * result + ((getPorosity() == null) ? 0 : getPorosity().hashCode());
        result = prime * result + ((getPermeability() == null) ? 0 : getPermeability().hashCode());
        result = prime * result + ((getReservoirPressure() == null) ? 0 : getReservoirPressure().hashCode());
        result = prime * result + ((getOilViscosity() == null) ? 0 : getOilViscosity().hashCode());
        result = prime * result + ((getInitialOilInPlace() == null) ? 0 : getInitialOilInPlace().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", reservoirId=").append(reservoirId);
        sb.append(", reservoirName=").append(reservoirName);
        sb.append(", location=").append(location);
        sb.append(", formationType=").append(formationType);
        sb.append(", depth=").append(depth);
        sb.append(", porosity=").append(porosity);
        sb.append(", permeability=").append(permeability);
        sb.append(", reservoirPressure=").append(reservoirPressure);
        sb.append(", oilViscosity=").append(oilViscosity);
        sb.append(", initialOilInPlace=").append(initialOilInPlace);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}