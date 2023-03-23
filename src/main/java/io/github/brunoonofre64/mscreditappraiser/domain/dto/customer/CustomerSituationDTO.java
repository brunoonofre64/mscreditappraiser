package io.github.brunoonofre64.mscreditappraiser.domain.dto.customer;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CustomerSituationDTO {
    private CustomerDataDTO customer;
    List<CustomerCardsDTO> cards;
}
