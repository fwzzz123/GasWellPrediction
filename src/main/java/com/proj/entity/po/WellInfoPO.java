package com.proj.entity.po;

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
     * 
     */
    @TableId
    private String wellId;

    /**
     * 
     */
    private Integer reservoirId;

    /**
     * 
     */
    private BigDecimal capacity;

    /**
     * 
     */
    private String wellName;

    /**
     * 
     */
    private String wellType;

    /**
     * 
     */
    private String wellStatus;

    /**
     * 
     */
    private String wellCoordinates;

    /**
     * 
     */
    private Date completionDate;

    /**
     * 
     */
    private BigDecimal section;

    /**
     * 
     */
    private BigDecimal thicknessContent;

    /**
     * 
     */
    private BigDecimal mudContent;

    /**
     * 
     */
    private BigDecimal porositySaturation;

    /**
     * 
     */
    private BigDecimal waterCut;

    /**
     * 
     */
    private BigDecimal permeableThickness;

    /**
     * 
     */
    private BigDecimal equivalentHydrocarbons;

    /**
     * 
     */
    private String conclusion;

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
        WellInfoPO other = (WellInfoPO) that;
        return (this.getWellId() == null ? other.getWellId() == null : this.getWellId().equals(other.getWellId()))
            && (this.getReservoirId() == null ? other.getReservoirId() == null : this.getReservoirId().equals(other.getReservoirId()))
            && (this.getCapacity() == null ? other.getCapacity() == null : this.getCapacity().equals(other.getCapacity()))
            && (this.getWellName() == null ? other.getWellName() == null : this.getWellName().equals(other.getWellName()))
            && (this.getWellType() == null ? other.getWellType() == null : this.getWellType().equals(other.getWellType()))
            && (this.getWellStatus() == null ? other.getWellStatus() == null : this.getWellStatus().equals(other.getWellStatus()))
            && (this.getWellCoordinates() == null ? other.getWellCoordinates() == null : this.getWellCoordinates().equals(other.getWellCoordinates()))
            && (this.getCompletionDate() == null ? other.getCompletionDate() == null : this.getCompletionDate().equals(other.getCompletionDate()))
            && (this.getSection() == null ? other.getSection() == null : this.getSection().equals(other.getSection()))
            && (this.getThicknessContent() == null ? other.getThicknessContent() == null : this.getThicknessContent().equals(other.getThicknessContent()))
            && (this.getMudContent() == null ? other.getMudContent() == null : this.getMudContent().equals(other.getMudContent()))
            && (this.getPorositySaturation() == null ? other.getPorositySaturation() == null : this.getPorositySaturation().equals(other.getPorositySaturation()))
            && (this.getWaterCut() == null ? other.getWaterCut() == null : this.getWaterCut().equals(other.getWaterCut()))
            && (this.getPermeableThickness() == null ? other.getPermeableThickness() == null : this.getPermeableThickness().equals(other.getPermeableThickness()))
            && (this.getEquivalentHydrocarbons() == null ? other.getEquivalentHydrocarbons() == null : this.getEquivalentHydrocarbons().equals(other.getEquivalentHydrocarbons()))
            && (this.getConclusion() == null ? other.getConclusion() == null : this.getConclusion().equals(other.getConclusion()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getWellId() == null) ? 0 : getWellId().hashCode());
        result = prime * result + ((getReservoirId() == null) ? 0 : getReservoirId().hashCode());
        result = prime * result + ((getCapacity() == null) ? 0 : getCapacity().hashCode());
        result = prime * result + ((getWellName() == null) ? 0 : getWellName().hashCode());
        result = prime * result + ((getWellType() == null) ? 0 : getWellType().hashCode());
        result = prime * result + ((getWellStatus() == null) ? 0 : getWellStatus().hashCode());
        result = prime * result + ((getWellCoordinates() == null) ? 0 : getWellCoordinates().hashCode());
        result = prime * result + ((getCompletionDate() == null) ? 0 : getCompletionDate().hashCode());
        result = prime * result + ((getSection() == null) ? 0 : getSection().hashCode());
        result = prime * result + ((getThicknessContent() == null) ? 0 : getThicknessContent().hashCode());
        result = prime * result + ((getMudContent() == null) ? 0 : getMudContent().hashCode());
        result = prime * result + ((getPorositySaturation() == null) ? 0 : getPorositySaturation().hashCode());
        result = prime * result + ((getWaterCut() == null) ? 0 : getWaterCut().hashCode());
        result = prime * result + ((getPermeableThickness() == null) ? 0 : getPermeableThickness().hashCode());
        result = prime * result + ((getEquivalentHydrocarbons() == null) ? 0 : getEquivalentHydrocarbons().hashCode());
        result = prime * result + ((getConclusion() == null) ? 0 : getConclusion().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", wellId=").append(wellId);
        sb.append(", reservoirId=").append(reservoirId);
        sb.append(", capacity=").append(capacity);
        sb.append(", wellName=").append(wellName);
        sb.append(", wellType=").append(wellType);
        sb.append(", wellStatus=").append(wellStatus);
        sb.append(", wellCoordinates=").append(wellCoordinates);
        sb.append(", completionDate=").append(completionDate);
        sb.append(", section=").append(section);
        sb.append(", thicknessContent=").append(thicknessContent);
        sb.append(", mudContent=").append(mudContent);
        sb.append(", porositySaturation=").append(porositySaturation);
        sb.append(", waterCut=").append(waterCut);
        sb.append(", permeableThickness=").append(permeableThickness);
        sb.append(", equivalentHydrocarbons=").append(equivalentHydrocarbons);
        sb.append(", conclusion=").append(conclusion);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}