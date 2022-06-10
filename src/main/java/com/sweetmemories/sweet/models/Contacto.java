package com.sweetmemories.sweet.models;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


//clase contacto que contiene los atributos del contacto en la base de datos


@Entity
@Table(name = "contacto")
@NamedStoredProcedureQuery(name = "editarParent", procedureName = "editarParent", resultClasses = {
        Contacto.class}, parameters = {
        @StoredProcedureParameter(name = "cont_id", type = Integer.class, mode = ParameterMode.IN),
        @StoredProcedureParameter(name = "parent_id", type = Integer.class, mode = ParameterMode.IN)
    }
)
public class Contacto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter @Column(name = "CONT_ID")
    private int cont_id;

    @Getter @Setter @Column(name = "CONT_NOMBRE")
    private String cont_nombre;

    @Getter @Setter @Column(name = "CONT_APELLIDO")
    private String cont_apellido;

    @Getter @Setter @Column(name = "PARENT_ID")
    private int parent_id;

    @Getter @Setter @Column(name = "CONT_FECHA_NACIMIENTO")
    private String cont_fecha_nacimiento;

    @Getter @Setter @Column(name = "CONT_GUSTOS")
    private String cont_gustos;

    @Getter @Setter @Column(name = "CONT_NÚMERO_TELÉFONO")
    private String cont_numero_telefono;

}
