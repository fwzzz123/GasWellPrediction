package com.proj.utils.exception;

import lombok.Data;

/**
 * @description: TODO 
 * @author fw
 * @date 2025/4/2 上午10:52
 * @version 1.0
 */
@Data
public class ErrorResponse {
    private String code;
    private String message;

    public ErrorResponse(String code, String message) {
        this.code = code;
        this.message = message;
    }
}