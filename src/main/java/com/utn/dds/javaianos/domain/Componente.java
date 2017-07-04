package com.utn.dds.javaianos.domain;

import com.utn.dds.javaianos.repository.CuentaRepository;
import com.utn.dds.javaianos.repository.IndicadorRepository;

public interface Componente {
    
    public Double calcularValor();
    public void add(Componente componente);
    public void remove(Componente componente);
    public Componente getChild(int i);
    public Double calcularValor(String empresa, Integer periodo);
}