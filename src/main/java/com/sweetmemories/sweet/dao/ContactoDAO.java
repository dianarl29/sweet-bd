package com.sweetmemories.sweet.dao;

import com.sweetmemories.sweet.models.Contacto;

import java.util.*;

public interface ContactoDAO {

    //implementación
    List<Contacto> getContacto();

    //para eliminar
    void eliminar(int cont_id);

    //para agregar
    void agregarContacto(Contacto contacto);

    //para editar
    void editarParent(Contacto contacto);
}
