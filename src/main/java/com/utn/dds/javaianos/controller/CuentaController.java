package com.utn.dds.javaianos.controller;

import com.utn.dds.javaianos.service.CuentaService;
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
public class CuentaController {

    @Autowired
    private CuentaService cuentaService;

    @RequestMapping(value = "/fileUploadCuentas", method = RequestMethod.POST)
    public void guardarCuentas(@RequestParam(name = "file") MultipartFile file, HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
        cuentaService.saveCuentas(file);

        RequestDispatcher requestDispatcher = null;
        
        requestDispatcher = request.getRequestDispatcher("/WEB-INF/cuentas.jsp");
        requestDispatcher.forward(request, response);

        //return "redirect:/WEB-INF/cuentas.jsp";
    }
}
