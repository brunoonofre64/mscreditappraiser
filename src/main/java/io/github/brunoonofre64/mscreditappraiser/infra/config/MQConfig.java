package io.github.brunoonofre64.mscreditappraiser.infra.config;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MQConfig {

    @Value("${mq.queues.issuance-cards}")
    private String issuanceCards;

    public Queue issuanceCardsQueue() {
        return new Queue(issuanceCards,true);
    }
}
