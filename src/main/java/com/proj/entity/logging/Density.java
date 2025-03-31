package com.proj.entity.logging;

import com.proj.entity.AbstractData;

/**
 * @description: TODO 
 * @author fw
 * @date 2025/3/30 下午10:50
 * @version 1.0
 */
public class Density extends AbstractData {
   public Density(double depth, double value) {
       super(depth, value);
   }

    @Override
    public String getType() {
        return "密度";
    }

}