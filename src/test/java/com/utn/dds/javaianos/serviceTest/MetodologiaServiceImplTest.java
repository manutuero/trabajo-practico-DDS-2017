package com.utn.dds.javaianos.serviceTest;

import com.utn.dds.javaianos.domain.Metodologia;
import com.utn.dds.javaianos.repository.MetodologiaRepository;
import com.utn.dds.javaianos.service.MetodologiaService;
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
        metodologia.setCodigo("unCodigo");
        metodologia.setDescripcion("unaDescripcion");
        metodologia.setCondiciones("variasCondiciones");
        
        int resultado = metodologiaService.saveMetodologia(metodologia);
        
        Metodologia otraMetodologia = metodologiaRepository.findByCodigo("unCodigo");
        
        assertEquals(resultado,0);
        assertEquals(otraMetodologia.getCodigo(),metodologia.getCodigo());
        assertEquals(otraMetodologia.getDescripcion(),metodologia.getDescripcion());
        }
    
}
