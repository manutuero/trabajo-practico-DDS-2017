package com.utn.dds.javaianos.repositoryTest;

import com.utn.dds.javaianos.repository.MetodologiaRepository;
import com.utn.dds.javaianos.repository.UsuarioRepository;
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
public class UsuarioRepositoryTest {
    
    @Autowired
    UsuarioRepository usuarioRepository;
    
    @Test
    public void findByCodigo() {
        assertNotNull(usuarioRepository.findByUsuario("admin"));
    }
}
