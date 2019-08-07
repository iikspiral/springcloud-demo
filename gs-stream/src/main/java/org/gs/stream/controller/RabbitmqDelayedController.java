package org.gs.stream.controller;

import lombok.extern.slf4j.Slf4j;
import org.gs.stream.bind.RabbitmqDelayedMessageBinder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zpp
 * @date 2019/5/8 17:24
 */
@Slf4j
@RestController
public class RabbitmqDelayedController {

    @Autowired
    private RabbitmqDelayedMessageBinder rabbitmqDelayedMessageBinder;

    @GetMapping("/sendMsg")
    public String delayedMessage(@RequestParam String msg) {
        log.info("send delayed msg : " + msg);
        rabbitmqDelayedMessageBinder.output().send(MessageBuilder.withPayload(msg).setHeader("x-delay", 3000).build());
        return "success";
    }
}
