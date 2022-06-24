package org.it_academy.currency.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Manager implements AutoCloseable {

    private static final Manager instance = new Manager();

    private static final EntityManagerFactory entityManagerFactory = Persistence
            .createEntityManagerFactory("org.it_academy.currency.dao.entity");


    private Manager() {

    }

    public EntityManager getManager() {
        return entityManagerFactory.createEntityManager();
    }

    public static Manager getInstance() {
        return instance;
    }

    @Override
    public void close() throws Exception {
        entityManagerFactory.close();
    }
}
