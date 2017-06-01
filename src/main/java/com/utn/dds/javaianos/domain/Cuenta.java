package com.utn.dds.javaianos.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cuenta implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCuenta;
    private String nombre;
    private String empresa;
    private Double valor;
    private Integer periodo;
    
    public Cuenta(){}
    
    public Long getIdCuenta() {
        return idCuenta;
    }
        
    public void setIdCuenta(Long idCuenta) {
        this.idCuenta = idCuenta;
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

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Integer getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Integer periodo) {
        this.periodo = periodo;
    }

    @Override
    public String toString(){
      
        return "IdCuenta: "+this.getIdCuenta()+
                ", Nombre: "+this.getNombre()+
                ", Empresa: "+this.getEmpresa()+
                ", Valor: "+(this.getValor()).toString()+
                ", Periodo: "+(this.getPeriodo()).toString()+
                "\n";
    }
}