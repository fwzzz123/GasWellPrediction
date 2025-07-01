package com.proj.entity.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName Relative_Permeability
 */
@TableName(value ="Relative_Permeability")
@Data
public class RelativePermeabilityPO implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Object permeabilityId;

    /**
     * 
     */
    private String wellId;

    /**
     * 
     */
    private Double sw;

    /**
     * 
     */
    private Double krg;

    /**
     * 
     */
    private Double krw;

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
        RelativePermeabilityPO other = (RelativePermeabilityPO) that;
        return (this.getPermeabilityId() == null ? other.getPermeabilityId() == null : this.getPermeabilityId().equals(other.getPermeabilityId()))
            && (this.getWellId() == null ? other.getWellId() == null : this.getWellId().equals(other.getWellId()))
            && (this.getSw() == null ? other.getSw() == null : this.getSw().equals(other.getSw()))
            && (this.getKrg() == null ? other.getKrg() == null : this.getKrg().equals(other.getKrg()))
            && (this.getKrw() == null ? other.getKrw() == null : this.getKrw().equals(other.getKrw()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getPermeabilityId() == null) ? 0 : getPermeabilityId().hashCode());
        result = prime * result + ((getWellId() == null) ? 0 : getWellId().hashCode());
        result = prime * result + ((getSw() == null) ? 0 : getSw().hashCode());
        result = prime * result + ((getKrg() == null) ? 0 : getKrg().hashCode());
        result = prime * result + ((getKrw() == null) ? 0 : getKrw().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", permeabilityId=").append(permeabilityId);
        sb.append(", wellId=").append(wellId);
        sb.append(", sw=").append(sw);
        sb.append(", krg=").append(krg);
        sb.append(", krw=").append(krw);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}