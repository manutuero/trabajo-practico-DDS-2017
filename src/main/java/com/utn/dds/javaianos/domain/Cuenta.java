package com.utn.dds.javaianos.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cuenta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCuenta;
    private String nombre;
    private String empresa;
    private Double valor;
    private Integer periodo;

    public Long getIdCuenta() {
        return idCuenta;
    }
    
    public Cuenta(){};
    
    public Cuenta(Long idCuenta,String nombre,String empresa, Double valor, Integer periodo){
        this.idCuenta=idCuenta;
        this.nombre=nombre;
        this.empresa=empresa;
        this.valor=valor;
        this.periodo=periodo;
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
      
        //1L;Cuenta prueba 1;facebook;1344345;2017
        return "IdCuenta: "+this.getIdCuenta()+
                ", Nombre: "+this.getNombre()+
                ", Empresa: "+this.getEmpresa()+
                ", Valor: "+(this.getValor()).toString()+
                ", Periodo: "+(this.getPeriodo()).toString()+
                "\n";
    }
}
