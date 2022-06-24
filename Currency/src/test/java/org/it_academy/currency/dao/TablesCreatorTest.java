package org.it_academy.currency.dao;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

class TablesCreatorTest {

    static {
        Path ddl = Path.of("src/main/resources/test/ddl_test.sql").toAbsolutePath();
        try {
            String s = Files.readString(ddl);

            EntityManager entityManager = Persistence
                    .createEntityManagerFactory("org.it_academy.currency.dao.entity")
                    .createEntityManager();

            entityManager.getTransaction().begin();
                    entityManager.createNativeQuery(s).executeUpdate();
                    entityManager.getTransaction().commit();
                    entityManager.close();



        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
