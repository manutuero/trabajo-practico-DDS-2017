
package com.utn.dds.javaianos.service.impl;

import com.utn.dds.javaianos.domain.Condicion;
import com.utn.dds.javaianos.parser.ExpressionParser;
import com.utn.dds.javaianos.parser.ParseException;
import com.utn.dds.javaianos.parser.TokenMgrError;
import com.utn.dds.javaianos.repository.CondicionRepository;
import com.utn.dds.javaianos.service.CondicionService;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Transactional
public class CondicionServiceImpl implements CondicionService {
    
    @Autowired
    private CondicionRepository condicionRepository;
    
    @Override
    public Condicion findCondicionByNombre(String nombre) {
        return condicionRepository.findByNombre(nombre);
    }
    
    @Override
    public Condicion findCondicionByCodigo(String codigo) {
        return condicionRepository.findByCodigo(codigo);
    }
    
    @Override
    public Integer saveCondicion(Condicion condicion) {
        try
        {
            condicionRepository.save(condicion);
            return 0;
        }
        catch(Exception e)
        {
            return 1;        
        }
        
        
    }
    
        
 
    
    
   
}