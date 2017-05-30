package com.utn.dds.javaianos.service;

import com.utn.dds.javaianos.domain.Cuenta;
import java.util.List;
import org.springframework.web.multipart.MultipartFile;

public interface CuentaService {
    public void saveCuentas(MultipartFile file);
    //public void saveDBCuentas(MultipartFile file);
    public List<Cuenta> getAllCuentas();   
}
