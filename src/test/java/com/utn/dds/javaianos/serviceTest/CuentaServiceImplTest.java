package com.utn.dds.javaianos.serviceTest;

import com.utn.dds.javaianos.domain.Cuenta;
import com.utn.dds.javaianos.repository.CuentaRepository;
import com.utn.dds.javaianos.service.CuentaService;
import java.io.IOException;
import java.text.ParseException;
import javax.transaction.Transactional;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
@AutoConfigureMockMvc
@Transactional
public class CuentaServiceImplTest {

    @Autowired
    CuentaService cuentaService;

    @Autowired
    CuentaRepository cuentaRepository;
    
    @Test
    public void saveCuentas_conArchivoValido_guardaCuentasEnDb() throws ParseException, IOException {
        MockMultipartFile multipartFile
                = new MockMultipartFile("file", "cuentas.csv", "text/plain", ("C1\n"
                        + "C2,Cuenta con nombre").getBytes());

        cuentaService.saveCuentas(multipartFile);
        
        Cuenta cuenta1 = cuentaRepository.findFirstByCodigo("C1");
        assertEquals("C1", cuenta1.getCodigo());
        assertNull(cuenta1.getNombre());
        
        Cuenta cuenta2 = cuentaRepository.findFirstByCodigo("C2");
        assertEquals("C2", cuenta2.getCodigo());
        assertEquals("Cuenta con nombre",cuenta2.getNombre());
    }
}