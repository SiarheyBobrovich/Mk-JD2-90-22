package org.it_academy.spring_currency.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.*;
import org.it_academy.spring_currency.api.CRUD.ICRUDHibernateDao;
import org.it_academy.currency.dao.entity.SpringCurrency;
import org.it_academy.spring_currency.exceptions.CurrencyServiceException;

import java.util.List;

public class CurrencyDao implements ICRUDHibernateDao {

    private final IEntityManager manager;

    public CurrencyDao(IEntityManager manager) {
        this.manager = manager;
    }

    @Override
    public long save(SpringCurrency currency) {
        EntityManager entityManager = manager.getManager();

        entityManager.getTransaction().begin();

        entityManager.persist(currency);

        entityManager.getTransaction().commit();
        entityManager.close();

        return currency.getId();
    }

    @Override
    public void delete(SpringCurrency currency) {
        EntityManager entityManager = manager.getManager();

        entityManager.getTransaction().begin();

        SpringCurrency currency1 = entityManager.find(SpringCurrency.class, currency.getId());

        if (currency1 != null) {
            entityManager.remove(currency1);
        }

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public List<SpringCurrency> getAll() {
        EntityManager entityManager = manager.getManager();

        entityManager.getTransaction().begin();

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<SpringCurrency> cr = cb.createQuery(SpringCurrency.class);
        Root<SpringCurrency> from = cr.from(SpringCurrency.class);
        cr.select(from).orderBy(cb.asc(from.get("id")));

        List<SpringCurrency> currencies = entityManager.createQuery(cr).getResultList();

        entityManager.getTransaction().commit();
        entityManager.close();

        return currencies;
    }

    @Override
    public SpringCurrency get(long id) {
        EntityManager entityManager = manager.getManager();

        entityManager.getTransaction().begin();

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<SpringCurrency> query = criteriaBuilder.createQuery(SpringCurrency.class);
        Root<SpringCurrency> root = query.from(SpringCurrency.class);
        Predicate whereId = criteriaBuilder.equal(root.get("id"), id);

        query.select(root).where(whereId);


        SpringCurrency singleResult = entityManager.createQuery(query).getSingleResult();

        entityManager.getTransaction().commit();
        entityManager.close();

        return singleResult;
    }

    @Override
    public void update(SpringCurrency currency) {
        EntityManager entityManager = manager.getManager();

        entityManager.getTransaction().begin();
        SpringCurrency currency1 = entityManager.find(SpringCurrency.class, currency.getId());

        if (currency1 == null) {
            throw new CurrencyServiceException(404, "Not found");
        }

        currency1.setDescription(currency.getDescription());
        currency1.setUpdateDate(currency.getUpdateDate());

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
