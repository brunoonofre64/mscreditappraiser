package io.github.brunoonofre64.mscreditappraiser.infra.mapper;

import io.github.brunoonofre64.mscreditappraiser.domain.dto.cards.CardsApprovedDTO;
import io.github.brunoonofre64.mscreditappraiser.domain.dto.cards.CardsCustomerOutputDTO;
import io.github.brunoonofre64.mscreditappraiser.domain.dto.cards.CardsOutputDTO;
import io.github.brunoonofre64.mscreditappraiser.domain.dto.customer.CustomerCardsDTO;
import io.github.brunoonofre64.mscreditappraiser.domain.dto.customer.CustomerDataDTO;
import io.github.brunoonofre64.mscreditappraiser.domain.dto.customer.CustomerOutputDTO;
import io.github.brunoonofre64.mscreditappraiser.domain.enums.ErrorMessage;
import io.github.brunoonofre64.mscreditappraiser.domain.exception.BusinesRuleException;
import io.github.brunoonofre64.mscreditappraiser.domain.mapper.CreditAppraiserMapper;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CreditAppraiserMapperImpl implements CreditAppraiserMapper {
    @Override
    public CustomerDataDTO mapToCustomerData(CustomerOutputDTO customerOutputDTO) {
        if (customerOutputDTO == null) {
            throw new BusinesRuleException(ErrorMessage.BUSINES_RULE);
        }

        return CustomerDataDTO
                .builder()
                .name(customerOutputDTO.getName())
                .uuid(customerOutputDTO.getUuid())
                .build();
    }

    @Override
    public List<CustomerCardsDTO> mapToListCardsCustomer(List<CardsCustomerOutputDTO> cardsCustomer) {
        if (CollectionUtils.isEmpty(cardsCustomer)) {
            return Collections.emptyList();
        }

        return cardsCustomer
                .stream()
                .map(cards ->

                    CustomerCardsDTO
                            .builder()
                            .name(cards.getName())
                            .cardFlag(cards.getCardFlag())
                            .cardLimitApproved(cards.getCardLimit())
                            .build()
                ).collect(Collectors.toList());
    }
}
