package com.utn.dds.javaianos.service.impl;

import com.utn.dds.javaianos.domain.Metodologia;
import com.utn.dds.javaianos.repository.MetodologiaRepository;
import com.utn.dds.javaianos.service.MetodologiaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MetodologiaServiceImpl implements MetodologiaService {

    @Autowired
    private MetodologiaRepository metodologiaRepository;

    @Override
    public Integer saveMetodologia(Metodologia metodologia) {

        try
        {
            metodologiaRepository.save(metodologia);
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
