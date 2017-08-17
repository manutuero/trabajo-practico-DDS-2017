package com.utn.dds.javaianos.repository;

import com.utn.dds.javaianos.domain.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
    public Empresa findByNombre(String nombre);
}
