package com.proj.entity.vo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.proj.entity.po.WellPO;
import lombok.Data;

import java.util.List;

/**
 * @description: 这个实体记录前端经用户挑选后的测井数据，管理起止深度
 * @author fw
 * @date 2025/4/1 下午12:33
 * @version 1.0
 */

@Data
@TableName("well_log")
public class WellLogVO {
    private Long id;

    private Long wellId;

    private String wellName; // 井名

    private Double startDepth; // 起始深度

    private Double endDepth; // 终止深度

    private Double stepSize; // 步长

    private List<WellLogDataVO> logDataList;

    public WellLogVO() {}

    public WellLogVO(String wellName, Double startDepth, Double endDepth, Double stepSize, WellPO wellPO) {
        this.wellId = wellPO.getId();
        this.wellName = wellName;
        this.startDepth = startDepth;
        this.endDepth = endDepth;
        this.stepSize = stepSize;
    }

    // Getters and Setters
}