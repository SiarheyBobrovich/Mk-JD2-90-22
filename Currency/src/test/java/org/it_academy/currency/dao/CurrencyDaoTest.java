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

    private static final long id = 9;

    static {
        currency = new Currency();
        currency.setCode("BY");
        currency.setName("United states");
        currency.setDescription("Вроде деньги, а вроде и нет");
        currency.setCreateDate(LocalDateTime.now());
        currency.setUpdateDate(LocalDateTime.now());
    }



    @Test
    void fullTest() {
        save();
        get();
        update();
        getAll();
        delete();
    }
    @Test
    void save() {
        Assertions.assertDoesNotThrow(() -> System.out.println(dao.save(currency)));
    }

    @Test
    void getAll() {
        Assertions.assertDoesNotThrow(dao::getAll);
        List<Currency> all = dao.getAll();

        Assertions.assertNotNull(all);

        System.out.println("Version = " +  all.get(0));
    }

    @Test
    void get() {
        Assertions.assertDoesNotThrow(() -> dao.get(id));
        Currency currency1 = dao.get(id);

        Assertions.assertNotNull(currency1);

        System.out.println("Version = " + currency1);
    }

    @Test
    void update() {
        currency.setId(id);
        currency.setDescription("Белки");
        Assertions.assertDoesNotThrow(() -> dao.update(currency));
    }

    @Test
    void delete() {
        currency.setId(id);
        Assertions.assertDoesNotThrow(() -> dao.delete(currency));
    }
}