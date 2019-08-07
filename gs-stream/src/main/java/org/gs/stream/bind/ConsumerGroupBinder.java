package org.gs.stream.bind;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface ConsumerGroupBinder {

    /**
     *  绑定到RabbitMQ的同名Exchange或Kafaka的同名Topic
     */
    String NAME = "consumer-group-topic-input";

    @Input(NAME)
    SubscribableChannel input();

}