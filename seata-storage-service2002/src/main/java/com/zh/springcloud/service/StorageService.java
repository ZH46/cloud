package com.zh.springcloud.service;

/**
 * @author 卓少武
 * @date 2020/10/20
 */
public interface StorageService {
    /**
     * 减库存
     *
     * @param productId
     * @param count
     * @return
     */
    void decrease(Long productId, Integer count);
}
