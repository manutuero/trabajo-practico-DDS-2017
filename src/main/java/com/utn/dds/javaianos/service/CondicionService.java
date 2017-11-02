package com.utn.dds.javaianos.service;

import com.utn.dds.javaianos.domain.EmpresaValor;
import com.utn.dds.javaianos.domain.StrategyCondicion;
import java.util.List;

public interface CondicionService {
    public StrategyCondicion findCondicionByNombre(String nombre);
    public StrategyCondicion findCondicionByCodigo(String codigo);
    public Integer saveCondicion(StrategyCondicion condicion);
    public List<StrategyCondicion> getAllCondiciones();
    public List<StrategyCondicion> getCondiciones(List<String> condiciones);
    public Integer eliminarCondicion(String codigo);
    //public void evaluarCondicion(StrategyCondicion condicion, Integer periodo, EmpresaValor empresaValor);
}
