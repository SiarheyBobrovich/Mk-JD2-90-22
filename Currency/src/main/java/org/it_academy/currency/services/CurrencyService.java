package org.it_academy.currency.services;

import jakarta.persistence.PersistenceException;
import org.it_academy.currency.api.CRUD.ICRUDHibernate;
import org.it_academy.currency.api.CRUD.ICRUDService;
import org.it_academy.currency.dao.CurrencyDao;
import org.it_academy.currency.dao.entity.Currency;
import org.it_academy.currency.dto.Value;
import org.it_academy.currency.exceptions.CurrencyServiceException;
import org.it_academy.currency.mappers.CurrencyMapper;

import java.util.ArrayList;
import java.util.List;

public class CurrencyService implements ICRUDService {

    private static final CurrencyService instance = new CurrencyService();
    private static final ICRUDHibernate dao = CurrencyDao.getInstance();

    private CurrencyService() {
    }



    public static CurrencyService getInstance() {
        return instance;
    }

    @Override
    public long save(Value dto) {
        String code = dto.getCode();
        String name = dto.getName();

        if (code == null || code.isEmpty()) {
            throw new CurrencyServiceException(415, "Unsupported media type");
        }

        if (name == null || name.isEmpty()) {
            throw new CurrencyServiceException(415, "Unsupported media type");
        }

        Currency entity = CurrencyMapper.map(dto);

        try {
            return dao.save(entity);

        }catch (PersistenceException e) {
            throw new CurrencyServiceException(409, "Conflict");
        }

    }

    @Override
    public void delete(Value dto) {
        if (dto.getId() == 0) {
            throw new CurrencyServiceException(415, "Unsupported media type");
        }

        Currency entity = CurrencyMapper.map(dto);

        dao.delete(entity);
    }

    @Override
    public List<Value> getAll() {
        List<Value> values = new ArrayList<>();

        List<Currency> currencies = dao.getAll();

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
