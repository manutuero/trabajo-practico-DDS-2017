
package com.utn.dds.javaianos.service.impl;

import com.utn.dds.javaianos.domain.CondicionPrioritaria;
import com.utn.dds.javaianos.repository.CondicionPrioritariaRepository;
import com.utn.dds.javaianos.service.CondicionPrioritariaService;
import java.util.List;
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
    public CondicionPrioritaria findCondicionByCondCodigo(String codigo) {
        return condicionPrioritariaRepository.findByCondCodigo(codigo);
    }
    
    @Override
    public Integer saveCondicion(CondicionPrioritaria condicion) {
        try
        {
            condicionPrioritariaRepository.save(condicion);
            return 0;
        }
        catch(Exception e)
        {
            return 1;        
        }
        
        
    }
    
    @Override
    public List<CondicionPrioritaria> getAllCondiciones()
    {
        return condicionPrioritariaRepository.findAll();
    }
        
 
    
}
