package com.utn.dds.javaianos.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public abstract class Condicion implements Serializable {
    
    @Id
    private String codigo;
    private String nombre;
    private String tipo;
    private String formula;

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public String getNombre() {
        return nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getFormula() {
        return formula;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setFormula(String formula) {
        this.formula = formula;
    }
       
    public Condicion(){};
    
    public Condicion (String codigo, String nombre, String formula, String tipo) 
    {
        this.codigo = codigo;
        this.nombre = nombre;
        this.formula = formula;
        this.tipo = tipo;
    }
    
    
    
}
