package com.utn.dds.javaianos.service.impl;

import com.utn.dds.javaianos.domain.CondicionPrioritaria;
import com.utn.dds.javaianos.domain.Cotizacion;
import com.utn.dds.javaianos.domain.Cuenta;
import com.utn.dds.javaianos.domain.EmpresaValor;
import com.utn.dds.javaianos.domain.Indicador;
import com.utn.dds.javaianos.domain.StrategyCondicion;
import com.utn.dds.javaianos.repository.CondicionPrioritariaRepository;
import com.utn.dds.javaianos.repository.CotizacionRepository;
import com.utn.dds.javaianos.repository.CuentaRepository;
import com.utn.dds.javaianos.repository.IndicadorRepository;
import com.utn.dds.javaianos.service.CondicionPrioritariaService;
import com.utn.dds.javaianos.service.IndicadorService;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class CondicionPrioritariaServiceImpl implements CondicionPrioritariaService {

    @Autowired
    private CondicionPrioritariaRepository condicionPrioritariaRepository;

    @Override
    public CondicionPrioritaria findCondicionByNombre(String nombre) {
        return condicionPrioritariaRepository.findByNombre(nombre);
    }

    @Override
    public CondicionPrioritaria findCondicionByCodigo(String codigo) {
        return condicionPrioritariaRepository.findByCodigo(codigo);
    }

    @Override
    public Integer saveCondicion(CondicionPrioritaria condicion) {
        try {
            condicionPrioritariaRepository.save(condicion);
            return 0;
        } catch (Exception e) {
            return 1;
        }
    }

    @Override
    public List<CondicionPrioritaria> getAllCondiciones() {
        return condicionPrioritariaRepository.findAll();
    }

    @Autowired
    IndicadorRepository indicadorRepository;

    @Autowired
    IndicadorService indicadorService;

    @Autowired
    CuentaRepository cuentaRepository;

    @Autowired
    CotizacionRepository cotizacionRepository;

    @Override
    public void evaluarCondicion(StrategyCondicion condicion, Integer periodo, EmpresaValor empresaValor) {
        String formulaFinal = "";
        Double valor = 0.0;
        String elementos[] = condicion.getFormula().split("(?<=[-+*/<>=)( ])|(?=[-+*/<>=)( ])");// <>=
        Indicador indicador = null;
        Cotizacion cotizacionFormula = null;
        Cuenta cuenta = null;

        for (String elemento : elementos) {
            indicador = null;
            cotizacionFormula = null;
            cuenta = null;
            if ((elemento.matches("([0-9.]+)")) || (elemento.matches("[-+*/<>=()]"))) {
                if(elemento.matches("([0-9.]+)")){formulaFinal = formulaFinal + Double.parseDouble(elemento);}
                    else{formulaFinal = formulaFinal + elemento;}
            } else {
                indicador = indicadorRepository.findByCodigo(elemento);
                if (indicador != null) {
                    valor = indicadorService.evaluarIndicador(indicador, empresaValor.getEmpresa(), periodo);
                } else {
                    cuenta = cuentaRepository.findByCodigo(elemento);
                }
                cotizacionFormula = cotizacionRepository.findByCuentaAndEmpresaAndPeriodo(cuenta, empresaValor.getEmpresa(), periodo);
                if (cotizacionFormula != null) {                    
                    valor = cotizacionFormula.getValor();
                }

                formulaFinal = formulaFinal + valor.toString(); //obtiene el valor en formato string de una cuenta o indicador.
                System.out.println(formulaFinal);
            }
        }

        System.out.println("--------------------------------------------///////////////////////");
        System.out.println(formulaFinal);

        if (cumpleCondicion(formulaFinal)) {
            empresaValor.plusValor();
        }

    }

    private Boolean cumpleCondicion(String formulaFinal) {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("js");

        try {
            String terminosFinal[] = formulaFinal.split("(?<=[<>= ])|(?=[<>= ])");
            if (terminosFinal[1].matches("<")) { //If por cada situacion, por ejemplo "123<1000"
                return ((Double) engine.eval(terminosFinal[0])) < ((Double) engine.eval(terminosFinal[2]));
            } else {
                if (terminosFinal[1].matches(">")) {
                    return ((Double) engine.eval(terminosFinal[0])) > ((Double) engine.eval(terminosFinal[2]));
                } else {
                    if (terminosFinal[1].matches("=")) {
                        return ((Double) engine.eval(terminosFinal[0])) == ((Double) engine.eval(terminosFinal[2]));
                    }
                }
            }
        } catch (ScriptException ex) {
            Logger.getLogger(CondicionPrioritaria.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

}
