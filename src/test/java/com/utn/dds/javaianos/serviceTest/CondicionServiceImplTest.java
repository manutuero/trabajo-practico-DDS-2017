package com.utn.dds.javaianos.serviceTest;

import com.utn.dds.javaianos.domain.StrategyCondicion;
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
    
    //hacer tests de Taxativas y Prioritarias
     
     
    @Test
    public void saveCondicion_conFormulaValida_guardaYDevuelve0() {
        
    }
    
    @Test
    public void eliminarCondicion_conCodigoDeCondicionExistente_devuelveUno() {
        assertEquals((Integer)1, condicionService.eliminarCondicion("Mayor5"));
    }
}
