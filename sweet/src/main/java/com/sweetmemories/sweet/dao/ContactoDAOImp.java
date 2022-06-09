package com.sweetmemories.sweet.dao;

import com.sweetmemories.sweet.models.Contacto;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import java.util.List;

@Repository
@Transactional
public class ContactoDAOImp implements ContactoDAO{

    //crear objeto de tipo EntityManager
    @PersistenceContext
    EntityManager entityManager;

    //se regresa una lista que tiene todos los contactos
    @Override
    public List<Contacto> getContacto() {
        String query="FROM Contacto";
        return entityManager.createQuery(query).getResultList();
    }


    @Override
    public void eliminar(int cont_id) {
        Contacto contacto = entityManager.find(Contacto.class, cont_id);
        entityManager.remove(contacto);
    }

    @Override
    public void agregarContacto(Contacto contacto) {
        entityManager.merge(contacto);
    }

    @Override
    public void editarParent(Contacto contacto) {
        /*int id = contacto.getCont_id();

        Contacto con1 = entityManager.find(Contacto.class,id);

        con1.setParent_id(contacto.getParent_id());*/

        var cont_id = contacto.getCont_id();
        var parent_id = contacto.getParent_id();

        StoredProcedureQuery query= entityManager.createNamedStoredProcedureQuery("editarParent");
        query.setParameter("cont_id", cont_id);
        query.setParameter("parent_id", parent_id);

        query.execute();

    }
}
