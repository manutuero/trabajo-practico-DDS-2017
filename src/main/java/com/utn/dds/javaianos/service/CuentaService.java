package com.utn.dds.javaianos.service;

import org.springframework.web.multipart.MultipartFile;

public interface CuentaService {
    
    public void saveCuentas(MultipartFile file);
    
   // public List<Cuenta> getFilteredCuentas(Empresa empresa, Periodo periodo);
    
   // public Double calcularValor(Cuenta cuenta);
}
