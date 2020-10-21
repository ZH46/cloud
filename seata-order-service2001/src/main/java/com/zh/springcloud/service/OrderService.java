package com.zh.springcloud.service;

import com.zh.springcloud.domain.Order;

/**
 * @author 卓少武
 * @date 2020/10/20
 */
public interface OrderService {
    /**
     * 创建订单
     * @param order
     */
    void create(Order order);
}
