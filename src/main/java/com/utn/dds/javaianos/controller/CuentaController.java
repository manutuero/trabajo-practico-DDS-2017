package com.utn.dds.javaianos.controller;

import com.utn.dds.javaianos.service.CuentaService;
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

    @RequestMapping(value = "/fileUpload", method = RequestMethod.POST)
    public String guardarCuentas(@RequestParam(name = "file") MultipartFile file) 
    {        
        cuentaService.saveCuentas(file);
        return "redirect:/index.jsp";
    }
}
