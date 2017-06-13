package com.utn.dds.javaianos;

import com.utn.dds.javaianos.domain.Indicador;
import com.utn.dds.javaianos.parser.ParseException;
import com.utn.dds.javaianos.repository.IndicadorRepository;
import com.utn.dds.javaianos.service.IndicadorService;
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
public class IndicadorServiceImplTest {
    
    @Autowired
    IndicadorService indicadorService;
    
    @Autowired
    IndicadorRepository indicadorRepository;
        
    @Test
    public void findByNombre_conIndicadorGuardadoEnDb_devuelveIndicador() {
        
        Indicador indicador = (Indicador) indicadorRepository.findByNombre("Ingreso neto");

        assertEquals("Ingreso neto",indicador.getNombre());
        assertEquals("predefinido",indicador.getTipo());
        assertEquals("Ingreso Neto En Operaciones Continuas + Ingreso Neto En Operaciones Discontinuadas",indicador.getFormula());
    }
    
    @Test
    public void isValidFormula_conFormulaNoValida_devuelveFalse() {
       Boolean resultado = indicadorService.isValidExpression("++");       
       assertEquals(false, resultado);
    }
    
    @Test
    public void isValidFormula_conFormulaValida_devuelveTrue() {
       Boolean resultado = indicadorService.isValidExpression("(Cuenta1+Cuenta2)*(500-Cuenta3)");       
       assertEquals(true, resultado);
    }

    @Test
    public void saveIndicador_conFormulaValida_guardaIndicadorEnDb() throws ParseException {
        Indicador indicador = new Indicador();
        indicador.setNombre("I1");
        indicador.setTipo("definido por el usuario");
        indicador.setFormula("C1+C3*10");
        
        indicadorService.saveIndicador(indicador);
        
        Indicador indicadorGuardado = (Indicador) indicadorRepository.findByNombre("I1");
        
        assertEquals("I1",indicadorGuardado.getNombre());
        assertEquals("definido por el usuario",indicadorGuardado.getTipo());
        assertEquals("C1+C3*10",indicadorGuardado.getFormula());
    }
    
    @Test(expected = ParseException.class)
    public void saveIndicador_conFormulaNoValida_lanzaParseExcepcion() throws ParseException {
        Indicador indicador = new Indicador();
        indicador.setNombre("I1");
        indicador.setTipo("definido por el usuario");
        indicador.setFormula("$-*/");
        
        indicadorService.saveIndicador(indicador); // aqui corta la ejecucion        
    }
    
    @Test
    public void allComponentsExists_conComponentesExistentesEnDb_devuelveTrue() {
        Indicador indicador = new Indicador();
        indicador.setNombre("I1");
        indicador.setTipo("definido por el usuario");
        indicador.setFormula("Ingreso Neto En Operaciones Continuas + Ingreso Neto En Operaciones Discontinuadas");
        
        assertEquals(true,indicadorService.allComponentsExists(indicador));
    }
    
   /* @Test
    public void allComponentsExists_conComponentesNoExistentesEnDb_devuelveFalse() {
        Indicador indicador = new Indicador();
        indicador.setNombre("I1");
        indicador.setTipo("definido por el usuario");
        indicador.setFormula("verdura");
        
        assertEquals(false,indicadorService.allComponentsExists(indicador));
    }*/
}
