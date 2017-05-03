package com.utn.dds.javaianos.service.impl;
import com.utn.dds.javaianos.domain.Cuenta;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import com.utn.dds.javaianos.service.CuentaService;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;


public class CuentaServiceImpl implements CuentaService {
    @Override
    public List<Cuenta> cargarCuentas() {
       final List<Cuenta> listaCuentas = new ArrayList<Cuenta>();
        String sCadena;
       BufferedReader bf = null;
        try {
            bf = new BufferedReader(new FileReader("src\\main\\resources\\cuentas.txt"));
            while ((sCadena = bf.readLine())!=null) {
                //System.out.println(sCadena);
                StringTokenizer st = new StringTokenizer(sCadena,";");
                Cuenta cuenta=new Cuenta();
            
                cuenta.setIdCuenta(st.nextToken());
                cuenta.setNombre(st.nextToken());
                cuenta.setEmpresa(st.nextToken());
                cuenta.setValor(Double.parseDouble(st.nextToken()));
                cuenta.setPeriodo(Integer.parseInt(st.nextToken()));
                listaCuentas.add(cuenta);
                
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CuentaServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CuentaServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                bf.close();
            } catch (IOException ex) {
                Logger.getLogger(CuentaServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    return listaCuentas;
    } 
   
}

