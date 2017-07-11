package com.utn.dds.javaianos.domain;


public interface Componente {
    public void add(Componente componente);
    public void remove(Componente componente);
    public Componente getChild(int i);
    public Double calcularValor(Empresa empresa, Integer periodo);
}