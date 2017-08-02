package com.utn.dds.javaianos.controller.rest;

import com.utn.dds.javaianos.domain.Condicion;
import com.utn.dds.javaianos.service.CondicionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CondicionRestController {
    
    @Autowired
    private CondicionService condicionService;
    
    @RequestMapping(value = "/api/nueva-condicion", method = RequestMethod.POST)
    public JsonResponse guardarCondicion(@RequestBody Condicion condicion)
    {
        Integer resultado = condicionService.saveCondicion(condicion);
        JsonResponse jsonResponse = new JsonResponse(resultado.toString());
        return jsonResponse;
    }
    
}
