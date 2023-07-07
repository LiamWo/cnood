package com.cnood.admin.aop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

/**
 * @author SpringConfig
 * @Date 2023/6/29
 * @Description
 */
@Configuration
@ComponentScan(basePackages = "com.cnood.admin.controller")
@EnableAspectJAutoProxy
public class SpringConfig {

}
