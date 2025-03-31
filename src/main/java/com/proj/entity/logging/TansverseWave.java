package com.proj.entity.logging;

import com.proj.entity.AbstractData;

/**
 * @description: TODO 
 * @author fw
 * @date 2025/3/30 下午11:02
 * @version 1.0
 */
public class TansverseWave extends AbstractData {
   TansverseWave(double depth, double value) {
       super(depth, value);
   }
   public String getType(){
       return "横波";
   }
}