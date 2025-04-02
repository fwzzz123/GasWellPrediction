package com.proj.entity.po;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @description: 存储和操作java的二进制文件
 * @author fw
 * @date 2025/3/30 下午3:20
 * @version 1.0
 */
@Data
@TableName("wellLas")
public class WellLasPO {
    @TableField("id")
    private long id;

    private String name;

    private byte[] lasFile;
}
