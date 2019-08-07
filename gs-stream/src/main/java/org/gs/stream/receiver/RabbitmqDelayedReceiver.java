package org.gs.stream.receiver;

import lombok.extern.slf4j.Slf4j;
import org.gs.stream.bind.RabbitmqDelayedMessageBinder;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

/**
 * @author zpp
 * @date 2019/5/8 17:20
 */
@Slf4j
@EnableBinding(RabbitmqDelayedMessageBinder.class)
public class RabbitmqDelayedReceiver {

    @StreamListener(RabbitmqDelayedMessageBinder.INPUT)
    public void receive(String payload) {
        log.info("Received: " + payload);
    }

}
