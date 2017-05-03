package com.utn.dds.javaianos.controller;
import com.utn.dds.javaianos.domain.Cuenta;
import com.utn.dds.javaianos.service.CuentaService;
import com.utn.dds.javaianos.service.impl.CuentaServiceImpl;
import java.util.List;


public class CuentaController {
    private CuentaService cuentaService=new CuentaServiceImpl();
    public void cargarcuentas(){
        List<Cuenta> listaCuentas = cuentaService.cargarCuentas();
        System.out.println(listaCuentas.toString());
    }
}
