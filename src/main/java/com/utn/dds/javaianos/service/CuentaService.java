package com.utn.dds.javaianos.service;

import com.utn.dds.javaianos.domain.Cuenta;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;


public interface CuentaService {
    public abstract List<Cuenta> cargarCuentas();
}
