package com.proj.entity.logging;

import com.proj.entity.AbstractData;

/**
 * @description: 伽马值
 * @author fw
 * @date 2025/3/30 下午10:37
 * @version 1.0
 */
public class GammaRay extends AbstractData {

    public GammaRay(double depth, double value){
        super(depth, value);
    }

    @Override
    public String getType() {
        return "伽马";
    }
}