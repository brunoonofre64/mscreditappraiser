package io.github.brunoonofre64.mscreditappraiser.domain.exception;

import io.github.brunoonofre64.mscreditappraiser.domain.enums.ErrorMessage;

public class CustomerDataNotFoundException extends Exception {

    final ErrorMessage message;
    public CustomerDataNotFoundException(ErrorMessage message) {
        this.message = message;
    }
}
