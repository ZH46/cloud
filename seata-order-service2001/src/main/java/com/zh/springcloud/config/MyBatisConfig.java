package com.zh.springcloud.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author 卓少武
 * @date 2020/10/20
 */
@Configuration
@MapperScan("com.zh.springcloud.dao")
public class MyBatisConfig {
}
