package com.zh.springcloud.controller;

import com.zh.springcloud.entities.CommonResult;
import com.zh.springcloud.entities.Payment;
import com.zh.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 卓少武
 * @date 2020/10/10
 */
@RestController
@RequestMapping("/payment")
@Slf4j
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Value("${server.port}")
    private  String serverPort;

    @PostMapping(value = "/save")
    public CommonResult save(@RequestBody Payment payment){

        int i = paymentService.save(payment);

        if(i > 0){
            return new CommonResult(200,"插入数据成功,serverPort:"+serverPort,i);
        }else {
            return new CommonResult(444,"插入数据失败");
        }
    }

    @GetMapping(value = "/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){

        Payment payment = paymentService.getPaymentById(id);

        if(payment != null){
            return new CommonResult(200,"查询成功,serverPort:"+serverPort,payment);
        }else {
            return new CommonResult(444,"无记录");
        }
    }

    @GetMapping("/discovery")
    public Object getDiscovery(){
        List<String> services = discoveryClient.getServices();
        for (String element : services){
            log.info("element:"+element);
        }

        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances){
            log.info(instance.getServiceId()+"\t"+instance.getHost()+"\t"+instance.getPort()+"\t"+instance.getUri());
        }

        return this.discoveryClient;
    }

    @GetMapping(value = "/lb")
    public String getPaymentLB() {
        return serverPort;
    }

}
