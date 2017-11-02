package com.utn.dds.javaianos.service.impl;

import com.utn.dds.javaianos.domain.CondicionPrioritaria;
import com.utn.dds.javaianos.domain.CondicionTaxativa;
import com.utn.dds.javaianos.domain.Empresa;
import com.utn.dds.javaianos.domain.EmpresaValor;
import com.utn.dds.javaianos.domain.Metodologia;
import com.utn.dds.javaianos.domain.StrategyCondicion;
import com.utn.dds.javaianos.repository.CondicionPrioritariaRepository;
import com.utn.dds.javaianos.repository.CondicionRepository;
import com.utn.dds.javaianos.repository.CondicionTaxativaRepository;
import com.utn.dds.javaianos.repository.MetodologiaRepository;
import com.utn.dds.javaianos.service.MetodologiaService;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MetodologiaServiceImpl implements MetodologiaService {

    @Autowired
    private MetodologiaRepository metodologiaRepository;

    @Autowired
    private CondicionTaxativaRepository condicionTaxativaRepository;

    @Autowired
    private CondicionPrioritariaRepository condicionPrioritariaRepository;

    @Autowired
    private CondicionRepository condicionRepository;

    @Override
    public Integer saveMetodologia(Metodologia metodologia) {

        try {

            metodologiaRepository.save(metodologia);

            return 0;
        } catch (Exception e) {
            return 1;
        }

    }

    @Override
    public List<Metodologia> getAllMetodologias() {
        return metodologiaRepository.findAll();
    }

    @Override
    public List<EmpresaValor> evaluarMetodologia(Metodologia metodologia, List<Empresa> empresas, Integer periodo) {
        List<StrategyCondicion> condiciones = new ArrayList<>();
        String[] strCondiciones = metodologia.getCondiciones().split(";");
        for (String strCondicion : strCondiciones) {
            StrategyCondicion condicion = condicionRepository.findByCodigo(strCondicion);
            condiciones.add(condicion);
        }
        metodologia.setListCondiciones(condiciones);
        List<EmpresaValor> empresasValores = new ArrayList<>();
        for (Empresa empresa : empresas) {

            EmpresaValor empresaValor = new EmpresaValor();
            //List<Boolean> valores = new ArrayList<>();
            empresaValor.setEmpresa(empresa);
            empresaValor.setValor(0);

            for (StrategyCondicion condicion : metodologia.getListCondiciones()) {
                //valores.add(condicion.evaluarCondicion(periodo, empresa));
                condicion.evaluarCondicion(periodo, empresaValor);
            }
            //empresaValor.setValor(valores);

            //String[] terminos = condicion.getFormula().split("<>=");
            empresasValores.add(empresaValor);
        }

        Collections.sort(empresasValores, new CompareEmpresaValor()); // uso el método sort para ordenar por condiciones que cumplen(valores)

        return empresasValores;
    }

    @Override
    public Metodologia findMetodologia(String metodologia) {
        return metodologiaRepository.findByCodigo(metodologia);
    }
}

class CompareEmpresaValor implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {
        int valor1 = ((EmpresaValor) o1).getValor();
        int valor2 = ((EmpresaValor) o2).getValor();
        if (valor1 > valor2) {//ordenamos de mayor a menor
            return -1;
        } else if (valor1 < valor2) {
            return 1;
        } else {
            return 0;
        }

    }
}
