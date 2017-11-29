package com.utn.dds.javaianos.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "Indicador")
public class Indicador implements Serializable, Componente {

    @Id
    private String codigo;
    private String nombre;
    private String usuario;
    private String formula;
    @Transient
    private List<Componente> componentes;

    public Indicador() {
        this.componentes = new ArrayList();
    }
    
    public Indicador(String codigo, String nombre, String usuario, String formula, List<Componente> componentes) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.usuario = usuario;
        this.formula = formula;
        this.componentes = componentes;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getFormula() {
        return formula;
    }

    public void setFormula(String formula) {
        this.formula = formula;
    }

    public List<Componente> getComponentes() {
        return componentes;
    }

    public void setComponentes(List<Componente> componentes) {
        this.componentes = componentes;
    }

    @Override
    public String toString() {
        return String.format("Indicador[codigo=%s, nombre=%s, usuario=%s, formula=%s]", codigo, nombre, usuario, formula);
    }
}
