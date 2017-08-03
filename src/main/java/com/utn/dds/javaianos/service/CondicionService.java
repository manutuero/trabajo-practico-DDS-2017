
package com.utn.dds.javaianos.service;

import com.utn.dds.javaianos.domain.Condicion;
import java.util.List;


public interface CondicionService {
    public Condicion findCondicionByNombre(String nombre);
    public Condicion findCondicionByCodigo(String codigo);
    public Integer saveCondicion(Condicion condicion);
    public List<Condicion> getAllCondiciones();
}
