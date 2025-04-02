package com.proj.utils.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @description: TODO 
 * @author fw
 * @date 2025/4/2 上午10:51
 * @version 1.0
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DuplicateFileNameException.class)
    public ResponseEntity<ErrorResponse> handleDuplicateFileName(DuplicateFileNameException ex) {
        ErrorResponse response = new ErrorResponse(
                "CONFLICT",
                ex.getMessage()
        );
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    // 可以添加其他异常处理...
}