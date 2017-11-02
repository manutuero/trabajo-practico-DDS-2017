package com.utn.dds.javaianos.domain;

import java.util.Comparator;
import java.util.List;

public class EmpresaValor {

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

