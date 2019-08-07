package org.gs.stream.bind;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

/**
 * 消费自己生产的消息
 */
public interface ConsumerSelfMessageBinder {

    String OUTPUT = "consumer-self-topic-output";
    String INPUT = "consumer-self-topic-input";

    @Output(OUTPUT)
    MessageChannel output();

    @Input(INPUT)
    SubscribableChannel input();

}