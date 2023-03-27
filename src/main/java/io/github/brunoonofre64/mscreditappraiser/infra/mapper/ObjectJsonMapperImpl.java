package io.github.brunoonofre64.mscreditappraiser.infra.mapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.brunoonofre64.mscreditappraiser.domain.dto.cards.DataRequestedIssuanceCardDTO;
import io.github.brunoonofre64.mscreditappraiser.domain.enums.ErrorMessage;
import io.github.brunoonofre64.mscreditappraiser.domain.exception.BusinesRuleException;
import io.github.brunoonofre64.mscreditappraiser.domain.mapper.ObjectJsonMapper;
import org.springframework.stereotype.Component;

@Component
public class ObjectJsonMapperImpl implements ObjectJsonMapper {
    @Override
    public String mapToJson(DataRequestedIssuanceCardDTO dataDTO) throws JsonProcessingException {
        if (dataDTO == null) {
            throw new BusinesRuleException(ErrorMessage.BUSINES_RULE);
        }

        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(dataDTO);
    }
}
