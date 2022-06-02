package org.it_academy.currency.exceptions.api;

public abstract class CurrencyIllegalArgumentException extends IllegalArgumentException{

    private final int status;

    public CurrencyIllegalArgumentException(int status, String message) {
        super(message);
        this.status = status;
    }

    public CurrencyIllegalArgumentException(int status, String s, Throwable cause) {
        super(s, cause);
        this.status = status;
    }

    public int getStatus() {
        return status;
    }
}
