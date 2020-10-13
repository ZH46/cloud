package com.zh.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @author 卓少武
 * @date 2020/10/13
 */
public interface LoadBalanced {
    /**
     * 获取存活的服务实例列表
     *
     * @param serviceInstances
     * @return
     */
    ServiceInstance instances(List<ServiceInstance> serviceInstances);
}
