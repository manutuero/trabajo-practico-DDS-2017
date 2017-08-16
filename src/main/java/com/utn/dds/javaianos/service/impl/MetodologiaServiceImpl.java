package com.utn.dds.javaianos.service.impl;

import com.utn.dds.javaianos.domain.CondicionPrioritaria;
import com.utn.dds.javaianos.domain.CondicionTaxativa;
import com.utn.dds.javaianos.domain.Metodologia;
import com.utn.dds.javaianos.repository.CondicionRepository;
import com.utn.dds.javaianos.repository.MetodologiaRepository;
import com.utn.dds.javaianos.service.MetodologiaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MetodologiaServiceImpl implements MetodologiaService {

    @Autowired
    private MetodologiaRepository metodologiaRepository;
    
    @Autowired
    private CondicionRepository condicionTaxativaRepository;
    
    @Autowired
    private CondicionRepository condicionPrioritariaRepository;
    
    @Autowired
    private CondicionRepository condicionRepository;

    @Override
    public Integer saveMetodologia(Metodologia metodologia) {
        
        CondicionTaxativa condTax;
        CondicionPrioritaria condPrio;
                
        try
        {
            metodologiaRepository.save(metodologia);
            
            for(String strcondicion : metodologia.getListstrCondiciones())
            {
                if(condicionTaxativaRepository.findByCodigo(strcondicion)!= null)
                {
                    //condTax = new CondicionTaxativa();
                    condTax = (CondicionTaxativa) condicionTaxativaRepository.findByCodigo(strcondicion);
                    //metodologiaRepository.guardarCondicionesPorMetodologia(condTax.getCodigo(), metodologia.getCodigo());
                }
                else
                {
                    condPrio = (CondicionPrioritaria) condicionPrioritariaRepository.findByCodigo(strcondicion);
                    //metodologiaRepository.guardarCondicionesPorMetodologia(condPrio.getCodigo(), metodologia.getCodigo());
                }
                
                
            }
            
            return 0;
        }
        catch(Exception e)
        {
            return 1;
        }
        
    }

    @Override
    public List<Metodologia> getAllMetodologias() {
        return metodologiaRepository.findAll();
    }
    
    
}
