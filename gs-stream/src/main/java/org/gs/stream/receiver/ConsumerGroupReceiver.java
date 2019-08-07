package org.gs.stream.receiver;

import org.gs.stream.bind.ConsumerGroupBinder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

@EnableBinding(ConsumerGroupBinder.class)
public class ConsumerGroupReceiver {

    private static Logger logger = LoggerFactory.getLogger(ConsumerGroupReceiver.class);

    @StreamListener(ConsumerGroupBinder.NAME)
    public void receive(String payload) {
        logger.info("Received: " + payload);
    }

}