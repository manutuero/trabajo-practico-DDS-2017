package com.utn.dds.javaianos.controller;

import com.utn.dds.javaianos.domain.Cuenta;
import com.utn.dds.javaianos.service.CuentaService;
import java.util.List;
import javax.servlet.ServletContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class CuentaController {

    @Autowired
    private CuentaService cuentaService;
    
    @Autowired
    private ServletContext servletContext;
    
    public static List<Cuenta> cuentas; // eliminar esta linea cuando tengamos base de datos

    @RequestMapping(value = "/fileUpload", method = RequestMethod.POST)
    public String guardarCuentas(@RequestParam(name = "file") MultipartFile file) {
        String path = servletContext.getRealPath("");
        cuentaService.saveCuentas(file, path);
        cuentas = cuentaService.getAllCuentas(); // eliminar esta linea cuando tengamos base de datos
        return "index";
    }
}
