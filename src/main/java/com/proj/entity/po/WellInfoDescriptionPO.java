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
 * @TableName Well_Info_Description
 */
@TableName(value ="Well_Info_Description")
@Data
public class WellInfoDescriptionPO implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Object descriptionId;

    /**
     * 
     */
    private String wellId;

    /**
     * 
     */
    private BigDecimal dev;

    /**
     * 
     */
    private BigDecimal azim;

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
        WellInfoDescriptionPO other = (WellInfoDescriptionPO) that;
        return (this.getDescriptionId() == null ? other.getDescriptionId() == null : this.getDescriptionId().equals(other.getDescriptionId()))
            && (this.getWellId() == null ? other.getWellId() == null : this.getWellId().equals(other.getWellId()))
            && (this.getDev() == null ? other.getDev() == null : this.getDev().equals(other.getDev()))
            && (this.getAzim() == null ? other.getAzim() == null : this.getAzim().equals(other.getAzim()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getDescriptionId() == null) ? 0 : getDescriptionId().hashCode());
        result = prime * result + ((getWellId() == null) ? 0 : getWellId().hashCode());
        result = prime * result + ((getDev() == null) ? 0 : getDev().hashCode());
        result = prime * result + ((getAzim() == null) ? 0 : getAzim().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", descriptionId=").append(descriptionId);
        sb.append(", wellId=").append(wellId);
        sb.append(", dev=").append(dev);
        sb.append(", azim=").append(azim);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}