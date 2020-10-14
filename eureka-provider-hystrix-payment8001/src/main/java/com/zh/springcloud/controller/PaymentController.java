package com.zh.springcloud.controller;

import com.zh.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    /**
     * 正常访问
     * @param id
     * @return
     */
    @GetMapping("/hystrix/ok/{id}")
    public String Hystrix_OK(@PathVariable("id") Integer id){
        return paymentService.Hystrix_OK(id);
    }

    /**
     * 超时访问
     * @param id
     * @return
     */
    @GetMapping("/hystrix/timeout/{id}")
    public String Hystrix_timeout(@PathVariable("id") Integer id){
        return paymentService.Hystrix_timeout(id);
    }

    /**
     * 服务熔断
     * @param id
     * @return
     */
    @GetMapping("/circuit/{id}")
    public String paymentCircuitBreaker(@PathVariable("id") Integer id) {
        String result = paymentService.paymentCircuitBreaker(id);
        log.info("***result:" + result);
        return result;
    }

}
