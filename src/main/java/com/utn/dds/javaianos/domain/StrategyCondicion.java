package com.utn.dds.javaianos.domain;

import java.io.Serializable;
import javax.persistence.Column;
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
    @Column(name="condCodigo")
    private String condCodigo;
    private String nombre;
    private String formula;

    public String getNombre() {
        return nombre;
    }

    public String getcondCodigo() {
        return condCodigo;
    }

    public String getFormula() {
        return formula;
    }

    public void setcondCodigo(String condCodigo) {
        this.condCodigo = condCodigo;
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
    
    public StrategyCondicion(String condCodigo, String nombre, String formula) {
        this.condCodigo = condCodigo;
        this.nombre = nombre;
        this.formula = formula;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((condCodigo == null) ? 0 : condCodigo.hashCode());
        result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof StrategyCondicion)) {
            return false;
        }
        StrategyCondicion other = (StrategyCondicion) obj;
        if (condCodigo != other.condCodigo) {
            return false;
        }
        if (nombre == null) {
            if (other.nombre != null) {
                return false;
            }
        } else if (!nombre.equals(other.nombre)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "StrategyCondicion [condCodigo=" + condCodigo + ", nombre=" + nombre + "]";
    }

}
