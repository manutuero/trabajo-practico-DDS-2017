package com.utn.dds.javaianos.service.impl;

import com.utn.dds.javaianos.domain.CondicionPrioritaria;
import com.utn.dds.javaianos.domain.Cotizacion;
import com.utn.dds.javaianos.domain.Cuenta;
import com.utn.dds.javaianos.domain.EmpresaValor;
import com.utn.dds.javaianos.domain.Indicador;
import com.utn.dds.javaianos.repository.CondicionPrioritariaRepository;
import com.utn.dds.javaianos.repository.CuentaRepository;
import com.utn.dds.javaianos.repository.IndicadorRepository;
import com.utn.dds.javaianos.service.CondicionPrioritariaService;
import com.utn.dds.javaianos.service.CotizacionService;
import com.utn.dds.javaianos.service.IndicadorService;
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

    @Autowired
    IndicadorRepository indicadorRepository;

    @Autowired
    IndicadorService indicadorService;

    @Autowired
    CuentaRepository cuentaRepository;

    @Autowired
    CotizacionService cotizacionService;

    @Override
    public void evaluarCondicion(CondicionPrioritaria condicion, Integer periodo, EmpresaValor empresaValor) {
        String formulaFinal = "";
        Double valor = 0.0;
        String elementos[] = condicion.getFormula().split("(?<=[-+*/<>=)( ])|(?=[-+*/<>=)( ])");
        Indicador indicador = null;
        Cotizacion cotizacionFormula = null;
        Cuenta cuenta = null;

        for (String elemento : elementos) {
            indicador = null;
            cotizacionFormula = null;
            cuenta = null;
            if ((elemento.matches("([0-9.]+)")) || (elemento.matches("[-+*/<>=()]"))) {
                if (elemento.matches("([0-9.]+)")) {
                    formulaFinal = formulaFinal + Double.parseDouble(elemento);
                } else {
                    formulaFinal = formulaFinal + elemento;
                }
            } else {
                indicador = indicadorService.findIndicador(elemento);
                if (indicador != null) {
                    valor = indicadorService.evaluarIndicador(indicador, empresaValor.getEmpresa(), periodo);
                } else {
                    cuenta = cuentaRepository.findByCodigo(elemento);
                }
                cotizacionFormula = cotizacionService.buscarCotizacion(cuenta, empresaValor.getEmpresa(), periodo);
                if (cotizacionFormula != null) {
                    valor = cotizacionFormula.getValor();
                }

                formulaFinal = formulaFinal + valor.toString(); //obtiene el valor en formato string de una cuenta o indicador.
            }
        }

        System.out.println("--------------------------------------------///////////////////////");
        System.out.println(formulaFinal);
        if (cumpleCondicion(formulaFinal)) {
            empresaValor.plusValor();

        }
    }

    public Boolean cumpleCondicion(String formulaFinal) {

        String terminosFinal[] = formulaFinal.split("(?<=[<>= ])|(?=[<>= ])");
        if (terminosFinal[1].matches(">")) { //If por cada situacion, por ejemplo "123<1000"
            return (Double.parseDouble(terminosFinal[0])) > (Double.parseDouble(terminosFinal[2]));
        } else {
            if (terminosFinal[1].matches("<")) {
                return (Double.parseDouble(terminosFinal[0])) < (Double.parseDouble(terminosFinal[2]));
            } else {
                if (terminosFinal[1].matches("=")) {
                    return (Double.parseDouble(terminosFinal[0])) == (Double.parseDouble(terminosFinal[2]));
                }
            }
        }

        return false;
    }
}
