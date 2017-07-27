package com.utn.dds.javaianos.repository;

import com.utn.dds.javaianos.domain.Cotizacion;
import com.utn.dds.javaianos.domain.Cuenta;
import com.utn.dds.javaianos.domain.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CotizacionRepository extends JpaRepository<Cotizacion, Long> {
    public Cotizacion findByCuentaAndEmpresaAndPeriodo(Cuenta cuenta, Empresa empresa, Integer periodo);
}
