package com.zh.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author 卓少武
 * @date 2020/10/11
 */
@Configuration
public class ApplicationContextConfig {

    @Bean
    @LoadBalanced //负载均衡机制（使用自定义的算法时关闭）
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

}
