package io.github.brunoonofre64.mscreditappraiser.domain.exception;

import io.github.brunoonofre64.mscreditappraiser.domain.enums.ErrorMessage;

public class ErrorMicroserviceComunicationException extends Exception {

    final ErrorMessage message;

    public ErrorMicroserviceComunicationException(ErrorMessage message) {
        this.message = message;
    }
}
