package com.utn.dds.javaianos.repositoryTest;

import com.utn.dds.javaianos.domain.CondicionPrioritaria;
import com.utn.dds.javaianos.repository.CondicionPrioritariaRepository;
import javax.transaction.Transactional;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class CondicionPrioritariaRepositoryTest {

    @Autowired
    CondicionPrioritariaRepository condicionPrioritariaRepository;

    @Test
    public void findByCodigo_conCodigoDeCondicionExistente_devuelveCondicion() {
        assertNotNull(condicionPrioritariaRepository.findByCondCodigo("Menor5"));
    }

    @Test
    public void findByCodigo2_conCodigoDeCondicionExistente_devuelveCondicion() {
        CondicionPrioritaria condicion = condicionPrioritariaRepository.findByCondCodigo("Menor5");
        assertEquals("Menor5", condicion.getCodigo());
    }
}
