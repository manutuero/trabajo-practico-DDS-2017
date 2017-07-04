package com.utn.dds.javaianos.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "Cuenta")
@IdClass(CuentaPK.class)
public class Cuenta implements Serializable , Componente {

    @Id
    private String nombre;
    @Id
    private String empresa;
    @Id
    private Integer periodo;
    
    private Double valor;
    
    public Cuenta() {
    }
    
    public Cuenta(String nombre, String empresa, Integer periodo, Double valor) {
        this.nombre = nombre;
        this.empresa = empresa;
        this.periodo = periodo;
        this.valor = valor;
    }
        
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

    @Override
    public Double calcularValor() {
        return getValor();
    }

    @Override
    public void add(Componente componente) {
        // este es un nodo hoja asi que este metodo no es aplicable para esta clase.
    }

    @Override
    public void remove(Componente componente) {
        // este es un nodo hoja asi que este metodo no es aplicable para esta clase.
    }

    @Override
    public Componente getChild(int i) {
        // este es un nodo hoja asi que este metodo no es aplicable para esta clase.
        return null;
    }


    @Override
    public Double calcularValor(String empresa, Integer periodo) {
       return this.valor;
    }
}