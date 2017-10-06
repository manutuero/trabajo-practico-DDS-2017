package com.utn.dds.javaianos.repository;


import com.utn.dds.javaianos.domain.CondicionPrioritaria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CondicionPrioritariaRepository extends JpaRepository<CondicionPrioritaria, Long>{
    public CondicionPrioritaria findByNombre(String nombre);
    public CondicionPrioritaria findByCodigo(String codigo);
}

