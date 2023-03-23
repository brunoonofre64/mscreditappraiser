package io.github.brunoonofre64.mscreditappraiser.domain.utils;

import io.github.brunoonofre64.mscreditappraiser.domain.dto.cards.CardsApprovedDTO;
import io.github.brunoonofre64.mscreditappraiser.domain.dto.cards.CardsOutputDTO;
import io.github.brunoonofre64.mscreditappraiser.domain.dto.customer.CustomerOutputDTO;

import java.util.List;

public interface CardsApprovedForCustomer {
    List<CardsApprovedDTO> getCardsApprovedForCustomer(CustomerOutputDTO customerData, List<CardsOutputDTO> cardsAvailable);
}
