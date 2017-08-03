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
    public String codigo;
    public String tipo;
    public String descripcion;
   
    @Transient
    public List<Condicion> listCondiciones;

    public String getCodigo() {
        return codigo;
    }

    public String getTipo() {
        return tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

//    public String getCondiciones() {
//        return condiciones;
//    }

    public List<Condicion> getListCondiciones() {
        return listCondiciones;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

//    public void setCondiciones(String condiciones) {
//        this.condiciones = condiciones;
//    }

    public void setListCondiciones(List<Condicion> listCondiciones) {
        this.listCondiciones = listCondiciones;
    }

    
    
    public void evaluarMetodologia(){} ;

}
