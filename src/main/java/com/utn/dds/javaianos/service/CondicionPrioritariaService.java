package com.utn.dds.javaianos.service;

import com.utn.dds.javaianos.domain.CondicionPrioritaria;
import com.utn.dds.javaianos.domain.EmpresaValor;

public interface CondicionPrioritariaService {
    public CondicionPrioritaria findCondicionByNombre(String nombre);
    public CondicionPrioritaria findCondicionByCodigo(String codigo);
    public void evaluarCondicion(CondicionPrioritaria condicion, Integer periodo, EmpresaValor empresaValor);
}
