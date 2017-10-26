package com.utn.dds.javaianos.serviceTest;

import com.utn.dds.javaianos.domain.Usuario;
import com.utn.dds.javaianos.repository.UsuarioRepository;
import com.utn.dds.javaianos.service.UsuarioService;
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
public class UsuarioServiceImplTest {

    @Autowired
    UsuarioService usuarioService;
    
    @Autowired
    UsuarioRepository usuarioRepository;

    @Test
    public void guardarUsuario() {
        Usuario unUsuario = new Usuario();
        unUsuario.setUsuario("Juan");
        unUsuario.setPassword("4321");
        
        usuarioService.saveUsuario(unUsuario);
        
        Usuario otroUsuario = usuarioRepository.findByUsuario("Juan");
        assertEquals(otroUsuario.getUsuario(),unUsuario.getUsuario());
        assertEquals(otroUsuario.getPassword(),unUsuario.getPassword());
        
    }
    
    @Test
    public void validarUsuario() {
        Usuario unUsuario = new Usuario();
        unUsuario.setUsuario("Juan");
        unUsuario.setPassword("4321");
        
        usuarioService.saveUsuario(unUsuario);
        
        Integer resultado = usuarioService.validarUsuario("Juan", "4321");
        
        assertEquals(resultado,(Integer)1);
        
        
    }

}
