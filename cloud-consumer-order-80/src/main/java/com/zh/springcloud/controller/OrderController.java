package com.zh.springcloud.controller;

import com.zh.springcloud.entities.CommonResult;
import com.zh.springcloud.entities.Payment;
import com.zh.springcloud.lb.LoadBalanced;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author 卓少武
 * @date 2020/10/11
 */
@RestController
@RequestMapping("/order")
@Slf4j
public class OrderController {

    //    private final String ORDER_URL = "http://localhost:8001";
    private final String ORDER_URL = "http://CLOUD-PAYMENT-SERVICE";

    @Autowired
    private LoadBalanced loadBalanced;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/payment/create")
    public CommonResult<Payment> create(Payment payment) {
        return restTemplate.postForObject(ORDER_URL + "/payment/save", payment, CommonResult.class);
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id) {
        return restTemplate.getForObject(ORDER_URL + "/payment/get/" + id, CommonResult.class);
    }

    @GetMapping("/payment/getForEntity/{id}")
    public CommonResult<Payment> getPayment2(@PathVariable("id") Long id) {
        ResponseEntity<CommonResult> entity = restTemplate.getForEntity(ORDER_URL + "/payment/get/" + id, CommonResult.class);

        if(entity.getStatusCode().is2xxSuccessful()){
            return entity.getBody();
        }else {
            return new CommonResult<>(444,"操作失败");
        }

    }

    @GetMapping("/payment/lb")
    public String getLB(){
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");

        if(instances == null || instances.size() <= 0){
            return null;
        }

        ServiceInstance instance = loadBalanced.instances(instances);

        return restTemplate.getForObject(instance.getUri()+"/payment/lb",String.class);
    }

}
