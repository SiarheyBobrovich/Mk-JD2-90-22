package org.it_academy.spring_currency.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CurrencyId {

    private final long id;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public CurrencyId(@JsonProperty("id") long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }
}
