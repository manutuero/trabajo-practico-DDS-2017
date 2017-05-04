package com.utn.dds.javaianos.repository.impl;

import com.utn.dds.javaianos.domain.Cuenta;
import com.utn.dds.javaianos.repository.CuentaRepository;
import com.utn.dds.javaianos.service.impl.CuentaServiceImpl;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.stereotype.Repository;

@Repository
public class CuentaRepositoryImpl implements CuentaRepository {

    @Override
    public List<Cuenta> cargarCuentas(String path) {
        List<Cuenta> listaCuentas = new ArrayList<>();

        String sCadena;

        BufferedReader bf = null;
        try {
            bf = new BufferedReader(new FileReader(path));
            while ((sCadena = bf.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(sCadena, ";");

                Cuenta cuenta = new Cuenta();
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
