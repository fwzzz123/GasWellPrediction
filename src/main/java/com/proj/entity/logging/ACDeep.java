package com.proj.entity.logging;

import com.proj.entity.AbstractData;

/**
 * @description: TODO 
 * @author fw
 * @date 2025/3/30 下午10:32
 * @version 1.0
 */

public class ACDeep extends AbstractData {

    public ACDeep(double depth, double value) {
        super(depth, value);
    }

    @Override
    public String getType() {
        return "电阻率";
    }
}