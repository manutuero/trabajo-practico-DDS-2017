package com.utn.dds.javaianos.repository;

import com.utn.dds.javaianos.domain.Indicador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IndicadorRepository extends JpaRepository<Indicador, Long>{
    public Indicador findByNombre(String nombre);
}
