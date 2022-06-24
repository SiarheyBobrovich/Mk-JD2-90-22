package org.it_academy.spring_currency.services;

import javax.persistence.PersistenceException;
import org.it_academy.spring_currency.api.CRUD.ICRUDDao;
import org.it_academy.spring_currency.api.CRUD.ICRUDService;
import org.it_academy.spring_currency.mappers.CurrencyMapper;
import org.it_academy.currency.dao.entity.SpringCurrency;
import org.it_academy.spring_currency.dto.CurrencyDto;
import org.it_academy.spring_currency.dto.CurrencyId;
import org.it_academy.spring_currency.dto.Value;
import org.it_academy.spring_currency.exceptions.CurrencyServiceException;
import org.springframework.data.domain.Example;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CurrencyService implements ICRUDService {

    private final ICRUDDao dao;

    public CurrencyService(ICRUDDao dao) {
        this.dao = dao;
    }
    @Override
    public long save(CurrencyDto dto) {
        String code = dto.getCode();
        String name = dto.getName();

        if (code == null || code.isEmpty()) {
            throw new CurrencyServiceException(415, "Unsupported media type");
        }

        if (name == null || name.isEmpty()) {
            throw new CurrencyServiceException(415, "Unsupported media type");
        }

        SpringCurrency entity = CurrencyMapper.map(dto);

        entity = dao.save(entity);

        return entity.getId();

    }

    @Override
    public void delete(CurrencyId dto) {
        if (dto.getId() == 0) {
            throw new CurrencyServiceException(415, "Unsupported media type");
        }

        SpringCurrency entity = CurrencyMapper.map(dto);

        dao.delete(entity);
    }

    @Override
    public List<Value> getAll() {
        List<Value> values = new ArrayList<>();

        List<SpringCurrency> currencies = dao.findAll();

        currencies.forEach(x -> values.add(CurrencyMapper.map(x)));

        return values;
    }

    @Override
    public Value get(long id) {
        if (id == 0) {
            throw new CurrencyServiceException(415, "Unsupported media type");
        }

        Optional<SpringCurrency> byId = dao.findById(id);

        if (byId.isEmpty()) {
            throw new CurrencyServiceException(404, "Not found");
        }

        return CurrencyMapper.map(byId.get());

    }

    @Override
    public void update(Value dto, long id) {

        if (id < 1) {
            throw new CurrencyServiceException(415, "Unsupported media type");
        }

        SpringCurrency currency = dao
                .findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Currency not found"));

        currency.setDescription(dto.getDescription());
        dao.save(currency);

    }
}
