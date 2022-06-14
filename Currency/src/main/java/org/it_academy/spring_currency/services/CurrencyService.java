package org.it_academy.spring_currency.services;

import jakarta.persistence.PersistenceException;
import org.it_academy.spring_currency.api.CRUD.ICRUDDao;
import org.it_academy.spring_currency.api.CRUD.ICRUDService;
import org.it_academy.spring_currency.mappers.CurrencyMapper;
import org.it_academy.currency.dao.entity.SpringCurrency;
import org.it_academy.spring_currency.dto.CurrencyDto;
import org.it_academy.spring_currency.dto.CurrencyId;
import org.it_academy.spring_currency.dto.Value;
import org.it_academy.spring_currency.exceptions.CurrencyServiceException;

import java.util.ArrayList;
import java.util.List;

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

        try {
            return dao.save(entity);

        }catch (PersistenceException e) {
            throw new CurrencyServiceException(409, "Conflict");
        }

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

        List<SpringCurrency> currencies = dao.getAll();

        currencies.forEach(x -> values.add(CurrencyMapper.map(x)));

        return values;
    }

    @Override
    public Value get(long id) {
        if (id == 0) {
            throw new CurrencyServiceException(415, "Unsupported media type");
        }

        try {
            return CurrencyMapper.map(dao.get(id));

        }catch (PersistenceException e) {
            throw new CurrencyServiceException(404, "Not found");
        }
    }

    @Override
    public void update(Value dto) {

        if (dto.getId() < 1) {
            throw new CurrencyServiceException(415, "Unsupported media type");
        }

        try {
            dao.update(CurrencyMapper.map(dto));

        }catch (IllegalArgumentException e) {
            throw new CurrencyServiceException(404, "Not found");
        }
    }
}
