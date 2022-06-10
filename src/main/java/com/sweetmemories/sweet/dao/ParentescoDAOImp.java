package com.sweetmemories.sweet.dao;


import com.sweetmemories.sweet.models.Parentesco;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class ParentescoDAOImp implements ParentescoDAO{

    //crear objeto de tipo EntityManager
    @PersistenceContext
    EntityManager entityManager;

    //se regresa una lista que tiene todos los parentescos
    @Override
    public List<Parentesco> getParentesco() {

        String query="FROM Parentesco";
        return entityManager.createQuery(query).getResultList();
    }

    //
    @Override
    public Parentesco getPariente(int parent_id) {
        Parentesco parentesco = entityManager.find(Parentesco.class, parent_id);
        return parentesco;
    }
}
