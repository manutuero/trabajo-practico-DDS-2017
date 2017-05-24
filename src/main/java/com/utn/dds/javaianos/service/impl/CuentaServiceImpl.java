package com.utn.dds.javaianos.service.impl;
import com.utn.dds.javaianos.domain.Cuenta;
import com.utn.dds.javaianos.repository.CuentaRepository;
import com.utn.dds.javaianos.service.CuentaService;
import java.util.List;
import javax.servlet.ServletContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/* 
    Realiza la carga desde un archivo dejando una lista de objetos Cuenta en memoria.
    En caso de excepcion genera un archivo log en formato JSON
*/
@Service
public class CuentaServiceImpl implements CuentaService {
    @Autowired
    private CuentaRepository cuentaRepository;
    
    @Override
    public void saveCuentas(MultipartFile file, String path) {
       cuentaRepository.saveCuentas(file, path);
       System.out.println("GUARDOOOOOOO!!! pero no se en donde");
    }

    @Override
    public List<Cuenta> getAllCuentas() {
        return cuentaRepository.getAllCuentas();
    }
}

