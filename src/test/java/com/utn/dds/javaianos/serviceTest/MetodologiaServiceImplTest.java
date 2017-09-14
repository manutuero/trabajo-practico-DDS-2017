package com.utn.dds.javaianos.serviceTest;

import com.utn.dds.javaianos.domain.CondicionTaxativa;
import com.utn.dds.javaianos.domain.Metodologia;
import com.utn.dds.javaianos.domain.StrategyCondicion;
import com.utn.dds.javaianos.repository.MetodologiaRepository;
import com.utn.dds.javaianos.service.MetodologiaService;
import java.util.ArrayList;
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
public class MetodologiaServiceImplTest {
    @Autowired
    MetodologiaService metodologiaService;
    
    @Autowired
    MetodologiaRepository metodologiaRepository;
    
    @Test
    public void guardarMetodologia(){
        Metodologia metodologia = new Metodologia();
        metodologia.setmetCodigo("unCodigo");
        metodologia.setDescripcion("unaDescripcion");
        List<StrategyCondicion> list = new ArrayList<>();
        StrategyCondicion condicion1 = new CondicionTaxativa();
        condicion1.setcondCodigo("C1");
        condicion1.setNombre("cond 1");
        condicion1.setFormula("IN<5");
        list.add(condicion1);
//        List<String> list = new ArrayList<>();
//        list.add("Mayor5");
//        list.add("Menor5");
//        metodologia.setListstrCondiciones(list);
        metodologia.setListCondiciones(list);
        
        int resultado = metodologiaService.saveMetodologia(metodologia);
        
        Metodologia otraMetodologia = new Metodologia();
        otraMetodologia = metodologiaRepository.findByMetCodigo("unCodigo");
        
        assertEquals(resultado,0);
        assertEquals(otraMetodologia.getmetCodigo(),metodologia.getmetCodigo());
        assertEquals(otraMetodologia.getDescripcion(),metodologia.getDescripcion());
        }
    
}
