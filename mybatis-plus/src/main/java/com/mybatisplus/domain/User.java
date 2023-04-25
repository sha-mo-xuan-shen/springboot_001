package com.mybatisplus.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("user2")
public class User {
    private int id;
    private String name;
    private String password;
    private int age;
    private String tel;
}
