package io.github.brunoonofre64.mscreditappraiser.infra.utils;

import io.github.brunoonofre64.mscreditappraiser.domain.dto.cards.CardsApprovedDTO;
import io.github.brunoonofre64.mscreditappraiser.domain.dto.cards.CardsOutputDTO;
import io.github.brunoonofre64.mscreditappraiser.domain.dto.customer.CustomerOutputDTO;
import io.github.brunoonofre64.mscreditappraiser.domain.dto.evaluation.DataForEvaluationDTO;
import io.github.brunoonofre64.mscreditappraiser.domain.enums.ErrorMessage;
import io.github.brunoonofre64.mscreditappraiser.domain.exception.BusinesRuleException;
import io.github.brunoonofre64.mscreditappraiser.domain.utils.CardsApprovedForCustomer;
import io.github.brunoonofre64.mscreditappraiser.domain.utils.LimitApprovedForCustomer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class CardsApprovedForCustomerImpl implements CardsApprovedForCustomer {
    private final LimitApprovedForCustomer limitApprovedFactor;

    @Override
    public List<CardsApprovedDTO> getCardsApprovedForCustomer(CustomerOutputDTO customerData, List<CardsOutputDTO> cardsAvailable) {
        if (customerData == null || CollectionUtils.isEmpty(cardsAvailable)) {
            throw new BusinesRuleException(ErrorMessage.BUSINES_RULE);
        }

        return cardsAvailable
                .stream()
                .map(card -> {
                    BigDecimal limitApproved = limitApprovedFactor.getLimitApprovedForCustomer(customerData, card);

                    return CardsApprovedDTO
                            .builder()
                            .card(card.getName())
                            .flag(card.getCardFlag())
                            .limitApproved(limitApproved)
                            .build();
                }).collect(Collectors.toList());
    }
}
