
package com.utn.dds.javaianos.service;

import com.utn.dds.javaianos.domain.CondicionTaxativa;
import java.util.List;


public interface CondicionTaxativaService {
    public CondicionTaxativa findCondicionByNombre(String nombre);
    public CondicionTaxativa findCondicionByCodigo(String codigo);
    public Integer saveCondicion(CondicionTaxativa condicion);
    public List<CondicionTaxativa> getAllCondiciones();
}
