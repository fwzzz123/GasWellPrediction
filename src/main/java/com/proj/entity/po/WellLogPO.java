package com.proj.entity.po;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @description: 实体类对应 well_log 表
 * @author fw
 * @date 2025/4/26 下午8:01
 * @version 1.0
 */
@Data
@TableName("well_log")
public class WellLogPO {
    private String id;
    private String wellId;
    private Double startDepth;
    private Double endDepth;
    private Double step;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;


}