package io.github.brunoonofre64.mscreditappraiser.domain.dto.cards;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DataRequestedIssuanceCardDTO {
    private String uuidCards;
    private String address;
    private String cpf;
    private BigDecimal limitReleased;
}

