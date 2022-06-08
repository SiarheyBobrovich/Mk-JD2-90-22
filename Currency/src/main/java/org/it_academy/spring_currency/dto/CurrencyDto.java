package org.it_academy.spring_currency.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Objects;

public class CurrencyDto implements Serializable {

    private final String code;

    private final String name;
    private final String description;


    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public CurrencyDto(@JsonProperty(value = "code", required = true) String code,
                       @JsonProperty(value = "name", required = true) String name,
                       @JsonProperty(value = "description") String description) {
        this.code = code;
        this.name = name;
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CurrencyDto entity = (CurrencyDto) o;
        return Objects.equals(this.code, entity.code) &&
                Objects.equals(this.name, entity.name) &&
                Objects.equals(this.description, entity.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, name, description);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "code = " + code + ", " +
                "name = " + name + ", " +
                "description = " + description + ")";
    }
}
