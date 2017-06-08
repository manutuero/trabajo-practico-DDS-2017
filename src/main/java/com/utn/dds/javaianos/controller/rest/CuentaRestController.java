package com.utn.dds.javaianos.controller.rest;

import com.utn.dds.javaianos.domain.Cuenta;
import com.utn.dds.javaianos.service.CuentaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CuentaRestController { 
    
    @Autowired
    private CuentaService cuentaService;
    
    @RequestMapping(value = "/api/valores-cuenta", method = RequestMethod.POST)
    public List<Cuenta> devolverValoresCuentas(@RequestParam(name = "empresa") String empresa,
            @RequestParam(name = "periodo") Integer periodo)
    {
        return cuentaService.traerDeterminadasCuentas(empresa, periodo);
     
    }
}
