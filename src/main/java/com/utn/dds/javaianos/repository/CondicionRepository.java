
package com.utn.dds.javaianos.repository;

import com.utn.dds.javaianos.domain.Condicion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CondicionRepository extends JpaRepository<Condicion, Long>{
    public Condicion findByNombre(String nombre);
    public Condicion findByCodigo(String codigo);
}
