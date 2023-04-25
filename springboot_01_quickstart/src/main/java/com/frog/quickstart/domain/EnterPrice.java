package com.frog.quickstart.domain;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
@Component
@ConfigurationProperties(prefix = "enterprice")
@Data
public class EnterPrice {
    String name;
    int age;
    String tel;
    String[] subject;
}
