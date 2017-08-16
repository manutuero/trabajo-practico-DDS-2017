package com.utn.dds.javaianos.controller.rest;

import com.utn.dds.javaianos.domain.Empresa;
import com.utn.dds.javaianos.service.EmpresaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmpresaRestController {

    @Autowired
    private EmpresaService empresaService;

    @RequestMapping(value = "/api/empresas", method = RequestMethod.GET)
    public List<Empresa> obtenerEmpresas() {
        return empresaService.getAllEmpresas();
    }
}
