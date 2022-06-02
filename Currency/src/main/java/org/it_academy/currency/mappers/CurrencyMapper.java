package org.it_academy.currency.mappers;

import org.it_academy.currency.dao.entity.Currency;
import org.it_academy.currency.dto.Value;

import java.time.LocalDateTime;

public class CurrencyMapper {

    public static Currency map(Value value) {
        Currency currency = new Currency();

        currency.setId(value.getId());
        currency.setCode(value.getCode());
        currency.setName(value.getName());
        currency.setDescription(value.getDescription());
        currency.setCreateDate(LocalDateTime.now());
        currency.setUpdateDate(LocalDateTime.now());

        return currency;
    }

    public static Value map(Currency currency) {

        return Value.create()
                .setId(currency.getId())
                .setCode(currency.getCode())
                .setName(currency.getName())
                .setDescription(currency.getDescription())
                .build();
    }
}
