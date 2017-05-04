package com.utn.dds.javaianos.service.impl;
import com.utn.dds.javaianos.domain.Cuenta;
import com.utn.dds.javaianos.repository.CuentaRepository;
import com.utn.dds.javaianos.repository.impl.CuentaRepositoryImpl;
import com.utn.dds.javaianos.service.CuentaService;
import java.util.List;

/* 
    Realiza la carga desde un archivo dejando una lista de objetos Cuenta en memoria.
    En caso de excepcion genera un archivo log en formato JSON
*/
public class CuentaServiceImpl implements CuentaService {
    private CuentaRepository cuentaRepository = new CuentaRepositoryImpl();
    
    @Override
    public List<Cuenta> cargarCuentas() {
       return cuentaRepository.cargarCuentas();
    }
}

