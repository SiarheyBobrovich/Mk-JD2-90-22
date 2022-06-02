package org.it_academy.currency.dao;

import org.it_academy.currency.api.CRUD.ICRUDHibernate;
import org.it_academy.currency.dao.entity.Currency;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

class CurrencyDaoTest {

    private static final Currency currency;
    private static final ICRUDHibernate dao = CurrencyDao.getInstance();

    static {
        currency = new Currency("BY", "Вроде деньи", "Belarus");
        currency.setCreateDate(LocalDateTime.now());
        currency.setUpdateDate(LocalDateTime.now());
    }

    @Test
    void save() {

        Assertions.assertDoesNotThrow(() -> dao.save(currency));
    }

    @Test
    void delete() {
        currency.setId(2);
        Assertions.assertDoesNotThrow(() -> dao.delete(currency));
    }

    @Test
    void getAll() {
        Assertions.assertDoesNotThrow(dao::getAll);
        List<Currency> all = dao.getAll();
        all.forEach(System.out::println);
    }

    @Test
    void get() {
        long id = 3;
        Assertions.assertDoesNotThrow(() -> dao.get(3));
        Currency currency1 = dao.get(id);

        System.out.println(currency1);
    }

    @Test
    void update() {
        currency.setId(3);
        currency.setDescription("Белки");
        Assertions.assertDoesNotThrow(() -> dao.update(currency));
    }
}