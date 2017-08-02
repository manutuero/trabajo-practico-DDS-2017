
package com.utn.dds.javaianos.service;

import com.utn.dds.javaianos.domain.Condicion;


public interface CondicionService {
    public Condicion findCondicionByNombre(String nombre);
    public Condicion findCondicionByCodigo(String codigo);
    public Integer saveCondicion(Condicion condicion);
}
