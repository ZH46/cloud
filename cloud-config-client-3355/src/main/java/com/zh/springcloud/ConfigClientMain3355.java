package com.zh.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author 卓少武
 * @date 2020/10/15
 */
@SpringBootApplication
//@EnableEurekaClient //不加也可以注册到 Eureka 中，只要有依赖jar即可
public class ConfigClientMain3355 {
    public static void main(String[] args) {
        SpringApplication.run(ConfigClientMain3355.class,args);
    }
}
