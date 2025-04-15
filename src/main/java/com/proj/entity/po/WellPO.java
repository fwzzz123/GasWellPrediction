package com.proj.entity.po;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.security.Timestamp;

/**
 * @description: TODO
 * @author fw
 * @date 2025/3/31 下午7:56
 * @version 1.0
 */

@Data
@TableName("Well")
public class WellPO {
//
    private Long id;

    private String wellName;

    private String wellType;

    private Double wellCapacity;

    private String gasReservoir;

    private Timestamp createdAt;

    private Timestamp updatedAt;

}