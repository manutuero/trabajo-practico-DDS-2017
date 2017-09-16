package com.utn.dds.javaianos.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "Metodologia")
public class Metodologia implements Serializable {

    @Id
    @Column(name = "metCodigo")
    private String metCodigo;
    private String descripcion;

    }

    public String getDescripcion() {
        return descripcion;
    }

    public List<StrategyCondicion> getListCondiciones() {
        return listCondiciones;
    }

    public void setmetCodigo(String metCodigo) {
        this.metCodigo = metCodigo;
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

    public void addCondicion(StrategyCondicion condicion){
        this.listCondiciones.add(condicion);
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((metCodigo == null) ? 0 : metCodigo.hashCode());
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
        if (!(obj instanceof Metodologia)) {
            return false;
        }
        Metodologia other = (Metodologia) obj;
        if (metCodigo != other.metCodigo) {
            return false;
        }
        if (descripcion == null) {
            if (other.descripcion != null) {
                return false;
            }
        } else if (!descripcion.equals(other.descripcion)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Metodologia [metCodigo=" + metCodigo + ", descripcion=" + descripcion + "]";
    }

    public void evaluarMetodologia() {
    }
;

}
