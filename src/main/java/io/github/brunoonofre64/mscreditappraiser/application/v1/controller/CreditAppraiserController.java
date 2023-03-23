package io.github.brunoonofre64.mscreditappraiser.application.v1.controller;

import io.github.brunoonofre64.mscreditappraiser.domain.dto.customer.CustomerSituationDTO;
import io.github.brunoonofre64.mscreditappraiser.domain.dto.evaluation.DataForEvaluationDTO;
import io.github.brunoonofre64.mscreditappraiser.domain.dto.evaluation.ReturnCustomerEvaluationDTO;
import io.github.brunoonofre64.mscreditappraiser.domain.exception.CustomerDataNotFoundException;
import io.github.brunoonofre64.mscreditappraiser.domain.exception.ErrorMicroserviceComunicationException;
import io.github.brunoonofre64.mscreditappraiser.domain.service.CreditAppraiserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/credit-appraiser")
@RequiredArgsConstructor
public class CreditAppraiserController {

    private final CreditAppraiserService service;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(params = "cpf")
    public CustomerSituationDTO findCustomerSituationByCpf(@RequestParam("cpf") String cpf)
            throws ErrorMicroserviceComunicationException, CustomerDataNotFoundException {

        return service.findCustomerSituationByCpf(cpf);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ReturnCustomerEvaluationDTO performCreditEvaluation(@RequestBody DataForEvaluationDTO dataEvaluation)
            throws ErrorMicroserviceComunicationException, CustomerDataNotFoundException {

        return service.performCreditEvaluation(dataEvaluation);
    }
}
