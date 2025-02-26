package com.proj.domain.po;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("wellLas")
public class WellLAS {
    @TableField("id")
    private long id;

    private String name;

    private byte[] lasFile;
}
