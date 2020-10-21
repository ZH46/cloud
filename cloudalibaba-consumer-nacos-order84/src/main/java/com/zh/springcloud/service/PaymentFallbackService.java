package com.zh.springcloud.service;

import com.zh.springcloud.entities.CommonResult;
import com.zh.springcloud.entities.Payment;
import org.springframework.stereotype.Component;

/**
 *
 * 服务降级兜底
 *
 * @author 卓少武
 * @date 2020/10/19
 */
@Component
public class PaymentFallbackService implements PaymentService {
    @Override
    public CommonResult<Payment> paymentSQL(Long id) {
        return new CommonResult<>(444, "fallback");
    }
}
