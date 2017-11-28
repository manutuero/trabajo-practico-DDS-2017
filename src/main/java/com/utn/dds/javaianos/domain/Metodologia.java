package com.utn.dds.javaianos.domain;

import java.io.Serializable;
import java.util.ArrayList;
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
    private String condiciones; //atributo con las condiciones como string separados por ;
    private String usuario;

    @Transient
    public List<StrategyCondicion> listCondiciones;

    public Metodologia() {
        this.listCondiciones = new ArrayList();
    }

    public void setCondiciones(String condiciones) {
        this.condiciones = condiciones;
    }

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

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

}
