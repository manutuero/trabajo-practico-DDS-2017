package com.utn.dds.javaianos.service;

import com.utn.dds.javaianos.domain.Componente;
import com.utn.dds.javaianos.domain.Empresa;

public interface ComponenteService {
    public Double calcularValor(Componente componente, Empresa empresa, Integer periodo);
}
