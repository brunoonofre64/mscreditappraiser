package io.github.brunoonofre64.mscreditappraiser.domain.enums;

import lombok.Getter;

@Getter
public enum ErrorMessage {

    BUSINES_RULE("BUSINES_RULE"),
    BAD_REQUEST("BAD_REQUEST"),
    CUSTOMER_DATA_NOT_FOUND("CUSTOMER_DATA_NOT_FOUND"),
    ERROR_COMMUNICATION("ERROR_COMMUNICATION"),
    BAD_GATEWAY("BAD_GATEWAY"),
    ERROR_REQUEST_CARD("ERROR_REQUEST_CARD");

    final String value;

    ErrorMessage(String value) {
        this.value = value;
    }
}
