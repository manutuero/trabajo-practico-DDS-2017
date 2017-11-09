package com.utn.dds.javaianos.domain;

/*Clase para evaluar una metodologia*/

public class EmpresaValor {

    public EmpresaValor(Empresa empresa, Integer valor) {
        this.empresa = empresa;
        this.valor = valor;
    }

    public Empresa empresa;
    public Integer valor;

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }
    
    public void plusValor(){
        this.valor++;
    }
}