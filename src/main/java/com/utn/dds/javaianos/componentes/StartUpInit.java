package com.utn.dds.javaianos.componentes;

import com.utn.dds.javaianos.service.CotizacionService;
import com.utn.dds.javaianos.service.CuentaService;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StartUpInit {

    @Autowired
    CuentaService cuentaService;
    
    @Autowired
    CotizacionService cotizacionService;

    @PostConstruct
    public void init() {

        try {
            cuentas();
            //cotizaciones();
        } catch (IOException ex) {
            Logger.getLogger(StartUpInit.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void cuentas() throws IOException {
        Path path = Paths.get("C:\\Users\\Ignacio\\Documents\\NetBeansProjects\\TpIntegradorDDS\\src\\main\\resources\\cuentas.csv");
        cuentaService.saveCuentas(path);

    }
    
    public void cotizaciones() throws IOException {
        Path path = Paths.get("C:\\Users\\Ignacio\\Documents\\NetBeansProjects\\TpIntegradorDDS\\src\\main\\resources\\cotizaciones.csv");
        cotizacionService.saveCotizaciones(path);

    }
}
