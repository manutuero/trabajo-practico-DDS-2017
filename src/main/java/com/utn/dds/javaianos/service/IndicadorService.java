package com.utn.dds.javaianos.service;

import com.utn.dds.javaianos.domain.Empresa;
import com.utn.dds.javaianos.domain.Indicador;
import java.util.List;

public interface IndicadorService {
    public Boolean isValidExpression(String expression);
    public Boolean allComponentsExists(Indicador indicador);
    public Integer saveIndicador(Indicador indicador);
    public List<Indicador> getAllIndicadores();
    public Double evaluarIndicador(Indicador indicador, Empresa empresa, Integer periodo);
    public Indicador findIndicador(String codigo);
    public Integer eliminarIndicador(String codigo);
     
    
}
