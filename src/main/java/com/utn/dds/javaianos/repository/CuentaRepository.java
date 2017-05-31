package com.utn.dds.javaianos.repository;

import com.utn.dds.javaianos.domain.Cuenta;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.multipart.MultipartFile;

public interface CuentaRepository extends JpaRepository<Cuenta, Long>{    
    
    public void saveCuentas(MultipartFile file);
    
    public List<Cuenta> getAllCuentas();    
}


