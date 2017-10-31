package com.utn.dds.javaianos.domain;

import com.utn.dds.javaianos.service.IndicadorService;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

@Entity
@DiscriminatorColumn(discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("Prioritaria")
public class CondicionPrioritaria extends StrategyCondicion {

    public CondicionPrioritaria() {
    }

    @Transient
    IndicadorService indicadorService;

    @Override
    public void evaluarCondicion(Integer periodo, EmpresaValor empresaValor) {

        String formulaFinal = "";
        Double valor = 0.0;

        String elementos[] = this.getFormula().split("(?<=[-+*/)( ])|(?>=[-+*/)( ])");
        for (String elemento : elementos) {

            if ((elemento.matches("([0-9.]+)")) || (elemento.matches("<>[-+*/()]"))) {
                formulaFinal = formulaFinal + elemento;
            } else {
                if (indicadorService.findIndicador(elemento) != null) {
                    Indicador indicador = indicadorService.findIndicador(elemento);
                    valor = indicadorService.evaluarIndicador(indicador, empresaValor.getEmpresa(), periodo);
                    formulaFinal = formulaFinal + valor.toString();
                }
            }
        }

        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("js");
        try {
            //valor = (Double) engine.eval(formulaFinal);
            if ((Boolean) engine.eval(formulaFinal)) {
                empresaValor.plusValor();
            }
        } catch (ScriptException ex) {
            Logger.getLogger(CondicionPrioritaria.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
