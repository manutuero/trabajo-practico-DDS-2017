package com.utn.dds.javaianos.serviceTest;

import com.utn.dds.javaianos.domain.CondicionTaxativa;
import com.utn.dds.javaianos.repository.CondicionTaxativaRepository;
import com.utn.dds.javaianos.service.CondicionService;
import com.utn.dds.javaianos.service.CondicionTaxativaService;
import javax.transaction.Transactional;
import static org.junit.Assert.assertEquals;
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
public class CondicionTaxativaServiceImplTest {
    @Autowired
    CondicionService condicionService;
    
    @Autowired
    CondicionTaxativaRepository condicionTaxativaRepo;
    
    @Test
    public void guardarCondicion() {
        CondicionTaxativa condicion = new CondicionTaxativa();
        condicion.setCodigo("testTax");
        condicion.setFormula("IN<5");
        condicion.setNombre("TEste");
        condicion.setUsuario("system");
        

        int resultado = condicionService.saveCondicion(condicion);

        CondicionTaxativa condicionGuardada = condicionTaxativaRepo.findByCodigo("testTax");

        assertEquals("TEste", condicionGuardada.getNombre());
        assertEquals("IN<5", condicionGuardada.getFormula());
        assertEquals(0, resultado);
    }
    
    
}
