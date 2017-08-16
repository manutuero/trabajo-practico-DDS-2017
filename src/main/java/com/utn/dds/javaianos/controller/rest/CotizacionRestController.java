package com.utn.dds.javaianos.controller.rest;

import com.utn.dds.javaianos.domain.Cotizacion;
import com.utn.dds.javaianos.domain.Empresa;
import com.utn.dds.javaianos.service.CotizacionService;
import com.utn.dds.javaianos.service.EmpresaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CotizacionRestController {

    @Autowired
    private CotizacionService cotizacionService;

    @Autowired
    private EmpresaService empresaService;

    @RequestMapping(value = "/api/cotizaciones", method = RequestMethod.POST)
    public List<Cotizacion> devolverCotizaciones(@RequestParam(name = "empresa") String empresa,
            @RequestParam(name = "periodo") Integer periodo) {
        return cotizacionService.getFilteredCotizaciones(new Empresa(empresa), periodo);
    }

    @RequestMapping(value = "/api/cuenta-empresas", method = RequestMethod.GET)
    public List<Empresa> obtenerEmpresas() {
        return empresaService.getAllEmpresas();
    }
}
