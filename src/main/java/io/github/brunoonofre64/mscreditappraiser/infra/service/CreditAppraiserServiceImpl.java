package io.github.brunoonofre64.mscreditappraiser.infra.service;

import feign.FeignException;
import io.github.brunoonofre64.mscreditappraiser.domain.dto.cards.CardsApprovedDTO;
import io.github.brunoonofre64.mscreditappraiser.domain.dto.cards.CardsCustomerOutputDTO;
import io.github.brunoonofre64.mscreditappraiser.domain.dto.cards.CardsOutputDTO;
import io.github.brunoonofre64.mscreditappraiser.domain.dto.customer.CustomerCardsDTO;
import io.github.brunoonofre64.mscreditappraiser.domain.dto.customer.CustomerDataDTO;
import io.github.brunoonofre64.mscreditappraiser.domain.dto.customer.CustomerOutputDTO;
import io.github.brunoonofre64.mscreditappraiser.domain.dto.customer.CustomerSituationDTO;
import io.github.brunoonofre64.mscreditappraiser.domain.dto.evaluation.DataForEvaluationDTO;
import io.github.brunoonofre64.mscreditappraiser.domain.dto.evaluation.ReturnCustomerEvaluationDTO;
import io.github.brunoonofre64.mscreditappraiser.domain.enums.ErrorMessage;
import io.github.brunoonofre64.mscreditappraiser.domain.exception.BusinesRuleException;
import io.github.brunoonofre64.mscreditappraiser.domain.exception.CustomerDataNotFoundException;
import io.github.brunoonofre64.mscreditappraiser.domain.exception.ErrorMicroserviceComunicationException;
import io.github.brunoonofre64.mscreditappraiser.domain.mapper.CreditAppraiserMapper;
import io.github.brunoonofre64.mscreditappraiser.domain.service.CreditAppraiserService;
import io.github.brunoonofre64.mscreditappraiser.domain.utils.CardsApprovedForCustomer;
import io.github.brunoonofre64.mscreditappraiser.infra.clients.CardsResourceClients;
import io.github.brunoonofre64.mscreditappraiser.infra.clients.CustomerResourceClients;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CreditAppraiserServiceImpl implements CreditAppraiserService {

    private final CustomerResourceClients customerClients;
    private final CardsResourceClients cardsClients;
    private final CardsApprovedForCustomer cardsApprovedFactor;
    private final CreditAppraiserMapper mapper;

    @Override
    public CustomerSituationDTO findCustomerSituationByCpf(String cpf)
            throws CustomerDataNotFoundException, ErrorMicroserviceComunicationException {

        if (cpf == null) {
            throw new BusinesRuleException(ErrorMessage.BUSINES_RULE);
        }

        try {
            CustomerOutputDTO customer = customerClients.findCustomerByCpf(cpf);
            List<CardsCustomerOutputDTO> cardsCustomer = cardsClients.findCardsCustomerByCpf(cpf);

            CustomerDataDTO customerData = mapper.mapToCustomerData(customer);
            List<CustomerCardsDTO> cardsData = mapper.mapToListCardsCustomer(cardsCustomer);

            return CustomerSituationDTO
                    .builder()
                    .customer(customerData)
                    .cards(cardsData)
                    .build();

        } catch (FeignException.FeignClientException ex) {
            int status = ex.status();

            if (HttpStatus.NOT_FOUND.value() == status) {
                throw new CustomerDataNotFoundException(ErrorMessage.CUSTOMER_DATA_NOT_FOUND);
            }
        }
        throw new ErrorMicroserviceComunicationException(ErrorMessage.ERROR_COMMUNICATION);
    }

    @Override
    public ReturnCustomerEvaluationDTO performCreditEvaluation(DataForEvaluationDTO dataEvaluation)
            throws CustomerDataNotFoundException, ErrorMicroserviceComunicationException {

        if (dataEvaluation == null) {
            throw new BusinesRuleException(ErrorMessage.BUSINES_RULE);
        }

        try {
            List<CardsOutputDTO> cardsAvailable = cardsClients.findCardsIncomeLessThanEqual(dataEvaluation.getIncome());
            CustomerOutputDTO customerData = customerClients.findCustomerByCpf(dataEvaluation.getCpf());

            List<CardsApprovedDTO> cardsApproved = cardsApprovedFactor.getCardsApprovedForCustomer(customerData, cardsAvailable);

            return new ReturnCustomerEvaluationDTO(cardsApproved);

        } catch (FeignException.FeignClientException ex) {
            int status = ex.status();

            if (HttpStatus.NOT_FOUND.value() == status) {
                throw new CustomerDataNotFoundException(ErrorMessage.CUSTOMER_DATA_NOT_FOUND);
            }
        }
        throw new ErrorMicroserviceComunicationException(ErrorMessage.ERROR_COMMUNICATION);
    }
}
