package com.utn.dds.javaianos.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name = "Condicion")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo")
public abstract class StrategyCondicion implements Serializable {

    @Id
    private String codigo;
    private String nombre;
    private String formula;
    private String usuario;

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getUsuario() {
        return usuario;
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

    public StrategyCondicion() {
    }

    ;
    
    public StrategyCondicion(String codigo, String nombre, String formula, String usuario) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.formula = formula;
        this.usuario = usuario;
    }

    public abstract void evaluarCondicion(Integer periodo, EmpresaValor empresaValor);

}
