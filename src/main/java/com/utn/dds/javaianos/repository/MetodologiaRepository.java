package com.utn.dds.javaianos.repository;

import com.utn.dds.javaianos.domain.Condicion;
import com.utn.dds.javaianos.domain.Metodologia;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MetodologiaRepository extends JpaRepository<Metodologia, Long> {
    //public Metodologia findByNombre(String nombre);
    public Metodologia findByCodigo(String codigo);
    
    //@Query("INSERT INTO MetodologiaCondicion (condicion, metodologia) VALUES (:codCondicion, :codMetodologia)")
    //public void guardarCondicionesPorMetodologia(String codCondicion, String codMetodologia);
    
    
    
}
