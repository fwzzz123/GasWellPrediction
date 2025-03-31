package com.proj.entity.logging;

import com.proj.entity.AbstractData;

/**
 * @description: TODO 
 * @author fw
 * @date 2025/3/31 上午11:29
 * @version 1.0
 */
public class CAL extends AbstractData {
   CAL(double depth, double value){
       super(depth, value);
   }

    @Override
    public String getType() {
        return "井径";
    }

}