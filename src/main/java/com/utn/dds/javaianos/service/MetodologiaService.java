package com.utn.dds.javaianos.service;

import com.utn.dds.javaianos.domain.EmpresaValor;
import com.utn.dds.javaianos.domain.Metodologia;
import java.util.List;

public interface MetodologiaService {

    public Integer saveMetodologia(Metodologia metodologia);
    public List<Metodologia> getAllMetodologias();
    public List<EmpresaValor> evaluarMetodologia(Metodologia metodologia,Integer periodo);
    public Metodologia findMetodologia(String metodologia);
    
}
