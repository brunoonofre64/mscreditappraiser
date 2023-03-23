package io.github.brunoonofre64.mscreditappraiser.domain.dto.cards;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CardsApprovedDTO {
    private String card;
    private String flag;
    private BigDecimal limitApproved;
}
