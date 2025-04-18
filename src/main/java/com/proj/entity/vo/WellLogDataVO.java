package com.proj.entity.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 *
 * @TableName well_log_data
 */
@TableName(value ="well_log_data")
@Data
public class WellLogDataVO implements Serializable {
    /**
     *
     */
    @TableId(type = IdType.AUTO)
    private Object id;

    /**
     *
     */
    private String wellLogId;

    /**
     *
     */
    private Double depth;

    /**
     *
     */
    private Double gamma;

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
    private Double vp;

    /**
     *
     */
    private Double vs;

    /**
     *
     */
    private Double deepResistance;

    /**
     *
     */
    private Double mediumResistance;

    /**
     *
     */
    private Double shallowResistance;

    /**
     *
     */
    private Double sp;

    /**
     *
     */
    private Double caliper;

    /**
     *
     */
    private Double peIndex;

    /**
     *
     */
    private Double porosity;

    /**
     *
     */
    private Double permeability;

    /**
     *
     */
    private Double waterSaturation;

    /**
     *
     */
    private Double shaleContent;

    /**
     *
     */
    private Date createTime;

    /**
     *
     */
    private Date updateTime;

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
        WellLogDataVO other = (WellLogDataVO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
                && (this.getWellLogId() == null ? other.getWellLogId() == null : this.getWellLogId().equals(other.getWellLogId()))
                && (this.getDepth() == null ? other.getDepth() == null : this.getDepth().equals(other.getDepth()))
                && (this.getGamma() == null ? other.getGamma() == null : this.getGamma().equals(other.getGamma()))
                && (this.getDensity() == null ? other.getDensity() == null : this.getDensity().equals(other.getDensity()))
                && (this.getNeutron() == null ? other.getNeutron() == null : this.getNeutron().equals(other.getNeutron()))
                && (this.getVp() == null ? other.getVp() == null : this.getVp().equals(other.getVp()))
                && (this.getVs() == null ? other.getVs() == null : this.getVs().equals(other.getVs()))
                && (this.getDeepResistance() == null ? other.getDeepResistance() == null : this.getDeepResistance().equals(other.getDeepResistance()))
                && (this.getMediumResistance() == null ? other.getMediumResistance() == null : this.getMediumResistance().equals(other.getMediumResistance()))
                && (this.getShallowResistance() == null ? other.getShallowResistance() == null : this.getShallowResistance().equals(other.getShallowResistance()))
                && (this.getSp() == null ? other.getSp() == null : this.getSp().equals(other.getSp()))
                && (this.getCaliper() == null ? other.getCaliper() == null : this.getCaliper().equals(other.getCaliper()))
                && (this.getPeIndex() == null ? other.getPeIndex() == null : this.getPeIndex().equals(other.getPeIndex()))
                && (this.getPorosity() == null ? other.getPorosity() == null : this.getPorosity().equals(other.getPorosity()))
                && (this.getPermeability() == null ? other.getPermeability() == null : this.getPermeability().equals(other.getPermeability()))
                && (this.getWaterSaturation() == null ? other.getWaterSaturation() == null : this.getWaterSaturation().equals(other.getWaterSaturation()))
                && (this.getShaleContent() == null ? other.getShaleContent() == null : this.getShaleContent().equals(other.getShaleContent()))
                && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
                && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getWellLogId() == null) ? 0 : getWellLogId().hashCode());
        result = prime * result + ((getDepth() == null) ? 0 : getDepth().hashCode());
        result = prime * result + ((getGamma() == null) ? 0 : getGamma().hashCode());
        result = prime * result + ((getDensity() == null) ? 0 : getDensity().hashCode());
        result = prime * result + ((getNeutron() == null) ? 0 : getNeutron().hashCode());
        result = prime * result + ((getVp() == null) ? 0 : getVp().hashCode());
        result = prime * result + ((getVs() == null) ? 0 : getVs().hashCode());
        result = prime * result + ((getDeepResistance() == null) ? 0 : getDeepResistance().hashCode());
        result = prime * result + ((getMediumResistance() == null) ? 0 : getMediumResistance().hashCode());
        result = prime * result + ((getShallowResistance() == null) ? 0 : getShallowResistance().hashCode());
        result = prime * result + ((getSp() == null) ? 0 : getSp().hashCode());
        result = prime * result + ((getCaliper() == null) ? 0 : getCaliper().hashCode());
        result = prime * result + ((getPeIndex() == null) ? 0 : getPeIndex().hashCode());
        result = prime * result + ((getPorosity() == null) ? 0 : getPorosity().hashCode());
        result = prime * result + ((getPermeability() == null) ? 0 : getPermeability().hashCode());
        result = prime * result + ((getWaterSaturation() == null) ? 0 : getWaterSaturation().hashCode());
        result = prime * result + ((getShaleContent() == null) ? 0 : getShaleContent().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", wellLogId=").append(wellLogId);
        sb.append(", depth=").append(depth);
        sb.append(", gamma=").append(gamma);
        sb.append(", density=").append(density);
        sb.append(", neutron=").append(neutron);
        sb.append(", vp=").append(vp);
        sb.append(", vs=").append(vs);
        sb.append(", deepResistance=").append(deepResistance);
        sb.append(", mediumResistance=").append(mediumResistance);
        sb.append(", shallowResistance=").append(shallowResistance);
        sb.append(", sp=").append(sp);
        sb.append(", caliper=").append(caliper);
        sb.append(", peIndex=").append(peIndex);
        sb.append(", porosity=").append(porosity);
        sb.append(", permeability=").append(permeability);
        sb.append(", waterSaturation=").append(waterSaturation);
        sb.append(", shaleContent=").append(shaleContent);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}