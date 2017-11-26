package com.utn.dds.javaianos.controller;

import com.utn.dds.javaianos.service.CotizacionService;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
    public void guardarCotizaciones(@RequestParam(name = "file") MultipartFile file, HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        
         //mensaje para el front
        String message;
        try {
            cotizacionService.saveCotizaciones(file);
            message = "ok";

        } catch (Exception e) {
            message = "nook";
        }
        request.setAttribute("messageCoti", message);
        
        RequestDispatcher requestDispatcher = null;

        requestDispatcher = request.getRequestDispatcher("/WEB-INF/cuentas.jsp");
        requestDispatcher.forward(request, response);
        //  considerar manejar la excepcion que devuelve si trato de insertar una cotizacion ya existente (violacion de PK)
        //return "redirect:/cuentas.jsp";
    }
}
