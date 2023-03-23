package io.github.brunoonofre64.mscreditappraiser.infra.clients;

import io.github.brunoonofre64.mscreditappraiser.domain.dto.cards.CardsCustomerOutputDTO;
import io.github.brunoonofre64.mscreditappraiser.domain.dto.cards.CardsOutputDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@FeignClient(value = "mscards", path = "/cards")
public interface CardsResourceClients {

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(params = "cpf")
    List<CardsCustomerOutputDTO> findCardsCustomerByCpf(@RequestParam("cpf") String cpf);

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(params = "income")
    List<CardsOutputDTO> findCardsIncomeLessThanEqual(@RequestParam("income") Long income);

}
