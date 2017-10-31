package com.utn.dds.javaianos.service.impl;

import com.utn.dds.javaianos.domain.Usuario;
import com.utn.dds.javaianos.repository.UsuarioRepository;
import com.utn.dds.javaianos.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements UsuarioService{

    @Autowired
    private UsuarioRepository usuarioRepository;
    
    @Override
    public Integer saveUsuario(Usuario usuario) {
        try
        {
            
            usuarioRepository.save(usuario);
            
            
            return 0;
        }
        catch(Exception e)
        {
            return 1;
        }
    }

    @Override
    public Usuario findByUsuario(String usuario) {
        return usuarioRepository.findByUsuario(usuario);
    }
    
    @Override
    public Integer validarUsuario(String usuario, String password)
    {
        Integer resultado = 0;
        Usuario user = usuarioRepository.findByUsuario(usuario);
        if(user.getPassword().equals(password))
        {
            resultado = 1;
        }
        
        
        
        return resultado;
    }
    
}
