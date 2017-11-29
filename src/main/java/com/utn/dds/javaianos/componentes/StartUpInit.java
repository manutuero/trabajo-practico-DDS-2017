package com.utn.dds.javaianos.componentes;

import com.utn.dds.javaianos.service.CotizacionService;
import com.utn.dds.javaianos.service.CuentaService;
import java.nio.file.Path;
import java.nio.file.Paths;
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

        Path path = Paths.get("C:\\Users\\Ignacio\\Documents\\NetBeansProjects\\TpIntegradorDDS\\src\\main\\resources\\cuentas.csv");
        cuentaService.saveCuentas(path);
        
        
        cotizacionService.deleteAll();
        Path path2 = Paths.get("C:\\Users\\Ignacio\\Documents\\NetBeansProjects\\TpIntegradorDDS\\src\\main\\resources\\cotizaciones.csv");
        cotizacionService.saveCotizaciones(path2);
        

    }


}
