package com.zh.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @author 卓少武
 * @date 2020/10/13
 */
@Component
public class PaymentFallbackService implements PaymentHystrixService {

    @Override
    public String Hystrix_OK(Integer id) {
        return "----PaymentFallbackService fall back-paymentInfo_OK,o(╥﹏╥)o";
    }

    @Override
    public String Hystrix_timeout(Integer id) {
        return "----PaymentFallbackService fall back-paymentInfo_TimeOut,o(╥﹏╥)o";
    }

}
