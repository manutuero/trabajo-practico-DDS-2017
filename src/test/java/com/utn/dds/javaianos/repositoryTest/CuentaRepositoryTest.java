package com.utn.dds.javaianos.repositoryTest;

import com.utn.dds.javaianos.domain.Cotizacion;
import com.utn.dds.javaianos.domain.Cuenta;
import com.utn.dds.javaianos.repository.CotizacionRepository;
import com.utn.dds.javaianos.repository.CuentaRepository;
import javax.transaction.Transactional;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
@Transactional
public class CuentaRepositoryTest {
    
    @Autowired
    private CuentaRepository cuentaRepository;
    
    @Test
    public void findByCodigo_conCuentaExistente_devuelveUnaCuenta() {
        assertNotNull(cuentaRepository.findFirstByCodigo("EBITDA"));
    }

    @Test
    public void findByCodigo_conCuentaNoExistente_devuelveNull() {
        assertNull(cuentaRepository.findFirstByCodigo("cuentaQueNoExiste"));
    }   
}
