package org.it_academy.currency.exceptions;

import org.it_academy.currency.exceptions.api.CurrencyIllegalStateException;

public class CurrencyDaoException extends CurrencyIllegalStateException {

    public CurrencyDaoException(int status, String message) {
        super(status, message);
    }

    public CurrencyDaoException(int status, String s, Throwable cause) {
        super(status, s, cause);
    }
}
