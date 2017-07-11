package com.utn.dds.javaianos.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Cuenta")
public class Cuenta implements Serializable, Componente {

    @Id
    private String codigo;
    private String nombre;
    
    public Cuenta() {
    }
    
    public Cuenta(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
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
    public Double calcularValor(Empresa empresa, Integer periodo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
