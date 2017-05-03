package com.utn.dds.javaianos.service.impl;
import com.utn.dds.javaianos.controller.CuentaController;

public class Main {
    private static CuentaController cuentaController=new CuentaController();
   
     public static void main(String[] args) throws Exception {
         cuentaController.cargarcuentas();
     }
}
