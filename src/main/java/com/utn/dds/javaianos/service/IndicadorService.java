package com.utn.dds.javaianos.service;

import com.utn.dds.javaianos.domain.Indicador;
import com.utn.dds.javaianos.parser.ParseException;

public interface IndicadorService {
    
    public Boolean isValidExpression(String expression);
    
    public Boolean allComponentsExists(Indicador indicador);

    public void saveIndicador(Indicador indicador)throws ParseException;
    
    //public Double calcularValor(Indicador indicador);
}
