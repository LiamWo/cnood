package com.example.cnoodstarter.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author ReadProperties
 * @Date 2023/6/13
 * @Description
 * 配置属性类，封装配置文件中配置的参数信息
 */
@ConfigurationProperties(prefix = "hello")
@Data
public class ReadProperties {
    private String name;
    private String address;
}
