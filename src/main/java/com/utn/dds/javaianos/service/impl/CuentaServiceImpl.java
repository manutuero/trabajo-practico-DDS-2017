package com.utn.dds.javaianos.service.impl;
import com.utn.dds.javaianos.domain.Cuenta;
import com.utn.dds.javaianos.repository.CuentaRepository;
import com.utn.dds.javaianos.service.CuentaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/* 
    Realiza la carga desde un archivo dejando una lista de objetos Cuenta en memoria.
    En caso de excepcion genera un archivo log en formato JSON
*/
@Service
public class CuentaServiceImpl implements CuentaService {
    @Autowired
    private CuentaRepository cuentaRepository;
    
    @Override
    public List<Cuenta> cargarCuentas(String path) {
       return cuentaRepository.cargarCuentas(path);
    }
}

