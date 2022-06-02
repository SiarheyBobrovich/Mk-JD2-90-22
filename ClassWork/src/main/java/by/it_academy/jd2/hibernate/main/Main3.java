package by.it_academy.jd2.hibernate.main;

import by.it_academy.jd2.hibernate.dao.entity.Event;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDateTime;

public class Main3 {



    public static void main(String[] args) {

        Event event = new Event("Our very first event!", LocalDateTime.now());

        EntityManagerFactory sessionFactory =
                Persistence.createEntityManagerFactory("by.it_academy.jd2.hibernate.dao.entity");

        EntityManager entityManager = sessionFactory.createEntityManager();
        entityManager.getTransaction().begin();

        entityManager.persist(event);


        entityManager.getTransaction().commit();


        entityManager.getTransaction().begin();
//
//        entityManager.persist(event);
//
//
//        entityManager.getTransaction().commit();
//        entityManager.close();
    }
}
