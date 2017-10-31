
package com.utn.dds.javaianos.service.impl;

import com.utn.dds.javaianos.domain.Empresa;
import com.utn.dds.javaianos.repository.EmpresaRepository;
import com.utn.dds.javaianos.service.EmpresaService;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class EmpresaServiceImpl implements EmpresaService {
    @Autowired
    private EmpresaRepository empresaRepository;
    
    @Override
    public Empresa findEmpresa(String nombre) {
        return empresaRepository.findByNombre(nombre);
    }
   
        @Override
    public List<Empresa> getAllEmpresas() {
        return empresaRepository.findAll();
    }
}
