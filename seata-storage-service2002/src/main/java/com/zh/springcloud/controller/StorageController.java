package com.zh.springcloud.controller;

import com.zh.springcloud.domain.CommonResult;
import com.zh.springcloud.service.StorageService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author 卓少武
 * @date 2020/10/20
 */
@RestController
public class StorageController {

    @Resource
    private StorageService storageService;

    /**
     * 减库存
     *
     * @param productId
     * @param count
     * @return
     */
    @PostMapping(value = "storage/decrease")
    public CommonResult decrease(@RequestParam("productId") Long productId, @RequestParam("count") Integer count) {
        storageService.decrease(productId, count);
        return new CommonResult(200, "扣减库存成功");
    }
}
