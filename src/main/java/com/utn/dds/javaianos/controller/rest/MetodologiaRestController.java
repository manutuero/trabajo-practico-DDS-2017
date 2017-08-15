package com.utn.dds.javaianos.controller.rest;

import com.utn.dds.javaianos.domain.Metodologia;
import com.utn.dds.javaianos.service.CondicionService;
import com.utn.dds.javaianos.service.MetodologiaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MetodologiaRestController {
    
    @Autowired
    private MetodologiaService metodologiaService;
    
    @Autowired
    private CondicionService condicionService;

    @RequestMapping(value = "/api/nueva-metodologia", method = RequestMethod.POST)
    public JsonResponse guardarMetodologia(@RequestParam(name= "codigo") String codigo, @RequestParam(name= "descripcion") String descripcion,  @RequestParam(name= "condiciones") List<String> condiciones ) {
        Metodologia metodologia = new Metodologia();
        metodologia.setCodigo(codigo);
        metodologia.setDescripcion(descripcion);
        metodologia.setListCondiciones(condicionService.getCondiciones(condiciones));
        Integer resultado = metodologiaService.saveMetodologia(metodologia);
        JsonResponse jsonResponse = new JsonResponse(resultado.toString());
        return jsonResponse;
    }

    @RequestMapping(value = "/api/metodologias", method = RequestMethod.GET)
    public List<Metodologia> obtenerMetodologias() {
        return metodologiaService.getAllMetodologias();
    }
}
