package com.sweetmemories.sweet.controllers;

import com.sweetmemories.sweet.dao.ContactoDAO;
import com.sweetmemories.sweet.models.Contacto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ContactoController{


    //api para mostrar los contactos
    @Autowired
    private ContactoDAO contactoDAO;
    @RequestMapping(value = "contacto", method = RequestMethod.GET)
    public List<Contacto> getContacto() {
        return contactoDAO.getContacto();
    }


    //api para eliminar contacto
    @RequestMapping(value = "contacto/{cont_id}", method = RequestMethod.DELETE)
    public void eliminar(@PathVariable int cont_id) {
        contactoDAO.eliminar(cont_id);
    }


    //api para agregar contacto
    @RequestMapping(value = "contactos",method = RequestMethod.POST)
    public void agregar(@RequestBody Contacto contacto){
        contactoDAO.agregarContacto(contacto);
    }


    //api para editar
    @RequestMapping(value = "editar",method = RequestMethod.POST)
    public void editar(@RequestBody Contacto contacto){ contactoDAO.editarParent(contacto); }

}
