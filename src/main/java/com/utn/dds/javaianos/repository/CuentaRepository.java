package com.utn.dds.javaianos.repository;

import com.utn.dds.javaianos.domain.Cuenta;
import java.util.List;

public interface CuentaRepository {
    public List<Cuenta> cargarCuentas();
}
