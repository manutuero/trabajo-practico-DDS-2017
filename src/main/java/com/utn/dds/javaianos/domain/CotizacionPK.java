package com.utn.dds.javaianos.domain;

import java.io.Serializable;
import javax.persistence.Column;

public class CotizacionPK implements Serializable {

    @Column(name="cuenta", nullable=false)
    private String cuenta;
    @Column(name="empresa", nullable=false)
    private Long empresa;
    @Column(name="periodo", nullable=false)
    private Integer periodo;

    public CotizacionPK() {
    }
    
    public String getCuenta() {
        return cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    public Long getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Long empresa) {
        this.empresa = empresa;
    }

    public Integer getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Integer periodo) {
        this.periodo = periodo;
    }
}
