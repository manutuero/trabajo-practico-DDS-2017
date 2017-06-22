package com.utn.dds.javaianos.service;

import com.utn.dds.javaianos.domain.Cuenta;
import com.utn.dds.javaianos.domain.Empresa;
import com.utn.dds.javaianos.domain.Periodo;
import java.util.List;
import org.springframework.web.multipart.MultipartFile;

public interface CuentaService {
    
    public void saveCuentas(MultipartFile file);
    
    public List<Cuenta> getFilteredCuentas(Empresa empresa, Periodo periodo);
    
    public Double calcularValor(Cuenta cuenta);
}
