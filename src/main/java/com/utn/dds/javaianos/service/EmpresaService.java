package com.utn.dds.javaianos.service;

import com.utn.dds.javaianos.domain.Empresa;
import java.util.List;

public interface EmpresaService {
    public Empresa findEmpresa(String nombre);
    public List<Empresa> getAllEmpresas();
}
