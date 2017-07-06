package com.utn.dds.javaianos.repository;

import com.utn.dds.javaianos.domain.Metodologia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MetodologiaRepository extends JpaRepository<Metodologia, Long> {
    public Metodologia findByNombre(String nombre);
}
