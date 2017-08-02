package com.utn.dds.javaianos.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Metodologia implements Serializable {

    @Id
    private String nombre;
    //private List<Condicion> condiciones;
    //@Transient

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
