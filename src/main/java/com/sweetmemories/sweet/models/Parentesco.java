package com.sweetmemories.sweet.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

//clase contacto que contiene los atributos del parentesco en la base de datos
@Entity
@Table(name= "parentesco")
@ToString @EqualsAndHashCode
public class Parentesco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter @Column(name = "PARENT_ID")
    private int parent_id;

    @Getter @Setter @Column(name = "PARENT_TIPO")
    private String parent_tipo;
}
