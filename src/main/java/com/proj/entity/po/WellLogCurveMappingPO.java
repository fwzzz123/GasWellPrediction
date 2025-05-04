package com.proj.entity.po;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @description: TODO 
 * @author fw
 * @date 2025/4/9 上午10:50
 * @version 1.0
 */

@Data
@TableName("well_log_curve_mapping")
public class WellLogCurveMappingPO {
    private Long id;
    private String wellLogId; // 修改: 将 Long 类型改为 String 类型
    private String lasCurveName;
    private String standardFieldName;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}