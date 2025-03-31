package com.proj.entity.logging;

import com.proj.entity.AbstractData;

/**
 * @description: TODO 
 * @author fw
 * @date 2025/3/30 下午10:54
 * @version 1.0
 */
public class LongitudinalWave extends AbstractData {
   LongitudinalWave(double depth, double value) {
       super(depth, value);
   }

   public String getType(){
       return "纵波";
   }
}