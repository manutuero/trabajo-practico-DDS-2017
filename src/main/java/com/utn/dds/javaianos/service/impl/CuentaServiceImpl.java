package com.utn.dds.javaianos.service.impl;

import com.utn.dds.javaianos.domain.Cuenta;
import com.utn.dds.javaianos.domain.Empresa;
import com.utn.dds.javaianos.repository.CuentaRepository;
import com.utn.dds.javaianos.service.CotizacionService;
import com.utn.dds.javaianos.service.CuentaService;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class CuentaServiceImpl implements CuentaService {

    @Autowired
    private CuentaRepository cuentaRepository;

    @Override
    public void saveCuentas(MultipartFile file) {
        try {
            byte[] bytes = file.getBytes();
            String data = new String(bytes);
            String[] rows = data.split("\\n");

            for (String row : rows) {
                StringTokenizer st = new StringTokenizer(row, ",");

                Cuenta cuenta = new Cuenta();
                try {
                    cuenta.setCodigo(st.nextToken());
                    cuenta.setNombre(st.nextToken());
                } catch (NoSuchElementException ex) {
                    cuenta.setNombre(null);
                }
                cuentaRepository.save(cuenta);
            }
        } catch (IOException ex) {
            Logger.getLogger(CuentaServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
//    @Override
//    public List<Cuenta> getFilteredCuentas(Empresa empresa, Periodo periodo)
//    {
//        List<Cuenta> listaCuentas = cuentaRepository.findAll();
//        
//        return listaCuentas.stream().filter(cuenta -> cuenta.getEmpresa().equals(empresa.getNombre()) &&
//                                            cuenta.getPeriodo().equals(periodo.getPeriodo()))
//                                            .collect(Collectors.toList()); 
//    }
//    @Override
//    public Double calcularValor(Cuenta cuenta) {
//        return cuenta.getValor();
//    }
}
