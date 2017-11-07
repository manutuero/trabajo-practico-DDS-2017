package com.utn.dds.javaianos.controller.rest;

import com.utn.dds.javaianos.domain.Empresa;
import com.utn.dds.javaianos.domain.Indicador;
import com.utn.dds.javaianos.service.EmpresaService;
import com.utn.dds.javaianos.service.IndicadorService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndicadorRestController {

    @Autowired
    private IndicadorService indicadorService;

    @Autowired
    private EmpresaService empresaService;

    @RequestMapping(value = "/api/nuevo-indicador", method = RequestMethod.POST)
    public JsonResponse guardarIndicador(@RequestBody Indicador indicador) {
        Integer resultado = indicadorService.saveIndicador(indicador);
        JsonResponse jsonResponse = new JsonResponse(resultado.toString());
        return jsonResponse;
    }

    @RequestMapping(value = "/api/indicadores", method = RequestMethod.GET)
    public List<Indicador> obtenerIndicadores(String usuario) {
        return indicadorService.getAllIndicadores(usuario);
    }

    @RequestMapping(value = "/api/calcular-indicador", method = RequestMethod.GET)
    public Double obtenerValorIndicador(@RequestParam(name = "anio") Integer anio, @RequestParam(name = "empresa") String nombreEmpresa, @RequestParam(name = "indicador") String codigo) {
        Indicador indicador = indicadorService.findIndicador(codigo);
        Empresa empresa = empresaService.findEmpresa(nombreEmpresa);
        Double resultado = indicadorService.evaluarIndicador(indicador, empresa, anio);
        return resultado;
    }
    
    @RequestMapping(value = "/api/indicador", method = RequestMethod.GET)
    public Indicador obtenerIndicador(@RequestParam(name = "codigo") String codigo) {
        return indicadorService.findIndicador(codigo);
    }
    
    @RequestMapping(value = "/api/eliminar-indicador", method = RequestMethod.POST)
    public Integer eliminarIndicador(@RequestParam(name = "codigo") String codigo) {
        return indicadorService.eliminarIndicador(codigo);
    }
    
    
}
