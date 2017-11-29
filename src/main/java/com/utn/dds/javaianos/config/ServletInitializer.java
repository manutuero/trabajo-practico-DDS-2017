package com.utn.dds.javaianos.config;

import com.utn.dds.javaianos.TpIntegradorDdsApplication;
import com.utn.dds.javaianos.domain.Usuario;
import com.utn.dds.javaianos.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

public class ServletInitializer extends SpringBootServletInitializer {

    @Autowired
    private UsuarioRepository usuarioRepository;
    
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(TpIntegradorDdsApplication.class);
    }
}
