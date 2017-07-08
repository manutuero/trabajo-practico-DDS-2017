package com.utn.dds.javaianos.controller;

import com.utn.dds.javaianos.service.CotizacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class CotizacionController {
    
    @Autowired
    private CotizacionService cotizacionService;
    
    @RequestMapping(value = "/fileUploadCotizaciones", method = RequestMethod.POST)
    public String guardarCotizaciones(@RequestParam(name = "file") MultipartFile file) {
        cotizacionService.saveCotizaciones(file);
        return "redirect:/cuentas.jsp";
    }
}
