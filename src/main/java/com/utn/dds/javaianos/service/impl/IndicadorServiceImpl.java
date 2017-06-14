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
import java.util.List;
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
    public void saveIndicador(Indicador indicador) throws ParseException {

        // && allComponentsExists(indicador.getFormula())
        if (isValidExpression(indicador.getFormula())) {
            indicadorRepository.save(indicador);
        } else {
            throw new ParseException("Error, la formula ingresada es incorrecta.");
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
        String[] sComponentes = indicador.getFormula().replaceAll("\\(|\\)", "").split("\\+|-|\\*|/");
        Stream<String> oldStream = Arrays.stream(sComponentes);
        Stream<String> componentes = oldStream.map(c -> c.trim());
        
        Predicate<String> predicate = (String componente) -> 
            (indicadorRepository.findByNombre(componente) == null) &&
            (cuentaRepository.findByNombre(componente) == null);
        
        return componentes.noneMatch(predicate);
    }
}
