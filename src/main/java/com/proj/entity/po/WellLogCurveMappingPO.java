package com.proj.entity.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @description: TODO 
 * @author fw
 * @date 2025/4/9 上午10:50
 * @version 1.0
 */

@Data
@TableName("well_log_curve_mapping")
public class WellLogCurveMappingPO implements Serializable {
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    @TableField("well_log_id")
    private String wellLogId; // 修改: 将 Long 类型改为 String 类型
    @TableField("las_curve_name")
    private String lasCurveName;
    @TableField("standard_field_name")
    private String standardFieldName;
    @TableField("create_time")
    private LocalDateTime createTime;
    @TableField("update_time")
    private LocalDateTime updateTime;
}