package com.utn.dds.javaianos.repositoryTest;

import com.utn.dds.javaianos.repository.EmpresaRepository;
import javax.transaction.Transactional;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class EmpresaRepositoryTest {
    
    @Autowired
    EmpresaRepository empresaRepository;
    
    @Test
    public void findByNombre_conNombreDeEmpresaExistente_devuelveEmpresa() {
        assertNotNull(empresaRepository.findByNombre("Facebook"));
    }
}
