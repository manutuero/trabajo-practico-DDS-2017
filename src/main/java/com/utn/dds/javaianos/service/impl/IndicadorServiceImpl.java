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
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class IndicadorServiceImpl implements IndicadorService {

    @Autowired
    private IndicadorRepository indicadorRepository;

    @Autowired
    private CuentaRepository cuentaRepository;

//    @Override
//    public Double evaluarIndicador(String codigoIndicador, String empresa, Integer periodo) {
//        Indicador indicador = indicadorRepository.findByNombre(codigoIndicador);
//        List<Componente> componentes = new ArrayList();
//        String[] sComponentes = indicador.getFormula().split("(?<=[-+*/)( ])|(?=[-+*/)( ])");
//        Componente iComponente = null;
//        Componente cComponente = null;
//
//        for (String sComponente : sComponentes) {
//            if (!(sComponente.matches("([0-9.]+)")) || (sComponente.matches("[-+*/()]"))) {
//                iComponente = indicadorRepository.findByNombre(sComponente);
//                //cComponente = ind;
//                if (iComponente != null) {
//                    componentes.add(iComponente);
//                } else if (cComponente != null) {
//                }
//            }
//
//        }
//        indicador.setComponentes(componentes);
//
//        return indicador.calcularValor(empresa, periodo);
//    }

    @Override
    public Integer saveIndicador(Indicador indicador) {
        /* Codigo de resultado:
            0: guardo un nuevo indicador con exito
            1: error, expresion mal formada en la formula del indicador
            2: error, elementos no existentes en la formula del indicador
         */
        if (isValidExpression(indicador.getFormula()) && allComponentsExists(indicador)) {
            indicadorRepository.save(indicador);
            return 0;
        } else if (!isValidExpression(indicador.getFormula())) {
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

        String[] sComponentes = indicador.getFormula().replaceAll("\\(|\\)|[0-9]", "").split("\\+|-|\\*|/");

        Stream<String> stream = Arrays.stream(sComponentes);

        Predicate<String> predicate = (String componente)
                -> (indicadorRepository.findByCodigo(componente) == null)
                && (cuentaRepository.findByCodigo(componente) == null);

        return stream.noneMatch(predicate);
    }

    @Override
    public List<Indicador> getAllIndicadores() {
        return indicadorRepository.findAll();
    }

    public Double evaluarIndicador(String codigoIndicador, String empresa, Integer periodo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
