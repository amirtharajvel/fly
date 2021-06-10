package com.fly.model.multiple;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.Query;

@org.springframework.stereotype.Service
public class Service {

    @Autowired
    private EntityManager entityManager;

    public void getMultipleEntities() {

    }

    public void call() {
        Query query = entityManager.createQuery("SELECT c, s, u FROM Channel c, Subscription s, User u  " +
                " WHERE c.subscriptionId = s.id AND s.id = u.subscriptionId AND u.email = :email");
        query.setParameter("email", "");

        System.out.println(query.getResultList());
    }
}
