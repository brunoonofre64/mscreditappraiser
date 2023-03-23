package io.github.brunoonofre64.mscreditappraiser.domain.dto.cards;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CardsOutputDTO {
    private String uuid;
    private String name;
    private String cardFlag;
    private BigDecimal basicLimit;
}
