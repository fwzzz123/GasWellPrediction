package com.proj.entity.logging;

import com.proj.entity.AbstractData;

/**
 * @description: TODO 
 * @author fw
 * @date 2025/3/31 上午11:19
 * @version 1.0
 */
public class ACShallow extends AbstractData {
   ACShallow(double depth,double value){
       super(depth,value);
   }

   public String getType(){
       return "浅电阻率";
   }

}