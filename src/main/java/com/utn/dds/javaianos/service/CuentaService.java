package com.utn.dds.javaianos.service;

import com.utn.dds.javaianos.domain.Cuenta;
import java.util.List;

public interface CuentaService {
    public List<Cuenta> cargarCuentas(String path);
}
