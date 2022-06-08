package org.it_academy.spring_currency.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Manager implements IEntityManager {

    private final EntityManagerFactory entityManagerFactory ;

    public Manager() {
        entityManagerFactory = Persistence
                .createEntityManagerFactory("org.it_academy.currency.dao.entity");
    }


    public EntityManager getManager() {
        return entityManagerFactory.createEntityManager();
    }

    @Override
    public void close() throws Exception {
        entityManagerFactory.close();
    }
}
