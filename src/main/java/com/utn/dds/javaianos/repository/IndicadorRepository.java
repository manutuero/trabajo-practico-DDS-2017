package com.utn.dds.javaianos.repository;

import com.utn.dds.javaianos.domain.Indicador;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IndicadorRepository extends JpaRepository<Indicador, String>{
    public Indicador findByCodigo(String codigo);
    public List<Indicador> findByUsuario(String usuario);
}
