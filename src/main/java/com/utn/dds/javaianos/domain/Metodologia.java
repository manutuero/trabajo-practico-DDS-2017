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
    private String condiciones;

    public void setCondiciones(String condiciones) {
        this.condiciones = condiciones;
    }

    @Transient
    public List<StrategyCondicion> listCondiciones;

    @Transient
    private List<String> liststrCondiciones;

    public void setCondiciones() {
        for (StrategyCondicion condicion : listCondiciones) {
            this.condiciones = this.condiciones + ";" + condicion.getCodigo();
        }
    }

    public String getCondiciones() {
        return condiciones;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public List<StrategyCondicion> getListCondiciones() {
        return listCondiciones;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setListCondiciones(List<StrategyCondicion> listCondiciones) {
        this.listCondiciones = listCondiciones;
    }

    public List<String> getListstrCondiciones() {
        return liststrCondiciones;
    }

    public void setListstrCondiciones(List<String> liststrCondiciones) {
        this.liststrCondiciones = liststrCondiciones;
    }

}
