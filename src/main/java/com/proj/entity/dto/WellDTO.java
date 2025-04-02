package com.proj.entity.dto;

import lombok.Data;

/**
 * @description: TODO 
 * @author fw
 * @date 2025/3/31 下午8:07
 * @version 1.0
 */
@Data
public class WellDTO {
    private String wellName;
    private String wellType;
    private Double wellCapacity;
    private String gasReservoir;
}