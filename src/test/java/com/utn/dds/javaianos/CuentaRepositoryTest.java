package com.utn.dds.javaianos;

import com.utn.dds.javaianos.domain.Cuenta;
import com.utn.dds.javaianos.repository.CuentaRepository;
import javax.transaction.Transactional;
import static org.junit.Assert.assertNotNull;
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
    public void findOneByNombre_conCuentaGuardadaEnDb_devuelveUnaCuenta() {
        
        Cuenta cuenta = cuentaRepository.findFirstByNombre("EBITDA");
        
        assertNotNull(cuenta);
    }
    
}
