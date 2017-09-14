package com.utn.dds.javaianos.service.impl;

import com.utn.dds.javaianos.domain.CondicionPrioritaria;
import com.utn.dds.javaianos.domain.CondicionTaxativa;
import com.utn.dds.javaianos.domain.Metodologia;
import com.utn.dds.javaianos.domain.StrategyCondicion;
import com.utn.dds.javaianos.repository.CondicionPrioritariaRepository;
import com.utn.dds.javaianos.repository.CondicionRepository;
import com.utn.dds.javaianos.repository.CondicionTaxativaRepository;
import com.utn.dds.javaianos.repository.MetodologiaRepository;
import com.utn.dds.javaianos.service.MetodologiaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MetodologiaServiceImpl implements MetodologiaService {

    @Autowired
    private MetodologiaRepository metodologiaRepository;

//    @Autowired
//    private CondicionTaxativaRepository condicionTaxativaRepository;
//
//    @Autowired
//    private CondicionPrioritariaRepository condicionPrioritariaRepository;
//
//    @Autowired
//    private CondicionRepository condicionRepository;

//    @Autowired
//    private SessionFactory sessionFactory;

    @Override
    public Integer saveMetodologia(Metodologia metodologia) {

//        CondicionTaxativa condTax;
//        CondicionPrioritaria condPrio;

//        try {
            metodologiaRepository.save(metodologia);

//            for (StrategyCondicion condicion : metodologia.getListCondiciones()) {
//
//                Query query = sessionFactory.getCurrentSession().createQuery("insert into metodologiacondicion(con, stock_name)"
//                                    + "select stock_code, stock_name from backup_stock");
//                int result = query.executeUpdate();
//
//                Query query = sessionFactory.getCurrentSession().createQuery("INSERT INTO metodologiacondicion VALUES (:condicion,:metodologia)");
//                query.setParameter(":condicion", condicion);
//                query.setParameter(":metodologia", metodologia);
//                query.list().get(0);
//
//                if (condicionTaxativaRepository.findByCodigo(condicion.getCodigo()) != null) {
//
//                    condTax = condicionTaxativaRepository.findByCodigo(condicion.getCodigo());
//                    //metodologiaRepository.guardarCondicionesPorMetodologia(condTax.getCodigo(), metodologia.getCodigo());
//                } else {
//                    condPrio = condicionPrioritariaRepository.findByCodigo(condicion.getCodigo());
//                    //metodologiaRepository.guardarCondicionesPorMetodologia(condPrio.getCodigo(), metodologia.getCodigo());
//                }
//            }

            return 0;
//        } catch (Exception e) {
//            return 1;
//        }

    }

    @Override
    public List<Metodologia> getAllMetodologias() {
        return metodologiaRepository.findAll();
    }

}
