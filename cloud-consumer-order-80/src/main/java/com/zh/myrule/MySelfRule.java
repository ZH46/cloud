package com.zh.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 定义 Ribbon 负载均衡路由规则类
 *
 * @author 卓少武
 * @date 2020/10/13
 */
@Configuration
public class MySelfRule {

    @Bean
    public IRule myRule() {
        // 定义为随机
//        return new RandomRule();

        //定义为轮询
        return new RoundRobinRule();
    }


}
