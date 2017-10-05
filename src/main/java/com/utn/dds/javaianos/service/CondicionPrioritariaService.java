
package com.utn.dds.javaianos.service;

import com.utn.dds.javaianos.domain.CondicionPrioritaria;
import java.util.List;


public interface CondicionPrioritariaService {
    public CondicionPrioritaria findCondicionByNombre(String nombre);
    public CondicionPrioritaria findCondicionByCondCodigo(String codigo);
    public Integer saveCondicion(CondicionPrioritaria condicion);
    public List<CondicionPrioritaria> getAllCondiciones();
}
