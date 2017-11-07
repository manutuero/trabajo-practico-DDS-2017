package com.utn.dds.javaianos.repositoryTest;

import com.utn.dds.javaianos.domain.Indicador;
import com.utn.dds.javaianos.repository.IndicadorRepository;
import java.util.List;
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
public class IndicadorRepositoryTest {
    
    @Autowired
    private IndicadorRepository indicadorRepository;
    
    @Test
    public void findByCodigo_conIndicadorGuardadoEnDb_devuelveIndicador() {
        
        Indicador indicador = indicadorRepository.findByCodigo("INETO");

        assertEquals("Ingreso neto",indicador.getNombre());
        assertEquals("system",indicador.getUsuario());
        assertEquals("INOC+INOD",indicador.getFormula());
    }
    
    @Test
    public void findByUsuario() {
        
        List<Indicador> indicadores = indicadorRepository.findByUsuario("nacho");

        assertEquals(false,indicadores.isEmpty());
       
    }
}
