package com.zh.springcloud.service;

/**
 * 消息生产者
 * @author 卓少武
 * @date 2020/10/15
 */
public interface IMessageProvider {
    /**
     * 消息发送
     * @return
     */
    String send();
}
