package com.utn.dds.javaianos.service;

import com.utn.dds.javaianos.domain.Indicador;
import java.util.List;

public interface IndicadorService {
    
    public Boolean isValidExpression(String expression);
    
    public Boolean allComponentsExists(Indicador indicador);

    public Integer saveIndicador(Indicador indicador);
    
    public List<Indicador> getAllIndicadores();
    
    public Double evaluarIndicador(String codigoIndicador, String empresa, Integer periodo);
}
