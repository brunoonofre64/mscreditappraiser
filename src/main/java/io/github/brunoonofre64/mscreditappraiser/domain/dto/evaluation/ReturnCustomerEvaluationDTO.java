package io.github.brunoonofre64.mscreditappraiser.domain.dto.evaluation;

import io.github.brunoonofre64.mscreditappraiser.domain.dto.cards.CardsApprovedDTO;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReturnCustomerEvaluationDTO {
    private List<CardsApprovedDTO> cardsApproved;
}
