package com.proj.entity.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName well_explanations
 */
@TableName(value ="well_explanations")
@Data
public class WellExplanationsPO implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Object explainId;

    /**
     * 
     */
    private String wellId;

    /**
     * 
     */
    private Integer logType;

    /**
     * 
     */
    private Double startDepth;

    /**
     * 
     */
    private Double endDepth;

    /**
     * 
     */
    private Double thickness;

    /**
     * 
     */
    private Double clayContent;

    /**
     * 
     */
    private Double porosity;

    /**
     * 
     */
    private Double waterSaturation;

    /**
     * 
     */
    private Double permeability;

    /**
     * 
     */
    private Double hydrocarbonSaturation;

    /**
     * 
     */
    private Double startVerticalDepth;

    /**
     * 
     */
    private Double endVerticalDepth;

    /**
     * 
     */
    private Double verticalThickness;

    /**
     * 
     */
    private Double startTvt;

    /**
     * 
     */
    private Double endTvt;

    /**
     * 
     */
    private Double tvtThickness;

    /**
     * 
     */
    private Double gamma;

    /**
     * 
     */
    private Double deepResistivity;

    /**
     * 
     */
    private Double apparentResistivity;

    /**
     * 
     */
    private Double density;

    /**
     * 
     */
    private Double neutron;

    /**
     * 
     */
    private Double acoustic;

    /**
     * 
     */
    private Double totalHydrocarbon;

    /**
     * 
     */
    private Double hydrocarbonThickness;

    /**
     * 
     */
    private String oilLevel;

    /**
     * 
     */
    private String lithology;

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
        WellExplanationsPO other = (WellExplanationsPO) that;
        return (this.getExplainId() == null ? other.getExplainId() == null : this.getExplainId().equals(other.getExplainId()))
            && (this.getWellId() == null ? other.getWellId() == null : this.getWellId().equals(other.getWellId()))
            && (this.getLogType() == null ? other.getLogType() == null : this.getLogType().equals(other.getLogType()))
            && (this.getStartDepth() == null ? other.getStartDepth() == null : this.getStartDepth().equals(other.getStartDepth()))
            && (this.getEndDepth() == null ? other.getEndDepth() == null : this.getEndDepth().equals(other.getEndDepth()))
            && (this.getThickness() == null ? other.getThickness() == null : this.getThickness().equals(other.getThickness()))
            && (this.getClayContent() == null ? other.getClayContent() == null : this.getClayContent().equals(other.getClayContent()))
            && (this.getPorosity() == null ? other.getPorosity() == null : this.getPorosity().equals(other.getPorosity()))
            && (this.getWaterSaturation() == null ? other.getWaterSaturation() == null : this.getWaterSaturation().equals(other.getWaterSaturation()))
            && (this.getPermeability() == null ? other.getPermeability() == null : this.getPermeability().equals(other.getPermeability()))
            && (this.getHydrocarbonSaturation() == null ? other.getHydrocarbonSaturation() == null : this.getHydrocarbonSaturation().equals(other.getHydrocarbonSaturation()))
            && (this.getStartVerticalDepth() == null ? other.getStartVerticalDepth() == null : this.getStartVerticalDepth().equals(other.getStartVerticalDepth()))
            && (this.getEndVerticalDepth() == null ? other.getEndVerticalDepth() == null : this.getEndVerticalDepth().equals(other.getEndVerticalDepth()))
            && (this.getVerticalThickness() == null ? other.getVerticalThickness() == null : this.getVerticalThickness().equals(other.getVerticalThickness()))
            && (this.getStartTvt() == null ? other.getStartTvt() == null : this.getStartTvt().equals(other.getStartTvt()))
            && (this.getEndTvt() == null ? other.getEndTvt() == null : this.getEndTvt().equals(other.getEndTvt()))
            && (this.getTvtThickness() == null ? other.getTvtThickness() == null : this.getTvtThickness().equals(other.getTvtThickness()))
            && (this.getGamma() == null ? other.getGamma() == null : this.getGamma().equals(other.getGamma()))
            && (this.getDeepResistivity() == null ? other.getDeepResistivity() == null : this.getDeepResistivity().equals(other.getDeepResistivity()))
            && (this.getApparentResistivity() == null ? other.getApparentResistivity() == null : this.getApparentResistivity().equals(other.getApparentResistivity()))
            && (this.getDensity() == null ? other.getDensity() == null : this.getDensity().equals(other.getDensity()))
            && (this.getNeutron() == null ? other.getNeutron() == null : this.getNeutron().equals(other.getNeutron()))
            && (this.getAcoustic() == null ? other.getAcoustic() == null : this.getAcoustic().equals(other.getAcoustic()))
            && (this.getTotalHydrocarbon() == null ? other.getTotalHydrocarbon() == null : this.getTotalHydrocarbon().equals(other.getTotalHydrocarbon()))
            && (this.getHydrocarbonThickness() == null ? other.getHydrocarbonThickness() == null : this.getHydrocarbonThickness().equals(other.getHydrocarbonThickness()))
            && (this.getOilLevel() == null ? other.getOilLevel() == null : this.getOilLevel().equals(other.getOilLevel()))
            && (this.getLithology() == null ? other.getLithology() == null : this.getLithology().equals(other.getLithology()))
            && (this.getConclusion() == null ? other.getConclusion() == null : this.getConclusion().equals(other.getConclusion()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getExplainId() == null) ? 0 : getExplainId().hashCode());
        result = prime * result + ((getWellId() == null) ? 0 : getWellId().hashCode());
        result = prime * result + ((getLogType() == null) ? 0 : getLogType().hashCode());
        result = prime * result + ((getStartDepth() == null) ? 0 : getStartDepth().hashCode());
        result = prime * result + ((getEndDepth() == null) ? 0 : getEndDepth().hashCode());
        result = prime * result + ((getThickness() == null) ? 0 : getThickness().hashCode());
        result = prime * result + ((getClayContent() == null) ? 0 : getClayContent().hashCode());
        result = prime * result + ((getPorosity() == null) ? 0 : getPorosity().hashCode());
        result = prime * result + ((getWaterSaturation() == null) ? 0 : getWaterSaturation().hashCode());
        result = prime * result + ((getPermeability() == null) ? 0 : getPermeability().hashCode());
        result = prime * result + ((getHydrocarbonSaturation() == null) ? 0 : getHydrocarbonSaturation().hashCode());
        result = prime * result + ((getStartVerticalDepth() == null) ? 0 : getStartVerticalDepth().hashCode());
        result = prime * result + ((getEndVerticalDepth() == null) ? 0 : getEndVerticalDepth().hashCode());
        result = prime * result + ((getVerticalThickness() == null) ? 0 : getVerticalThickness().hashCode());
        result = prime * result + ((getStartTvt() == null) ? 0 : getStartTvt().hashCode());
        result = prime * result + ((getEndTvt() == null) ? 0 : getEndTvt().hashCode());
        result = prime * result + ((getTvtThickness() == null) ? 0 : getTvtThickness().hashCode());
        result = prime * result + ((getGamma() == null) ? 0 : getGamma().hashCode());
        result = prime * result + ((getDeepResistivity() == null) ? 0 : getDeepResistivity().hashCode());
        result = prime * result + ((getApparentResistivity() == null) ? 0 : getApparentResistivity().hashCode());
        result = prime * result + ((getDensity() == null) ? 0 : getDensity().hashCode());
        result = prime * result + ((getNeutron() == null) ? 0 : getNeutron().hashCode());
        result = prime * result + ((getAcoustic() == null) ? 0 : getAcoustic().hashCode());
        result = prime * result + ((getTotalHydrocarbon() == null) ? 0 : getTotalHydrocarbon().hashCode());
        result = prime * result + ((getHydrocarbonThickness() == null) ? 0 : getHydrocarbonThickness().hashCode());
        result = prime * result + ((getOilLevel() == null) ? 0 : getOilLevel().hashCode());
        result = prime * result + ((getLithology() == null) ? 0 : getLithology().hashCode());
        result = prime * result + ((getConclusion() == null) ? 0 : getConclusion().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", explainId=").append(explainId);
        sb.append(", wellId=").append(wellId);
        sb.append(", logType=").append(logType);
        sb.append(", startDepth=").append(startDepth);
        sb.append(", endDepth=").append(endDepth);
        sb.append(", thickness=").append(thickness);
        sb.append(", clayContent=").append(clayContent);
        sb.append(", porosity=").append(porosity);
        sb.append(", waterSaturation=").append(waterSaturation);
        sb.append(", permeability=").append(permeability);
        sb.append(", hydrocarbonSaturation=").append(hydrocarbonSaturation);
        sb.append(", startVerticalDepth=").append(startVerticalDepth);
        sb.append(", endVerticalDepth=").append(endVerticalDepth);
        sb.append(", verticalThickness=").append(verticalThickness);
        sb.append(", startTvt=").append(startTvt);
        sb.append(", endTvt=").append(endTvt);
        sb.append(", tvtThickness=").append(tvtThickness);
        sb.append(", gamma=").append(gamma);
        sb.append(", deepResistivity=").append(deepResistivity);
        sb.append(", apparentResistivity=").append(apparentResistivity);
        sb.append(", density=").append(density);
        sb.append(", neutron=").append(neutron);
        sb.append(", acoustic=").append(acoustic);
        sb.append(", totalHydrocarbon=").append(totalHydrocarbon);
        sb.append(", hydrocarbonThickness=").append(hydrocarbonThickness);
        sb.append(", oilLevel=").append(oilLevel);
        sb.append(", lithology=").append(lithology);
        sb.append(", conclusion=").append(conclusion);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}