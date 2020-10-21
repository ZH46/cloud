package com.zh.springcloud.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.zh.springcloud.entities.CommonResult;

/**
 * @author 卓少武
 * @date 2020/10/19
 */
public class CustomerBlockHandler {

    public static CommonResult handlerException(BlockException exception) {
        return new CommonResult(444, "客户自定义，global handlerException---1");
    }

    public static CommonResult handlerException2(BlockException exception) {
        return new CommonResult(444, "客户自定义，global handlerException---2");
    }
}
