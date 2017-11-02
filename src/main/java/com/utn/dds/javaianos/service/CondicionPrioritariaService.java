package com.utn.dds.javaianos.service;

import com.utn.dds.javaianos.domain.CondicionPrioritaria;
import com.utn.dds.javaianos.domain.EmpresaValor;
import com.utn.dds.javaianos.domain.StrategyCondicion;
import java.util.List;


public interface CondicionPrioritariaService {
    public CondicionPrioritaria findCondicionByNombre(String nombre);
    public CondicionPrioritaria findCondicionByCodigo(String codigo);
    public Integer saveCondicion(CondicionPrioritaria condicion);
    public List<CondicionPrioritaria> getAllCondiciones();
    public void evaluarCondicion(StrategyCondicion condicion, Integer periodo, EmpresaValor empresaValor);
}
