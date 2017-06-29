package com.utn.dds.javaianos.service;

import com.utn.dds.javaianos.domain.Indicador;

public interface IndicadorService {
    
    public Boolean isValidExpression(String expression);
    
    public Boolean allComponentsExists(Indicador indicador);

    public Integer saveIndicador(Indicador indicador);
    
    public Double calcularValor(Indicador indicador, String empresa, Integer periodo);
}
