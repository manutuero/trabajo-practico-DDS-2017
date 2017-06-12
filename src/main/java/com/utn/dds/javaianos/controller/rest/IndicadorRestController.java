package com.utn.dds.javaianos.controller.rest;

import com.utn.dds.javaianos.domain.Indicador;
import com.utn.dds.javaianos.service.IndicadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndicadorRestController {
    
    @Autowired
    private IndicadorService indicadorService;
    
    @RequestMapping(value = "/api/nuevo-indicador", method = RequestMethod.POST)
    public void guardarIndicador(@RequestBody Indicador indicador){

        System.out.println("----------------------------------------");
        System.out.println("Nombre: " + indicador.getNombre());
        System.out.println("Tipo :" + indicador.getTipo());
        System.out.println("Formula :" + indicador.getFormula());
        System.out.println("----------------------------------------");
    } 
}
