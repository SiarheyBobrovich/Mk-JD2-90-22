package org.it_academy.spring_currency.api.CRUD;

import org.it_academy.spring_currency.dto.CurrencyDto;
import org.it_academy.spring_currency.dto.CurrencyId;
import org.it_academy.spring_currency.dto.Value;

public interface ICRUDService extends ICRUDController<CurrencyDto, Value, Value, CurrencyId> {

}
