package com.utn.dds.javaianos.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import com.utn.dds.javaianos.service.Componente;

@Entity
@IdClass(CuentaPK.class)
public class Cuenta implements Serializable {

    @Id
    private String nombre;
    @Id
    private String empresa;
    @Id
    private Integer periodo;
    
    private Double valor;
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public Integer getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Integer periodo) {
        this.periodo = periodo;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
}