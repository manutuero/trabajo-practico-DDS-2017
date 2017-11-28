package com.utn.dds.javaianos.service.impl;

import com.utn.dds.javaianos.domain.CondicionPrioritaria;
import com.utn.dds.javaianos.domain.CondicionTaxativa;
import com.utn.dds.javaianos.domain.Empresa;
import com.utn.dds.javaianos.domain.EmpresaValor;
import com.utn.dds.javaianos.domain.Metodologia;
import com.utn.dds.javaianos.domain.StrategyCondicion;
import com.utn.dds.javaianos.repository.CondicionRepository;
import com.utn.dds.javaianos.repository.EmpresaRepository;
import com.utn.dds.javaianos.repository.MetodologiaRepository;
import com.utn.dds.javaianos.service.CondicionPrioritariaService;
import com.utn.dds.javaianos.service.CondicionTaxativaService;
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
    private CondicionPrioritariaService condicionPrioritariaService;

    @Autowired
    private CondicionTaxativaService condicionTaxativaService;

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
    public List<Metodologia> getAllMetodologias(String usuario) {
        List<Metodologia> metodologias = metodologiaRepository.findByUsuario("system");
        metodologias.addAll(metodologiaRepository.findByUsuario(usuario));
        return metodologias;
    }

    @Override
    public Integer eliminarMetodologia(String codigo) {
        Integer num = 0;
        //0 si no se borro, 1 si se borro
        try {
            metodologiaRepository.delete(metodologiaRepository.findByCodigo(codigo));
            num = 1;
        } catch (Exception e) {
            System.out.println(e);
        }

        return num;
    }

    @Override
    public List<EmpresaValor> evaluarMetodologia(Metodologia metodologia, Integer periodo) {
        List<Empresa> empresas = new ArrayList<>();
        empresas.addAll(empresaRepository.findAll());
        String[] strCondiciones = metodologia.getCondiciones().split(";");
        for (String strCondicion : strCondiciones) {
            StrategyCondicion condicion = condicionRepository.findByCodigo(strCondicion);
            if (condicion != null) {
                metodologia.getListCondiciones().add(condicion);
            }
        }
        Integer cantCondiciones = metodologia.getListCondiciones().size();
        System.out.println("--------------------------------------------///////////////////////");
        System.out.println("Condiciones: " + cantCondiciones);
        List<EmpresaValor> empresasValores = new ArrayList<>();
        for (Empresa empresa : empresas) {
            System.out.println("Empresa:" + empresa.getNombre());
            EmpresaValor empresaValor = new EmpresaValor(empresa, 0, true);
            for (StrategyCondicion condicion : metodologia.getListCondiciones()) {
                if (condicionPrioritariaService.findCondicionByCodigo(condicion.getCodigo()) != null) {
                    condicionPrioritariaService.evaluarCondicion((CondicionPrioritaria) condicion, periodo, empresaValor);
                } else {
                    if (condicionTaxativaService.findCondicionByCodigo(condicion.getCodigo()) != null) {
                        condicionTaxativaService.evaluarCondicion((CondicionTaxativa) condicion, periodo, empresaValor);
                    }
                }

            }

            if (empresaValor.getConvieneInvertir() && !(empresasValores.contains(empresaValor))) {
                empresaValor.setValor((empresaValor.getValor() * 100) / cantCondiciones);
                empresasValores.add(empresaValor);
            } else {
                if (!(empresaValor.getConvieneInvertir()) && empresasValores.contains(empresaValor)) {
                    empresasValores.remove(empresaValor);
                }
            }

            // uso el método sort para ordenar por las condiciones que cumplen(valores)
            Collections.sort(empresasValores, new CompareEmpresaValor());

        }
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
        int resultado = Integer.compare(o2.getValor(), o1.getValor());
        if (resultado != 0) {
            return resultado;
        }

        return o1.getEmpresa().getNombre().compareTo(o2.getEmpresa().getNombre());
        //return o2.getValor() - o1.getValor();
    }
}
