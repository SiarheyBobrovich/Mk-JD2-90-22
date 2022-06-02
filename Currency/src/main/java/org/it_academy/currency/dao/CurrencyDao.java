package org.it_academy.currency.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.Predicate;
import org.it_academy.currency.api.CRUD.ICRUDHibernate;
import org.it_academy.currency.dao.entity.Currency;

import java.util.List;

public class CurrencyDao implements ICRUDHibernate {

    private static final  CurrencyDao instance = new CurrencyDao();

    private CurrencyDao() {
    }

    private final Manager manager = Manager.getInstance();

    @Override
    public long save(Currency currency) {
        EntityManager entityManager = manager.getEntityManager();

        entityManager.getTransaction().begin();

        entityManager.persist(currency);

        entityManager.getTransaction().commit();
        entityManager.close();

        return currency.getId();
    }

    @Override
    public void delete(Currency currency) {
        EntityManager entityManager = manager.getEntityManager();

        entityManager.getTransaction().begin();

        Currency currency1 = entityManager.find(Currency.class, currency.getId());

        entityManager.remove(currency1);

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public List<Currency> getAll() {
        EntityManager entityManager = manager.getEntityManager();

        entityManager.getTransaction().begin();

        List<Currency> currencies = (List<Currency>) entityManager.createQuery("SELECT c FROM Currency c")
                .getResultList();

        entityManager.getTransaction().commit();
        entityManager.close();

        return currencies;
    }

    @Override
    public Currency get(long id) {
        EntityManager entityManager = manager.getEntityManager();

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
        EntityManager entityManager = manager.getEntityManager();

        entityManager.getTransaction().begin();

        entityManager.merge(currency);

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public static CurrencyDao getInstance() {
        return instance;
    }
}
