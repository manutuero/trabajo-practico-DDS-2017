package com.utn.dds.javaianos.service.impl;

import com.utn.dds.javaianos.domain.Indicador;
import com.utn.dds.javaianos.repository.IndicadorRepository;
import com.utn.dds.javaianos.service.IndicadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IndicadorServiceImpl implements IndicadorService {

    @Autowired
    private IndicadorRepository indicadorRepository;

    @Override
    public Boolean isWellComposed(Indicador indicador) {
        
        String[] componentes = indicador.getFormula().split("\\+|-|\\*|/"); // regex non-alphanumeric (con caracteres de escape)
        
        return true;
    }
}
