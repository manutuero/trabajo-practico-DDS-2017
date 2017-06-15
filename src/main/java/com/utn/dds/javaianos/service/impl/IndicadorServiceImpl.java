package com.utn.dds.javaianos.service.impl;

import com.utn.dds.javaianos.domain.Indicador;
import com.utn.dds.javaianos.parser.ExpressionParser;
import com.utn.dds.javaianos.parser.ParseException;
import com.utn.dds.javaianos.parser.TokenMgrError;
import com.utn.dds.javaianos.repository.CuentaRepository;
import com.utn.dds.javaianos.repository.IndicadorRepository;
import com.utn.dds.javaianos.service.IndicadorService;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.function.Predicate;
import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IndicadorServiceImpl implements IndicadorService {

    @Autowired
    private IndicadorRepository indicadorRepository;
    
    @Autowired
    private CuentaRepository cuentaRepository;
    
    /* @Override
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
    public Integer saveIndicador(Indicador indicador) {
        /* Codigo de resultado:
            0: guardo un nuevo indicador con exito
            1: error, expresion mal formada en la formula del indicador
            2: error, elementos no existentes en la formula del indicador
        */
        if(isValidExpression(indicador.getFormula()) && allComponentsExists(indicador)) {
            indicadorRepository.save(indicador);
            return 0;
        } else if(!isValidExpression(indicador.getFormula())){
            return 1;
        } else {
            return 2;
        }
    }
    
    @Override
    public Boolean isValidExpression(String expression) {
        Boolean isValid = null;
        try {
            InputStream stream = new ByteArrayInputStream(expression.getBytes());
            isValid = ExpressionParser.validate(stream);
        } catch (ParseException | TokenMgrError | NullPointerException ex) {
            System.out.println(ex.getMessage());
        }
        return isValid;
    }

    @Override
    public Boolean allComponentsExists(Indicador indicador) {
        /* En este metodo utilizo Streams de Java 8 y trabajo con conceptos de paradigma funcional */
        // regex: aplico el uso de expresiones regulares para descomponer el String, tambien se usan caracteres de escape (\\)
        // Aclaracion: los numeros son validos en las formulas. Los omitimos ya que siempre seran True.
        String[] sComponentes = indicador.getFormula().replaceAll("\\(|\\)|\\d+", "").split("\\+|-|\\*|/");
        
        Stream<String> oldStream = Arrays.stream(sComponentes);
        Stream<String> componentes = oldStream.map(c -> c.trim());
        
        Predicate<String> predicate = (String componente) -> 
            (indicadorRepository.findByNombre(componente) == null) &&
            (cuentaRepository.findFirstByNombre(componente) == null);
        
        return componentes.noneMatch(predicate);
    }
}
