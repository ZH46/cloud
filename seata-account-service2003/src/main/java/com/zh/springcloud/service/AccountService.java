package com.zh.springcloud.service;

import java.math.BigDecimal;

/**
 * @author 卓少武
 * @date 2020/10/20
 */
public interface AccountService {

    /**
     * 减库存
     *
     * @param userId 用户id
     * @param money  金额
     * @return
     */
    void decrease(Long userId, BigDecimal money);

}
