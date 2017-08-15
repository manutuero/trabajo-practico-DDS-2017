package com.utn.dds.javaianos.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "Metodologia")
public class Metodologia implements Serializable {

    @Id
    private String codigo;
    private String descripcion;
    
    @Transient
    public List<Condicion> listCondiciones;

    public String getCodigo() {
        return codigo;
    }


    public String getDescripcion() {
        return descripcion;
    }

    public List<Condicion> getListCondiciones() {
        return listCondiciones;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }


    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setListCondiciones(List<Condicion> listCondiciones) {
        this.listCondiciones = listCondiciones;
    }

    
    
    public void evaluarMetodologia(){} ;

}
