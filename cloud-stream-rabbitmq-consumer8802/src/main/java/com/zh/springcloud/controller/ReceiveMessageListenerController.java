package com.zh.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * @author 卓少武
 * @date 2020/10/15
 */
@Component //这里 controller 是一个组件
@EnableBinding(Sink.class)
public class ReceiveMessageListenerController {

    @Value("${server.port}")
    private String serverPort;

    @StreamListener(Sink.INPUT)  //具体监听的通道名称
    public void receive(Message<String> message){
        System.out.println("消费者1号，----->接收到的消息："+ message.getPayload() +"\t port:" + serverPort);
    }

}
