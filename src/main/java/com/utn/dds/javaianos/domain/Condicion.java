package com.utn.dds.javaianos.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "Condicion")
public class Condicion implements Serializable {
    
    @Id
    private String codigo;
    private String nombre;
    private String formula;
    
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
    
    public Condicion (String codigo, String nombre, String formula) 
    {
        this.codigo = codigo;
        this.nombre = nombre;
        this.formula = formula;
    }
    
    
    
}
