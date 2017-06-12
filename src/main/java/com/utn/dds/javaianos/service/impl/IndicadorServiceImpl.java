package com.utn.dds.javaianos.service.impl;

import com.utn.dds.javaianos.domain.Indicador;
import com.utn.dds.javaianos.repository.IndicadorRepository;
import com.utn.dds.javaianos.service.Componente;
import com.utn.dds.javaianos.service.IndicadorService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IndicadorServiceImpl implements IndicadorService {

    @Autowired
    private IndicadorRepository indicadorRepository;

    
    /*@Override
    public Double calcularValor(Indicador indicador) {
        Double valor = null;
        
        // regex: uso expresiones regulares para descomponer el String con caracteres de escape (\\)
        String[] sComponentes = indicador.getFormula().replaceAll("\\s|\\(|\\)","").split("\\+|-|\\*|/");
        
        List <Componente> componentes = new <Componente> ArrayList();
        
        for(String componente : sComponentes) {
        
        }
        return valor;
    }*/
}
