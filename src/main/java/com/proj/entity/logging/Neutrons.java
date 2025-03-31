package com.proj.entity.logging;

import com.proj.entity.AbstractData;

/**
 * @description: TODO 
 * @author fw
 * @date 2025/3/30 下午10:58
 * @version 1.0
 */
public class Neutrons extends AbstractData {
   Neutrons(double depth, double valve) {
       super(depth, valve);
   }

   public String getType(){
       return "中子";
   }
}