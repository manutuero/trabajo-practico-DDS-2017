
package com.utn.dds.javaianos.service;

import com.utn.dds.javaianos.domain.CondicionTaxativa;
import com.utn.dds.javaianos.domain.EmpresaValor;

public interface CondicionTaxativaService {
    public CondicionTaxativa findCondicionByNombre(String nombre);
    public CondicionTaxativa findCondicionByCodigo(String codigo);
    public void evaluarCondicion(CondicionTaxativa condicion, Integer periodo, EmpresaValor empresaValor);
}
