package com.utn.dds.javaianos.controller;

import com.utn.dds.javaianos.domain.Cuenta;
import com.utn.dds.javaianos.service.CuentaService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CuentaController {

    @Autowired
    private CuentaService cuentaService;
    public static List<Cuenta> cuentas; // eliminar esta linea cuando tengamos base de datos

    @RequestMapping(value = "/cargar-cuentas", method = RequestMethod.POST)
    public String cargarcuentas(@RequestParam(name = "path") String path) {
        // esto resolveria el requerimiento, segun lo que pide el enunciado (objeto en memoria)
        cuentas = cuentaService.cargarCuentas(path); // cambiar el modo de cambiar el archivo!
        return "index";
    }

    @RequestMapping(value = "/valores-cuenta", method = RequestMethod.POST)
    public String consultarValoresCuentas(Model model,
            @RequestParam(name = "empresa") String empresa,
            @RequestParam(name = "periodo") Integer periodo) {
        
        List<Cuenta> cuentasFiltradas = (List<Cuenta>) cuentas.stream().filter(cuenta -> 
        (cuenta.getEmpresa().equals(empresa) && 
         cuenta.getPeriodo().equals(periodo)))
                .collect(Collectors.toList());
     
        model.addAttribute("cuentas", cuentasFiltradas);
        return "index";
    }
}
