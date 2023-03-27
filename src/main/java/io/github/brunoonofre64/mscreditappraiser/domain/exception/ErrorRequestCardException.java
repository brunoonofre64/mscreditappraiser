package io.github.brunoonofre64.mscreditappraiser.domain.exception;

import io.github.brunoonofre64.mscreditappraiser.domain.enums.ErrorMessage;

public class ErrorRequestCardException extends Exception{
    final ErrorMessage message;

    public ErrorRequestCardException(ErrorMessage message) {
        this.message = message;
    }
}
