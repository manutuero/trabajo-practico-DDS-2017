package com.utn.dds.javaianos.service.impl;

import com.utn.dds.javaianos.domain.StrategyCondicion;
import com.utn.dds.javaianos.repository.CondicionRepository;
import com.utn.dds.javaianos.service.CondicionService;
import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class CondicionServiceImpl implements CondicionService {

    @Autowired
    private CondicionRepository condicionRepository;

    @Override
    public StrategyCondicion findCondicionByNombre(String nombre) {
        return condicionRepository.findByNombre(nombre);
    }

    @Override
    public StrategyCondicion findCondicionByCodigo(String codigo) {
        return condicionRepository.findByCodigo(codigo);
    }

    @Override
    public Integer saveCondicion(StrategyCondicion condicion) {
        try {
            condicionRepository.save(condicion);
            return 0;
        } catch (Exception e) {
            return 1;
        }

    }

    @Override
    public List<StrategyCondicion> getAllCondiciones(String usuario) {
        List<StrategyCondicion> condiciones = condicionRepository.findByUsuario("system");
        condiciones.addAll(condicionRepository.findByUsuario(usuario));
        return condiciones;
    }

    @Override
    public List<StrategyCondicion> getCondiciones(List<String> condiciones) {
        List<StrategyCondicion> listCondiciones = new ArrayList<>();
        for (String condicion : condiciones) {
            listCondiciones.add(condicionRepository.findByCodigo(condicion));
        }

        return listCondiciones;
    }

    @Override
    public Integer eliminarCondicion(String codigo) {
        Integer num = 0;

        try {
            condicionRepository.delete(condicionRepository.findByCodigo(codigo));
            num = 1;
        } catch (Exception e) {
            System.out.println(e);
        }

        return num;
    }

}
