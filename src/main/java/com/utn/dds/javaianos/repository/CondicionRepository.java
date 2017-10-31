
package com.utn.dds.javaianos.repository;

import com.utn.dds.javaianos.domain.StrategyCondicion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CondicionRepository extends JpaRepository<StrategyCondicion, Long>{
    public StrategyCondicion findByNombre(String nombre);
    public StrategyCondicion findByCodigo(String codigo);
}
