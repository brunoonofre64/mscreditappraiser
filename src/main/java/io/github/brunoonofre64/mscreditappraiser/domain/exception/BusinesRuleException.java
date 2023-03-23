package io.github.brunoonofre64.mscreditappraiser.domain.exception;


import io.github.brunoonofre64.mscreditappraiser.domain.enums.ErrorMessage;

public class BusinesRuleException extends RuntimeException {

    final ErrorMessage message;

    public BusinesRuleException(ErrorMessage message) {
        this.message = message;
    }
}
