package io.github.brunoonofre64.mscreditappraiser.application.v1.handler;


import io.github.brunoonofre64.mscreditappraiser.domain.enums.ErrorMessage;
import io.github.brunoonofre64.mscreditappraiser.domain.exception.BusinesRuleException;
import io.github.brunoonofre64.mscreditappraiser.domain.exception.CustomerDataNotFoundException;
import io.github.brunoonofre64.mscreditappraiser.domain.exception.ErrorMicroserviceComunicationException;
import lombok.AllArgsConstructor;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@RestControllerAdvice
@AllArgsConstructor
public class ApplicationHandler extends ResponseEntityExceptionHandler {
    private ReloadableResourceBundleMessageSource messageBundle;

    @ExceptionHandler(BusinesRuleException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ApiErrors> handlerBusinesRuleException(BusinesRuleException ex) {
        ApiErrors apiErrors = ApiErrors
                .builder()
                .title(getCodeMessage(ErrorMessage.BAD_REQUEST))
                .codeStatus(HttpStatus.BAD_REQUEST.value())
                .timestamp(LocalDateTime.now())
                .details(getCodeMessage(ErrorMessage.BUSINES_RULE))
                .build();
        return new ResponseEntity<>(apiErrors, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(CustomerDataNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ApiErrors> handlerCustomerDataNotFoundException(CustomerDataNotFoundException ex) {
        ApiErrors apiErrors = ApiErrors
                .builder()
                .title(getCodeMessage(ErrorMessage.BAD_REQUEST))
                .codeStatus(HttpStatus.BAD_REQUEST.value())
                .timestamp(LocalDateTime.now())
                .details(getCodeMessage(ErrorMessage.CUSTOMER_DATA_NOT_FOUND))
                .build();
        return new ResponseEntity<>(apiErrors, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ErrorMicroserviceComunicationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ApiErrors> handlerErrorMicroserviceComunicationException(ErrorMicroserviceComunicationException ex) {
        ApiErrors apiErrors = ApiErrors
                .builder()
                .title(getCodeMessage(ErrorMessage.BAD_GATEWAY))
                .codeStatus(HttpStatus.BAD_GATEWAY.value())
                .timestamp(LocalDateTime.now())
                .details(getCodeMessage(ErrorMessage.ERROR_COMMUNICATION))
                .build();
        return new ResponseEntity<>(apiErrors, HttpStatus.BAD_REQUEST);
    }

    private String getCodeMessage(ErrorMessage message) {
        return messageBundle.getMessage(message.getValue(), null, LocaleContextHolder.getLocale());
    }
}
