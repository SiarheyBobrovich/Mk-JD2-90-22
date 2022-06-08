package org.it_academy.spring_currency.dao;

import jakarta.persistence.EntityManager;

public interface IEntityManager extends AutoCloseable {

    EntityManager getManager();

}
