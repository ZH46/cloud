package com.zh.springcloud.service;

import com.zh.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @author 卓少武
 * @date 2020/10/10
 */
public interface PaymentService {

    public int save(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);

}
