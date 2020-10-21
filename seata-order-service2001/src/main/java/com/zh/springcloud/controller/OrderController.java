package com.zh.springcloud.controller;

import com.zh.springcloud.domain.CommonResult;
import com.zh.springcloud.domain.Order;
import com.zh.springcloud.service.OrderService;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author 卓少武
 * @date 2020/10/20
 */
@RestController
public class OrderController {
    @Resource
    private OrderService orderService;

    /**
     * 创建订单
     *
     * @param order
     * @return
     */
    @GetMapping("order/create")
    @GlobalTransactional(name = "zh_tx_group",rollbackFor = Exception.class)
    public CommonResult create(Order order) {

        orderService.create(order);
        return new CommonResult(200, "订单创建成功");
    }
}
