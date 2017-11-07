package com.utn.dds.javaianos.repository;

import com.utn.dds.javaianos.domain.CondicionTaxativa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CondicionTaxativaRepository extends JpaRepository<CondicionTaxativa, Long> {

    public CondicionTaxativa findByNombre(String nombre);

    public CondicionTaxativa findByCodigo(String codigo);

    public <List>CondicionTaxativa findByUsuario(String usuario);
}
