package com.mybatisplus.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("user2")
public class User {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String name;
    private String password;
    private Integer age;
    private String tel;
    @TableLogic(value = "0",delval = "1")
    private Integer deleted;
    @Version
    private Integer version;
}
