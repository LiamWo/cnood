package com.cnood.admin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author CnoodAdminApplication
 * @Date 2023/6/15
 * @Description
 */

@SpringBootApplication
@MapperScan("com.cnood.admin.mapper")
public class CnoodAdminApplication {
    public static void main(String[] args) {
        SpringApplication.run(CnoodAdminApplication.class, args);
    }
}
