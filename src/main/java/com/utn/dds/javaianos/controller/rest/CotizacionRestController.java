package com.utn.dds.javaianos.controller.rest;

import com.utn.dds.javaianos.domain.Cotizacion;
import com.utn.dds.javaianos.domain.Empresa;
import com.utn.dds.javaianos.service.CotizacionService;
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
    
    @RequestMapping(value = "/api/cotizaciones", method = RequestMethod.POST)
    public List<Cotizacion> devolverCotizaciones(@RequestParam(name = "empresa") String empresa,
            @RequestParam(name = "periodo") Integer periodo) {
        return cotizacionService.getFilteredCotizaciones(new Empresa(empresa), periodo);
    }
}
