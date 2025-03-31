package com.proj.entity.logging;

import com.proj.entity.AbstractData;

/**
 * @description: TODO 
 * @author fw
 * @date 2025/3/31 上午11:22
 * @version 1.0
 */
public class SP extends AbstractData {
   SP(double depth, double value){
       super(depth, value);
   }

   public String getType(){
       return "电位";
   }
}