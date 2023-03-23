package io.github.brunoonofre64.mscreditappraiser.infra.clients;

import io.github.brunoonofre64.mscreditappraiser.domain.dto.customer.CustomerOutputDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

@FeignClient(value = "mscustomer", path = "/customer")
public interface CustomerResourceClients {
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(params = "cpf")
    CustomerOutputDTO findCustomerByCpf(@RequestParam("cpf") String cpf);
}
