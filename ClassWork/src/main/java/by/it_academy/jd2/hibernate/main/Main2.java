package by.it_academy.jd2.hibernate.main;

import by.it_academy.jd2.hibernate.dao.entity.Event;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

public class Main2 {



    public static void main(String[] args) throws InterruptedException {

        EntityManagerFactory sessionFactory =
                Persistence.createEntityManagerFactory("by.it_academy.jd2.hibernate.dao.entity");

        EntityManager entityManager = sessionFactory.createEntityManager();
        entityManager.getTransaction().begin();

        entityManager.persist(
                new Event( "Our very first event!", LocalDateTime.now())
        );

        TimeUnit.SECONDS.sleep(30);

        entityManager.persist(
                new Event( "A follow up event",  LocalDateTime.now())
        );



        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
