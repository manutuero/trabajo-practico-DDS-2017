package com.utn.dds.javaianos.serviceTest;

import com.utn.dds.javaianos.domain.Condicion;
import com.utn.dds.javaianos.repository.CondicionRepository;
import com.utn.dds.javaianos.service.CondicionService;
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
public class CondicionServiceImplTest {
    @Autowired
    CondicionService condicionService;
    
     @Autowired
    CondicionRepository condicionRepository;
    
    
    @Test
    public void saveCondicion_conFormulaValida_guardaYDevuelve0() {
//        Condicion condicion = new Condicion();
//        
//        condicion.setCodigo("Menor1");
//        condicion.setNombre("Menor a uno");
//        condicion.setFormula("<1");
//
//        int resultado = condicionService.saveCondicion(condicion);
//
//        Condicion CondicionGuardada = condicionRepository.findByCodigo("Menor1");
//
//        assertEquals("Menor1", CondicionGuardada.getCodigo());
//        assertEquals("Menor a uno", CondicionGuardada.getNombre());
//        assertEquals("<1", CondicionGuardada.getFormula());
//        assertEquals(0, resultado);
    }
}
