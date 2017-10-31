package com.utn.dds.javaianos.serviceTest;

import com.utn.dds.javaianos.domain.CondicionTaxativa;
import com.utn.dds.javaianos.domain.Metodologia;
import com.utn.dds.javaianos.domain.StrategyCondicion;
import com.utn.dds.javaianos.repository.CondicionTaxativaRepository;
import com.utn.dds.javaianos.repository.MetodologiaRepository;
import com.utn.dds.javaianos.service.MetodologiaService;
import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import static org.junit.Assert.assertEquals;
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
public class MetodologiaServiceImplTest {
    @Autowired
    MetodologiaService metodologiaService;
    
    @Autowired
    MetodologiaRepository metodologiaRepository;
    
    @Autowired
    CondicionTaxativaRepository condicionRepository;
    
    @Test
    public void guardarMetodologia(){
        Metodologia metodologia = new Metodologia();
        metodologia.setCodigo("unCodigo");
        metodologia.setDescripcion("unaDescripcion");
        //genero una condicion
        CondicionTaxativa condicion = new CondicionTaxativa();
        condicion.setCodigo("testTax");
        condicion.setFormula("IN<5");
        condicion.setNombre("TEste");
        //genero otra
        CondicionTaxativa condicion2 = new CondicionTaxativa();
        condicion2.setCodigo("testTax2");
        condicion2.setFormula("IN>5");
        condicion2.setNombre("test");
        //lista de condiciones
        List<StrategyCondicion> lstCond = new ArrayList<>();
        lstCond.add(condicion);
        lstCond.add(condicion2);
        metodologia.setListCondiciones(lstCond);
        metodologia.setCondiciones();
        
        int resultado = metodologiaService.saveMetodologia(metodologia);
        
        Metodologia otraMetodologia = metodologiaRepository.findByCodigo("unCodigo");
        
        assertEquals(resultado,0);
        assertEquals(otraMetodologia.getCodigo(),metodologia.getCodigo());
        assertEquals(otraMetodologia.getDescripcion(),metodologia.getDescripcion());
        assertNotNull(otraMetodologia.getCondiciones());
        }
    
}
