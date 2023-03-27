package io.github.brunoonofre64.mscreditappraiser.infra.mqueue;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.github.brunoonofre64.mscreditappraiser.domain.dto.cards.DataRequestedIssuanceCardDTO;
import io.github.brunoonofre64.mscreditappraiser.domain.enums.ErrorMessage;
import io.github.brunoonofre64.mscreditappraiser.domain.exception.BusinesRuleException;
import io.github.brunoonofre64.mscreditappraiser.domain.mapper.ObjectJsonMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RequestCardIssuancePublisher {

    private final RabbitTemplate rabbitTemplate;
    private final Queue issuanceCardsQueue;
    private final ObjectJsonMapper mapper;

    public void requestCard(DataRequestedIssuanceCardDTO data) throws JsonProcessingException {
        if (data == null) {
            throw new BusinesRuleException(ErrorMessage.BUSINES_RULE);
        }

        var json = mapper.mapToJson(data);
        rabbitTemplate.convertAndSend(issuanceCardsQueue.getName(), json);
    }
}
