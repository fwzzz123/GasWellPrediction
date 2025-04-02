package com.proj.utils.exception;

/**
 * @description: TODO 
 * @author fw
 * @date 2025/4/2 上午10:52
 * @version 1.0
 */
public class DuplicateFileNameException extends RuntimeException {
    public DuplicateFileNameException(String message) {
        super(message);
    }
}