package com.proj.domain.po;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("user")
public class User {
    @TableId("id")
    private Integer id;
    private String username;
    private Integer age;
    private String email;

}
