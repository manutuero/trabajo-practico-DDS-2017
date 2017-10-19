package com.utn.dds.javaianos.repository;

import com.utn.dds.javaianos.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
    public Usuario findByUsuario(String usuario);
}
