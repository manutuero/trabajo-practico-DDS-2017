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
    public JsonResponse guardarIndicador(@RequestBody Indicador indicador) {
        Integer resultado = indicadorService.saveIndicador(indicador);
        JsonResponse jsonResponse = new JsonResponse(resultado.toString());
        return jsonResponse;
    } 
}
