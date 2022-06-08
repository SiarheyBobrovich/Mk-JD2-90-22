package org.it_academy.spring_currency.exceptions;

import org.it_academy.spring_currency.exceptions.api.CurrencyIllegalArgumentException;

public class CurrencyServiceException extends CurrencyIllegalArgumentException {
    public CurrencyServiceException(int status, String message) {
        super(status, message);
    }

    public CurrencyServiceException(int status, String s, Throwable cause) {
        super(status, s, cause);
    }
}
