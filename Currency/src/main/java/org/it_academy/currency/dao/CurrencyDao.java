package org.it_academy.currency.dao;

import org.it_academy.currency.api.CRUD.ICRUDHibernate;
import org.it_academy.currency.dao.entity.Currency;
import org.it_academy.currency.exceptions.CurrencyServiceException;

import javax.persistence.EntityManager;
import java.util.List;

public class CurrencyDao implements ICRUDHibernate {

    private static final  CurrencyDao instance = new CurrencyDao();

    private CurrencyDao() {
    }

    private final Manager manager = Manager.getInstance();

    @Override
    public long save(Currency currency) {
        EntityManager entityManager = manager.getManager();

        entityManager.getTransaction().begin();

        entityManager.persist(currency);

        entityManager.getTransaction().commit();
        entityManager.close();

        return currency.getId();
    }

    @Override
    public void delete(Currency currency) {
        EntityManager entityManager = manager.getManager();

        entityManager.getTransaction().begin();

        Currency currency1 = entityManager.find(Currency.class, currency.getId());

        if (currency1 != null) {
            entityManager.remove(currency1);
        }

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public List<Currency> getAll() {
        EntityManager entityManager = manager.getManager();

        entityManager.getTransaction().begin();

        List<Currency> currencies = (List<Currency>) entityManager.createQuery(
                "SELECT c FROM Currency c ORDER BY id"
                ).getResultList();

        entityManager.getTransaction().commit();
        entityManager.close();

        return currencies;
    }

    @Override
    public Currency get(long id) {
        EntityManager entityManager = manager.getManager();

        entityManager.getTransaction().begin();

        Currency singleResult = (Currency) entityManager
                .createQuery("SELECT c FROM Currency c WHERE c.id = ?1")
                .setParameter(1, id)
                .getSingleResult();

        entityManager.getTransaction().commit();
        entityManager.close();

        return singleResult;
    }

    @Override
    public void update(Currency currency) {
        EntityManager entityManager = manager.getManager();

        entityManager.getTransaction().begin();
        Currency currency1 = entityManager.find(Currency.class, currency.getId());

        if (currency1 == null) {
            throw new CurrencyServiceException(404, "Not found");
        }

        currency1.setDescription(currency.getDescription());
        currency1.setUpdateDate(currency.getUpdateDate());

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public static CurrencyDao getInstance() {
        return instance;
    }
}
