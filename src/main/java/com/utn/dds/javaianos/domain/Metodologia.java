package com.utn.dds.javaianos.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public abstract class Metodologia implements Serializable {

    @Id
    public String nombre;

    public void evaluarMetodologia(){} ;
    
    @Transient
    public List<Condicion> condiciones;

//    public List<Condicion> getCondiciones() {
//        return condiciones;
//    }
//
//    public void setCondiciones(List<Condicion> condiciones) {
//        this.condiciones = condiciones;
//    }
//    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

}
