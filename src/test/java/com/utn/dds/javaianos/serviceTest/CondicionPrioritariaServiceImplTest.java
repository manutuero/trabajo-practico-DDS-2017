package com.utn.dds.javaianos.serviceTest;

import com.utn.dds.javaianos.domain.CondicionPrioritaria;
import com.utn.dds.javaianos.repository.CondicionPrioritariaRepository;
import com.utn.dds.javaianos.service.CondicionPrioritariaService;
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
public class CondicionPrioritariaServiceImplTest {
    @Autowired
    CondicionPrioritariaService condicionPrioritariaService;
    
    @Autowired
    CondicionPrioritariaRepository condicionPrioritariaRepo;
    
    @Test
    public void guardarCondicion() {
        CondicionPrioritaria condicion = new CondicionPrioritaria();
        condicion.setCodigo("testPrio");
        condicion.setFormula("IN>2");
        condicion.setNombre("TEsteo");
        

        int resultado = condicionPrioritariaService.saveCondicion(condicion);

        CondicionPrioritaria condicionGuardada = condicionPrioritariaRepo.findByCodigo("testPrio");

        assertEquals("TEsteo", condicionGuardada.getNombre());
        assertEquals("IN>2", condicionGuardada.getFormula());
        assertEquals(0, resultado);
    }
}
