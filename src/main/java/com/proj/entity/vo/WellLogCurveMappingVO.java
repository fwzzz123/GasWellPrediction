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
 * @TableName well_log_curve_mapping
 */
@TableName(value ="well_log_curve_mapping")
@Data
public class WellLogCurveMappingVO implements Serializable {
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
    private String lasCurveName;

    /**
     * 
     */
    private String standardFieldName;

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
        WellLogCurveMappingVO other = (WellLogCurveMappingVO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getWellLogId() == null ? other.getWellLogId() == null : this.getWellLogId().equals(other.getWellLogId()))
            && (this.getLasCurveName() == null ? other.getLasCurveName() == null : this.getLasCurveName().equals(other.getLasCurveName()))
            && (this.getStandardFieldName() == null ? other.getStandardFieldName() == null : this.getStandardFieldName().equals(other.getStandardFieldName()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getWellLogId() == null) ? 0 : getWellLogId().hashCode());
        result = prime * result + ((getLasCurveName() == null) ? 0 : getLasCurveName().hashCode());
        result = prime * result + ((getStandardFieldName() == null) ? 0 : getStandardFieldName().hashCode());
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
        sb.append(", lasCurveName=").append(lasCurveName);
        sb.append(", standardFieldName=").append(standardFieldName);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}