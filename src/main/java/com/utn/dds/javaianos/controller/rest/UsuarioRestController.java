package com.utn.dds.javaianos.controller.rest;

import com.utn.dds.javaianos.domain.Indicador;
import com.utn.dds.javaianos.domain.Usuario;
import com.utn.dds.javaianos.service.UsuarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsuarioRestController {
    
    @Autowired
    private UsuarioService usuarioService;
    
    @RequestMapping(value = "/api/findUsuario", method = RequestMethod.GET)
    public Usuario obtenerUsuario(@RequestParam(name = "usuario") String usuario) {
        return usuarioService.findByUsuario(usuario);
    }
}
