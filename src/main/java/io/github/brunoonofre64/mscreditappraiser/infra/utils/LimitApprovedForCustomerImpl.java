package io.github.brunoonofre64.mscreditappraiser.infra.utils;

import io.github.brunoonofre64.mscreditappraiser.domain.dto.cards.CardsOutputDTO;
import io.github.brunoonofre64.mscreditappraiser.domain.dto.customer.CustomerOutputDTO;
import io.github.brunoonofre64.mscreditappraiser.domain.dto.evaluation.DataForEvaluationDTO;
import io.github.brunoonofre64.mscreditappraiser.domain.enums.ErrorMessage;
import io.github.brunoonofre64.mscreditappraiser.domain.exception.BusinesRuleException;
import io.github.brunoonofre64.mscreditappraiser.domain.utils.LimitApprovedForCustomer;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Component
public class LimitApprovedForCustomerImpl implements LimitApprovedForCustomer {

    public BigDecimal getLimitApprovedForCustomer(CustomerOutputDTO customerData, CardsOutputDTO card) {
        if (customerData == null || card == null) {
            throw new BusinesRuleException(ErrorMessage.BUSINES_RULE);
        }

        BigDecimal basicLimit = card.getBasicLimit();
        BigDecimal ageCustomerBigDecimal = BigDecimal.valueOf(customerData.getAge());

        var factor = ageCustomerBigDecimal.divide(BigDecimal.valueOf(10), RoundingMode.HALF_UP);
        return factor.multiply(basicLimit);
    }
}
