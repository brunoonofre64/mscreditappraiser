package io.github.brunoonofre64.mscreditappraiser.domain.service;

import io.github.brunoonofre64.mscreditappraiser.domain.dto.customer.CustomerSituationDTO;
import io.github.brunoonofre64.mscreditappraiser.domain.dto.evaluation.DataForEvaluationDTO;
import io.github.brunoonofre64.mscreditappraiser.domain.dto.evaluation.ReturnCustomerEvaluationDTO;
import io.github.brunoonofre64.mscreditappraiser.domain.exception.CustomerDataNotFoundException;
import io.github.brunoonofre64.mscreditappraiser.domain.exception.ErrorMicroserviceComunicationException;

public interface CreditAppraiserService {
    CustomerSituationDTO findCustomerSituationByCpf(String cpf)
            throws CustomerDataNotFoundException, ErrorMicroserviceComunicationException;
    ReturnCustomerEvaluationDTO performCreditEvaluation(DataForEvaluationDTO dataEvaluation) throws CustomerDataNotFoundException, ErrorMicroserviceComunicationException;
}
