package org.gs.stream.receiver;

import org.gs.stream.bind.ConsumerSelfMessageBinder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

@EnableBinding(ConsumerSelfMessageBinder.class)
public class ConsumerSelfReceiver {

    private static Logger logger = LoggerFactory.getLogger(ConsumerSelfReceiver.class);

    @StreamListener(ConsumerSelfMessageBinder.INPUT)
    public void receive(String payload) {
        logger.info("Received: " + payload);
        throw new RuntimeException("Message consumer failed!");
    }

}