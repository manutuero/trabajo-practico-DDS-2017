package com.utn.dds.javaianos.service;

import com.utn.dds.javaianos.domain.Componente;
import com.utn.dds.javaianos.domain.Empresa;

public interface ComponenteService {

    public void add(Componente componente);

    public void remove(Componente componente);

    public Componente getChild(int i);

    public Double calcularValor(Componente componente, Empresa empresa, Integer periodo);
}
