package com.utn.dds.javaianos.service.impl;

import com.utn.dds.javaianos.domain.Cotizacion;
import com.utn.dds.javaianos.domain.Cuenta;
import com.utn.dds.javaianos.domain.Empresa;
import com.utn.dds.javaianos.domain.Indicador;
import com.utn.dds.javaianos.parser.ExpressionParser;
import com.utn.dds.javaianos.parser.ParseException;
import com.utn.dds.javaianos.parser.TokenMgrError;
import com.utn.dds.javaianos.repository.CotizacionRepository;
import com.utn.dds.javaianos.repository.CuentaRepository;
import com.utn.dds.javaianos.repository.IndicadorRepository;
import com.utn.dds.javaianos.service.IndicadorService;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class IndicadorServiceImpl implements IndicadorService {

    @Autowired
    private IndicadorRepository indicadorRepository;

    @Autowired
    private CotizacionRepository cotizacionRepository;
    
    @Autowired
    private CuentaRepository cuentaRepository;
    
    @Override
    public Double evaluarIndicador(Indicador indicador, Empresa empresa, Integer periodo) {
        Double valor = 0.0;
        String[] elementos = indicador.getFormula().split("(?<=[-+*/)( ])|(?=[-+*/)( ])");
        String formulaFinal = "";
        Indicador indicadorFormula = null;
        Cotizacion cotizacionFormula = null;
        Cuenta cuenta = null;
        for (String elemento : elementos) {       
           indicadorFormula = null;
           cotizacionFormula = null;
           cuenta=null;
            if ((elemento.matches("([0-9.]+)")) || (elemento.matches("[-+*/()]"))) {
                formulaFinal = formulaFinal + elemento;
            } else //Es un componente. Busco su valor. 
            {
                if(indicadorRepository.findByCodigo(elemento)!=null){
                   indicadorFormula = indicadorRepository.findByCodigo(elemento);
                   valor = this.evaluarIndicador(indicadorFormula,empresa,  periodo);
                } else 
                    cuenta = cuentaRepository.findByCodigo(elemento);
                    if(cotizacionRepository.findByCuentaAndEmpresaAndPeriodo(cuenta, empresa, periodo)!= null) {
                       cotizacionFormula = cotizacionRepository.findByCuentaAndEmpresaAndPeriodo(cuenta, empresa, periodo);
                       valor = cotizacionFormula.getValor();
                    }
                formulaFinal = formulaFinal + valor.toString(); //obtiene el valor en formato string de una cuenta o indicador.
            }
        }
        //System.out.println("Formula final aca: " + formulaFinal);
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("js");
        try {
            valor = (Double) engine.eval(formulaFinal);
        } catch (ScriptException ex) {
            Logger.getLogger(Indicador.class.getName()).log(Level.SEVERE, null, ex);
            valor = 0.0;
        }
        return valor;
    }

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
    
    @Override
    public Indicador findIndicador(String nombre) {
        return indicadorRepository.findByCodigo(nombre);
    }
}
