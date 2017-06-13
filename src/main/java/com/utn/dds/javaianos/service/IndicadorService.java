package com.utn.dds.javaianos.service;

import com.utn.dds.javaianos.domain.Indicador;

public interface IndicadorService {

    public void saveIndicador(Indicador indicador);
    
    public Boolean isValidFormula(String formula);
    
    //public Double calcularValor(Indicador indicador);
}
