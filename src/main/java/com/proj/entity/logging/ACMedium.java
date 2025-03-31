package com.proj.entity.logging;

import com.proj.entity.AbstractData;

/**
 * @description: TODO 
 * @author fw
 * @date 2025/3/31 上午11:20
 * @version 1.0
 */
public class ACMedium extends AbstractData {
   ACMedium(double depth, double value){
       super(depth, value);
   }

   public String getType(){
       return "中电阻率";
   }
}