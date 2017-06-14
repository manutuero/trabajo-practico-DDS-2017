package com.utn.dds.javaianos.domain;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;

public class CuentaPK implements Serializable {

    @Column(name="nombre", nullable=false)
    private String nombre;

    @Column(name="empresa", nullable=false)
    private String empresa;

    @Column(name="periodo", nullable=false)
    private Integer periodo;
    
    public CuentaPK() {
    }
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.nombre);
        hash = 37 * hash + Objects.hashCode(this.empresa);
        hash = 37 * hash + Objects.hashCode(this.periodo);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CuentaPK other = (CuentaPK) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.empresa, other.empresa)) {
            return false;
        }
        return Objects.equals(this.periodo, other.periodo);
    }
}
