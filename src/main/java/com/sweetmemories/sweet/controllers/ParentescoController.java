package com.sweetmemories.sweet.controllers;

import com.sweetmemories.sweet.dao.ParentescoDAO;
import com.sweetmemories.sweet.models.Parentesco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ParentescoController {

    @Autowired
    private ParentescoDAO parentescoDAO;

    //api que usa el método de getParentesco
    @RequestMapping(value = "parentescos", method = RequestMethod.GET)
    public List<Parentesco> getParentesco(){
        /*List<Parentesco> parentescos = new ArrayList<>();

        Parentesco parent = new Parentesco();
        parent.setParent_id(1);
        parent.setParent_tipo("Primo");

        parentescos.add(parent);*/

        return parentescoDAO.getParentesco();
        //return parentescos;
    }

    //api
    @RequestMapping(value = "pariente/{parent_id}", method = RequestMethod.GET)
    public Parentesco getPaiente(@PathVariable int parent_id){
        return parentescoDAO.getPariente(parent_id);
    }
}
