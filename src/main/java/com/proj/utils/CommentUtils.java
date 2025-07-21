package com.proj.utils;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @description: TODO 
 * @author fw
 * @date 2025/4/30 下午4:56
 * @version 1.0
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface CommentUtils {
   String value()  default "";
}