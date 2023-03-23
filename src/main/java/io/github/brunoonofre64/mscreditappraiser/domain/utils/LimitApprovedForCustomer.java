package io.github.brunoonofre64.mscreditappraiser.domain.utils;

import io.github.brunoonofre64.mscreditappraiser.domain.dto.cards.CardsOutputDTO;
import io.github.brunoonofre64.mscreditappraiser.domain.dto.customer.CustomerOutputDTO;

import java.math.BigDecimal;

public interface LimitApprovedForCustomer {
    BigDecimal getLimitApprovedForCustomer(CustomerOutputDTO customerData, CardsOutputDTO card);
}
