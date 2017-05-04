package com.utn.dds.javaianos.service.impl;
import com.utn.dds.javaianos.controller.CuentaController;
import com.utn.dds.javaianos.domain.Cuenta;
import java.util.List;

public class Main {
    private static CuentaController cuentaController = new CuentaController();
   
     public static void main(String[] args) throws Exception {
         List <Cuenta> listaCuentas = cuentaController.cargarcuentas();
         System.out.println(listaCuentas.toString());
     }
}
