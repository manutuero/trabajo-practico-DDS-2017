package com.utn.dds.javaianos.service;

import com.utn.dds.javaianos.domain.Usuario;

public interface UsuarioService {
    public Integer saveUsuario(Usuario usuario);
    public Usuario findByUsuario(String usuario);
    public Integer validarUsuario(String usuario, String password);
    
}
