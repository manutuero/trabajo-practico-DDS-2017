package com.utn.dds.javaianos.service.impl;

import com.utn.dds.javaianos.domain.Indicador;
import com.utn.dds.javaianos.parser.ExpressionParser;
import com.utn.dds.javaianos.parser.ParseException;
import com.utn.dds.javaianos.parser.TokenMgrError;
import com.utn.dds.javaianos.repository.IndicadorRepository;
import com.utn.dds.javaianos.service.IndicadorService;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
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

    @Override
    public void saveIndicador(Indicador indicador) {
    }

    @Override
    public Boolean isValidFormula(String formula) {
        Boolean isValid = false;
        try {
            InputStream stream = new ByteArrayInputStream(formula.getBytes());
            isValid = ExpressionParser.validate(stream);
            
        } catch (ParseException | TokenMgrError ex) {
            System.out.println(ex.getMessage());
        }
        
        return isValid;
    }
}
