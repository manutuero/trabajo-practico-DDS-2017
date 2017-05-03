package com.utn.dds.javaianos;

import com.utn.dds.javaianos.service.impl.CuentaServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TpIntegradorDdsApplication {

	public static void main(String[] args) {
            SpringApplication.run(TpIntegradorDdsApplication.class, args);
            System.out.println("hola");	
             //CuentaServiceImpl cuentaServiceimpl=new CuentaServiceImpl();
            //cuentaService.cargarCuentas();
	}
}
