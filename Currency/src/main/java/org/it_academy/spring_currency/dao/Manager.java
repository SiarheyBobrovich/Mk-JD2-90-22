package org.it_academy.spring_currency.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.Properties;

public class Manager implements IEntityManager {

    private final EntityManagerFactory entityManagerFactory ;

    public Manager(Properties properties) {

        entityManagerFactory = Persistence
                .createEntityManagerFactory(
                        "org.it_academy.currency.dao.entity", properties);
    }


    public EntityManager getManager() {
        return entityManagerFactory.createEntityManager();
    }

    @Override
    public void close() throws Exception {
        entityManagerFactory.close();
    }
}
