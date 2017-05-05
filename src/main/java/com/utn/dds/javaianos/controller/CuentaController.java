package com.utn.dds.javaianos.controller;

import com.utn.dds.javaianos.domain.Cuenta;
import com.utn.dds.javaianos.service.CuentaService;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
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

    private List<Cuenta> cuentas = null;

    @RequestMapping(value = "/cargar-cuentas", method = RequestMethod.POST)
    public String cargarcuentas(Model model, @RequestParam(name = "path") String path) {
        // esto resolveria el requerimiento, segun lo que pide el enunciado (objeto en memoria)
        cuentas = cuentaService.cargarCuentas(path);
        cuentas.forEach((cuenta) -> {
            System.out.println(cuenta);
        });
        return "index";
    }

    @RequestMapping(value = "/consultar-valores-cuenta", method = RequestMethod.POST)
    public String consultarValoresCuentas(Model model,
            @RequestParam(name = "empresa") String empresa,
            @RequestParam(name = "periodo") String periodo) {
        
        List<Cuenta> cuentasFiltradas = (List<Cuenta>) cuentas.stream().filter(cuenta -> 
        (cuenta.getEmpresa().equals(empresa)) && cuenta.getPeriodo().equals(Integer.parseInt(periodo))).collect(Collectors.toList());
       
        System.out.println(cuentasFiltradas.size());
        for(Cuenta cuenta:cuentasFiltradas){
            System.out.println(cuenta);
        }
        model.addAttribute("cuentas", cuentasFiltradas);
        return "index";
    }
}
