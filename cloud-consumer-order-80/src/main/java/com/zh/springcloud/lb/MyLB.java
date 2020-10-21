package com.zh.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 自定义 Ribbon 手写轮询算法
 *
 * @author 卓少武
 * @date 2020/10/13
 */
@Component
public class MyLB implements ILoadBalanced {

    private final AtomicInteger atomicInteger = new AtomicInteger(0);

    public final int getAndIncrement(){
        int current;
        int next;
        do{
            current = this.atomicInteger.get();
            next = current > 2147483647 ? 0 : current + 1;
            System.out.println("****第几次访问,次数next:" + next);
        }while(!this.atomicInteger.compareAndSet(current,next));

        return next;
    }

    /**
     * 负载均衡算法:rest接口第几次请求数%服务器集群总数量=实际调用服务器位置下标,每次服务重启动后rest接口计数从1开始.
     * @param serviceInstances
     * @return
     */
    @Override
    public ServiceInstance instances(List<ServiceInstance> serviceInstances) {

        int index = getAndIncrement() % serviceInstances.size();

        return serviceInstances.get(index);
    }

}
