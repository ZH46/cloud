package com.zh.springcloud.service;

/**
 * @author 卓少武
 * @date 2020/10/13
 */
public interface PaymentService {

    //-----服务降级

    public String Hystrix_OK(Integer id);

    public String Hystrix_timeout(Integer id);

    //-----服务熔断

    public String paymentCircuitBreaker(Integer id);
}
