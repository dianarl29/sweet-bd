package com.sweetmemories.sweet.dao;


import com.sweetmemories.sweet.models.Parentesco;

import java.util.List;

public interface ParentescoDAO {

    //implementación
    List<Parentesco> getParentesco();

    Parentesco getPariente(int parent_id);

}
