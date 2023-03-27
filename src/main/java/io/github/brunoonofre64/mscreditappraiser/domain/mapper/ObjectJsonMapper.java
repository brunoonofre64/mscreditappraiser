package io.github.brunoonofre64.mscreditappraiser.domain.mapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.github.brunoonofre64.mscreditappraiser.domain.dto.cards.DataRequestedIssuanceCardDTO;

public interface ObjectJsonMapper {
    String mapToJson(DataRequestedIssuanceCardDTO dataDTO) throws JsonProcessingException;
}
