package org.it_academy.currency.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

public class Manager {

    private static final Manager instance = new Manager();

    private Manager() {
    }

    public EntityManager getEntityManager() {

        return Persistence
                .createEntityManagerFactory("org.it_academy.currency.dao.entity")
                .createEntityManager();
    }

    public static Manager getInstance() {
        return instance;
    }
}
