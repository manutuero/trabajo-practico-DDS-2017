package com.utn.dds.javaianos.service.impl;

import com.utn.dds.javaianos.domain.Metodologia;
import com.utn.dds.javaianos.repository.MetodologiaRepository;
import com.utn.dds.javaianos.service.MetodologiaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MetodologiaServiceImpl implements MetodologiaService {
//
//    @Autowired
//    private MetodologiaRepository metodologiaRepository;
//
//    @Override
//    public Integer saveMetodologia(Metodologia metodologia) {
//        /* Codigo de resultado:
//            0: guardo un nuevo indicador con exito
//            1: error, expresion mal formada en la formula del indicador
//            2: error, elementos no existentes en la formula del indicador
//         */
//        if (isValidExpression(metodologia.getComponentes()) && allComponentsExists(metodologia)) {
//            metodologiaRepository.save(metodologia);
//            return 0;
//        } else if (!isValidExpression(metodologia.getComponentes())) {
//            return 1;
//        } else {
//            return 2;
//        }
//        return 0;
//    }
//
//    @Override
//    public List<Metodologia> getAllMetodologias() {
//        return metodologiaRepository.findAll();
//    }
}
