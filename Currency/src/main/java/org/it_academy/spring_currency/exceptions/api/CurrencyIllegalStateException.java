package org.it_academy.spring_currency.exceptions.api;

public abstract class CurrencyIllegalStateException extends IllegalStateException{

    private final int status;

    public CurrencyIllegalStateException(int status, String message) {
        super(message);
        this.status = status;
    }

    public CurrencyIllegalStateException(int status, String s, Throwable cause) {
        super(s, cause);
        this.status = status;
    }

    public int getStatus() {
        return status;
    }
}
