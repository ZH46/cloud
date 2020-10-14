package com.zh.springcloud.controller;

import com.zh.springcloud.entities.CommonResult;
import com.zh.springcloud.service.OrderFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 卓少武
 * @date 2020/10/13
 */
@RestController
@Slf4j
@RequestMapping("order")
public class OrderFeignController {

    @Autowired
    private OrderFeignService orderFeignService;

    @GetMapping("/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        return orderFeignService.getPaymentById(id);
    }

    @GetMapping("/payment/feign/timeout")
    public String getPaymentTimeout(){
        return orderFeignService.getPaymentTimeOut();
    }

}
