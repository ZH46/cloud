package com.zh.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author 卓少武
 * @date 2020/10/12
 */
@SpringBootApplication
@EnableDiscoveryClient
public class OrderConsulApplication80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderConsulApplication80.class,args);
    }
}
