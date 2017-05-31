package com.utn.dds.javaianos;

import com.utn.dds.javaianos.repository.CuentaRepository;
import com.utn.dds.javaianos.service.CuentaService;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class TestDB {
    
    @Autowired
    CuentaService cuentaService;
    
    @Autowired
    CuentaRepository cuentaRepository; 
    
    @Test
    public void saveCuentas_conMultiPartFileValido_guardaCorrectamente() {
        MockMultipartFile multipartFile
                = new MockMultipartFile("file", "cuentas.txt", "text/plain", "Cuenta prueba 1;Facebook;1344345;2016".getBytes());
        
        cuentaService.saveCuentas(multipartFile);
        assertEquals("Facebook", cuentaRepository.findOne(1L));
        System.out.println("DEVUELVE LA CUENTA DESDE LA BASE CON NOMBRE: " + cuentaRepository.findOne(1L));
    }
}
