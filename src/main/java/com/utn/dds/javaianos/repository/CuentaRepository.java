package com.utn.dds.javaianos.repository;

import com.utn.dds.javaianos.domain.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CuentaRepository extends JpaRepository<Cuenta, Long>{
    public Cuenta findByNombre(String nombre);
}


