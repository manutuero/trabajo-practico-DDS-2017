package com.utn.dds.javaianos;

import com.utn.dds.javaianos.domain.Indicador;
import com.utn.dds.javaianos.repository.IndicadorRepository;
import com.utn.dds.javaianos.service.IndicadorService;
import javax.transaction.Transactional;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
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
public class IndicadorServiceImplTest {
    
    @Autowired
    IndicadorService indicadorService;
    
    @Autowired
    IndicadorRepository indicadorRepository;
        
    @Test
    public void findByNombre_conIndicadorGuardadoEnDb_devuelveIndicador() {
        
        Indicador indicador = indicadorRepository.findByNombre("Ingreso neto");

        assertEquals("Ingreso neto",indicador.getNombre());
        assertEquals("predefinido",indicador.getTipo());
        assertEquals("Ingreso Neto En Operaciones Continuas + Ingreso Neto En Operaciones Discontinuadas",indicador.getFormula());
    }
    
    @Test
    public void isValidFormula_llamandoAlParser_devuelveBooleano() {
        
       Boolean resultado = indicadorService.isValidFormula("++");
       
       System.out.println(resultado);
       
       assertTrue(resultado);
    }
}
