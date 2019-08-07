package org.gs.stream.controller;

import org.gs.stream.bind.ConsumerSelfMessageBinder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zpp
 * @date 2019/4/22 15:19
 */
@RestController
@EnableBinding({ConsumerSelfMessageBinder.class})
public class ConsumerSelfController {

    @Autowired
    private ConsumerSelfMessageBinder consumerSelfMessageBinder;

    @GetMapping("/sendMessage")
    public String messageWithMQ(@RequestParam String message) {
        consumerSelfMessageBinder.output().send(MessageBuilder.withPayload(message).build());
        return "ok";
    }
}
