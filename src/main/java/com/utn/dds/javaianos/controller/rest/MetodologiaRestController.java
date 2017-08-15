package com.utn.dds.javaianos.controller.rest;

import com.utn.dds.javaianos.domain.Condicion;
import com.utn.dds.javaianos.domain.Metodologia;
import com.utn.dds.javaianos.service.MetodologiaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MetodologiaRestController {
    
    @Autowired
    private MetodologiaService metodologiaService;

    @RequestMapping(value = "/api/nueva-metodologia", method = RequestMethod.POST)
    public JsonResponse guardarIndicador(@RequestBody Metodologia metodologia, @RequestBody Condicion condicion) {
        Integer resultado = metodologiaService.saveMetodologia(metodologia);
        JsonResponse jsonResponse = new JsonResponse(resultado.toString());
        return jsonResponse;
    }

    @RequestMapping(value = "/api/metodologias", method = RequestMethod.GET)
    public List<Metodologia> obtenerIndicadores() {
        return metodologiaService.getAllMetodologias();
    }
}
