package com.utn.dds.javaianos.controller.rest;

import com.utn.dds.javaianos.controller.CuentaController;
import com.utn.dds.javaianos.domain.Cuenta;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller que expone una api y devuelve un JSON
 *
 * @author Manu_
 */
@RestController
public class CuentaRestController { 
    @RequestMapping(value = "/api/valores-cuenta", method = RequestMethod.POST)
    public List<Cuenta> devolverValoresCuentas(@RequestParam(name = "empresa") String empresa,
            @RequestParam(name = "periodo") Integer periodo) {
        
        List<Cuenta> cuentas = new CuentaController().cuentas; // cuando tengamos base de datos se borra esta linea
        
        return cuentas.stream().filter(cuenta -> cuenta.getEmpresa().equals(empresa) && 
                                                 cuenta.getPeriodo().equals(periodo))
                                                .collect(Collectors.toList());
    }
}
