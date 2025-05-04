package com.proj.entity.dto;

import lombok.Data;

/**
 * @description: TODO 
 * @author fw
 * @date 2025/5/3 下午10:02
 * @version 1.0
 */

@Data
public class FieldCommentDTO {
    private String field;
    private String comment;

    public FieldCommentDTO(String field, String comment) {
        this.field = field;
        this.comment = comment;
    }



    // Getter 和 Setter 可由 Lombok 管理
}