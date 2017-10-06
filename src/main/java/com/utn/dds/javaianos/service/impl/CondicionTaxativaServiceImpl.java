
package com.utn.dds.javaianos.service.impl;

import com.utn.dds.javaianos.domain.CondicionTaxativa;
import com.utn.dds.javaianos.repository.CondicionTaxativaRepository;
import com.utn.dds.javaianos.service.CondicionTaxativaService;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class CondicionTaxativaServiceImpl implements CondicionTaxativaService {
    
    @Autowired
    private CondicionTaxativaRepository condicionTaxativaRepository;
    
    @Override
    public CondicionTaxativa findCondicionByNombre(String nombre) {
        return condicionTaxativaRepository.findByNombre(nombre);
    }
    
    @Override
    public CondicionTaxativa findCondicionByCodigo(String codigo) {
        return condicionTaxativaRepository.findByCodigo(codigo);
    }
    
    @Override
    public Integer saveCondicion(CondicionTaxativa condicion) {
        try
        {
            condicionTaxativaRepository.save(condicion);
            return 0;
        }
        catch(Exception e)
        {
            return 1;        
        }
        
        
    }
    
    @Override
    public List<CondicionTaxativa> getAllCondiciones()
    {
        return condicionTaxativaRepository.findAll();
    }
        
 
    
}
