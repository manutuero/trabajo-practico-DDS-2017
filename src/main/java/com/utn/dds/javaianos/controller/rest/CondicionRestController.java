package com.utn.dds.javaianos.controller.rest;

import com.utn.dds.javaianos.domain.Condicion;
import com.utn.dds.javaianos.domain.CondicionPrioritaria;
import com.utn.dds.javaianos.domain.CondicionTaxativa;
import com.utn.dds.javaianos.service.CondicionPrioritariaService;
import com.utn.dds.javaianos.service.CondicionService;
import com.utn.dds.javaianos.service.CondicionTaxativaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CondicionRestController {
    
    @Autowired
    private CondicionService condicionService;
    
    @Autowired
    private CondicionTaxativaService condicionTaxativaService;
    
    @Autowired
    private CondicionPrioritariaService condicionPrioritariaService;
        
    @RequestMapping(value = "/api/nueva-condicion-taxativa", method = RequestMethod.POST)
    public JsonResponse guardarCondicionTaxativa(@RequestBody CondicionTaxativa condicion)
    {
        Integer resultado = condicionTaxativaService.saveCondicion(condicion);
        JsonResponse jsonResponse = new JsonResponse(resultado.toString());
        return jsonResponse;
    }
    
    @RequestMapping(value = "/api/nueva-condicion-prioritaria", method = RequestMethod.POST)
    public JsonResponse guardarCondicionPrioritaria(@RequestBody CondicionPrioritaria condicion)
    {
        Integer resultado = condicionPrioritariaService.saveCondicion(condicion);
        JsonResponse jsonResponse = new JsonResponse(resultado.toString());
        return jsonResponse;
    }
    
    @RequestMapping(value = "/api/condiciones", method = RequestMethod.GET)
    public List<Condicion> obtenerCondiciones() {
        return condicionService.getAllCondiciones();
    }
    
}
