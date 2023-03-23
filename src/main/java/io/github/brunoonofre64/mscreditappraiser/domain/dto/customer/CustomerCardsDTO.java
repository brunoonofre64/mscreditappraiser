package io.github.brunoonofre64.mscreditappraiser.domain.dto.customer;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CustomerCardsDTO {
    private String name;
    private String cardFlag;
    private BigDecimal cardLimitApproved;
}
