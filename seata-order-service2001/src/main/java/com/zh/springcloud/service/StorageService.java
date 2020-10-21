package com.zh.springcloud.service;

import com.zh.springcloud.domain.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author 卓少武
 * @date 2020/10/20
 */
@FeignClient(value = "seata-storage-service")
public interface StorageService {
    /**
     * 减库存
     *
     * @param productId
     * @param count
     * @return
     */
    @PostMapping(value = "storage/decrease")
    CommonResult decrease(@RequestParam("productId") Long productId, @RequestParam("count") Integer count);
}
