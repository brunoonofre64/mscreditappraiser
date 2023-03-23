package io.github.brunoonofre64.mscreditappraiser.domain.mapper;

import io.github.brunoonofre64.mscreditappraiser.domain.dto.cards.CardsCustomerOutputDTO;
import io.github.brunoonofre64.mscreditappraiser.domain.dto.customer.CustomerCardsDTO;
import io.github.brunoonofre64.mscreditappraiser.domain.dto.customer.CustomerDataDTO;
import io.github.brunoonofre64.mscreditappraiser.domain.dto.customer.CustomerOutputDTO;

import java.util.List;

public interface CreditAppraiserMapper {
    CustomerDataDTO mapToCustomerData(CustomerOutputDTO customerOutputDTO);
    List<CustomerCardsDTO> mapToListCardsCustomer(List<CardsCustomerOutputDTO> cardsCustomer);
}
