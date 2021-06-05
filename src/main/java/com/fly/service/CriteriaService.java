package com.fly.service;

import com.fly.model.Item;
import com.fly.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

@Service
public class CriteriaService {

    @Autowired
    private EntityManager em;

    @Autowired
    private ItemRepository itemRepository;

    public void all() {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Item> cq = builder.createQuery(Item.class);
        Root<Item> root = cq.from(Item.class);
        cq.select(root).where(builder.gt(root.get("price"),1000));

        System.out.println(em.createQuery(cq).getResultList());

    }

    public void save(String name) {
        Item item = new Item(name, 2000d);
        itemRepository.save(item);

    }
}
