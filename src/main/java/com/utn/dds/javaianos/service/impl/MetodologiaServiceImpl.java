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
import com.utn.dds.javaianos.repository.EmpresaRepository;
import com.utn.dds.javaianos.repository.MetodologiaRepository;
import com.utn.dds.javaianos.service.CondicionPrioritariaService;
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
    private CondicionPrioritariaService condicionPrioritariaService;
    
    
    @Autowired
    private CondicionRepository condicionRepository;

    @Autowired
    private EmpresaRepository empresaRepository;

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
    public List<EmpresaValor> evaluarMetodologia(Metodologia metodologia, Integer periodo) {
        List<Empresa> empresas = new ArrayList<>();
        empresas.addAll(empresaRepository.findAll());
        String[] strCondiciones = metodologia.getCondiciones().split(";");
        for (String strCondicion : strCondiciones) {
            StrategyCondicion condicion = condicionRepository.findByCodigo(strCondicion);
            if(condicion != null){
                metodologia.getListCondiciones().add(condicion);
            }
        }
        List<EmpresaValor> empresasValores = new ArrayList<>();
        for (Empresa empresa : empresas) {
            EmpresaValor empresaValor = new EmpresaValor(empresa, 0);
            for (StrategyCondicion condicion : metodologia.getListCondiciones()) {
                condicionPrioritariaService.evaluarCondicion(condicion,periodo, empresaValor);
            }
            empresasValores.add(empresaValor);
        }

        Collections.sort(empresasValores, new CompareEmpresaValor()); // uso el método sort para ordenar por las condiciones que cumplen(valores)

        return empresasValores;
    }

    @Override
    public Metodologia findMetodologia(String metodologia) {
        return metodologiaRepository.findByCodigo(metodologia);
    }
}

class CompareEmpresaValor implements Comparator<EmpresaValor> {

    @Override
    public int compare(EmpresaValor o1, EmpresaValor o2) {
        return o2.getValor() - o1.getValor();
    }
}
