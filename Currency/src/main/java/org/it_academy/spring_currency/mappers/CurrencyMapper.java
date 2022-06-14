package org.it_academy.spring_currency.mappers;

import org.it_academy.currency.dao.entity.SpringCurrency;
import org.it_academy.spring_currency.dto.CurrencyDto;
import org.it_academy.spring_currency.dto.CurrencyId;
import org.it_academy.spring_currency.dto.Value;

import java.time.LocalDateTime;

public class CurrencyMapper {

    private CurrencyMapper() {
    }

    public static SpringCurrency map(Value value) {
        SpringCurrency currency = new SpringCurrency();

        currency.setId(value.getId());
        currency.setCode(value.getCode());
        currency.setName(value.getName());
        currency.setDescription(value.getDescription());
        currency.setCreateDate(LocalDateTime.now());
        currency.setUpdateDate(currency.getCreateDate());

        return currency;
    }

    public static SpringCurrency map(CurrencyId value) {
        SpringCurrency currency = new SpringCurrency();

        currency.setId(value.getId());

        return currency;
    }

    public static SpringCurrency map(CurrencyDto value) {
        SpringCurrency currency = new SpringCurrency();

        currency.setCode(value.getCode());
        currency.setName(value.getName());
        currency.setDescription(value.getDescription());
        currency.setCreateDate(LocalDateTime.now());
        currency.setUpdateDate(LocalDateTime.now());

        return currency;
    }

    public static Value map(SpringCurrency currency) {

        return Value.create()
                .setId(currency.getId())
                .setCode(currency.getCode())
                .setName(currency.getName())
                .setDescription(currency.getDescription())
                .setCreateDate(currency.getCreateDate())
                .setUpdateDate(currency.getUpdateDate())
                .build();
    }
}
