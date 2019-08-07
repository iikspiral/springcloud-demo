package org.gs.stream.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * 消费组
 *
 * 当我们指定了某个绑定所指向的消费组之后，往当前主题发送的消息在每个订阅消费组中，只会有一个订阅者接收和消费，从而实现了对消息的负载均衡。只所以之前会出现重复消费的问题，
 * 是由于默认情况下，任何订阅都会产生一个匿名消费组，所以每个订阅实例都会有自己的消费组，从而当有消息发送的时候，就形成了广播的模式。
 * @author zpp
 * @date 2019/4/22 14:29
 */
@RestController
@EnableBinding(value = {ConsumerGroupController.ConsumerGroupBinder.class})
public class ConsumerGroupController {

    @Autowired
    private ConsumerGroupBinder consumerGroupBinder;

    public interface ConsumerGroupBinder {

        String NAME = "consumer-group-topic-output";

        @Output(NAME)
        MessageChannel output();

    }

    @GetMapping("/consumer-group/{msg}")
    public String consumerGroup(@PathVariable String msg){
        consumerGroupBinder.output().send(MessageBuilder.withPayload(msg).build());
        return "success";
    }

}
