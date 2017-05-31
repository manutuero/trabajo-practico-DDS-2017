package com.utn.dds.javaianos.service.impl;

import com.utn.dds.javaianos.domain.Cuenta;
import com.utn.dds.javaianos.repository.CuentaRepository;
import com.utn.dds.javaianos.service.CuentaService;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
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

        String currentLine;

        File convFile = new File(file.getOriginalFilename());
        try {
            file.transferTo(convFile);

            BufferedReader bufferedReader = new BufferedReader(new FileReader(convFile));
            while ((currentLine = bufferedReader.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(currentLine, ";");

                Cuenta cuenta = new Cuenta();
                cuenta.setNombre(st.nextToken());
                cuenta.setEmpresa(st.nextToken());
                cuenta.setValor(Double.parseDouble(st.nextToken()));
                cuenta.setPeriodo(Integer.parseInt(st.nextToken()));

                cuentaRepository.save(cuenta);
            }

        } catch (IOException ex) {
            try {
                throw ex;
            } catch (IOException ex1) {
                Logger.getLogger(CuentaServiceImpl.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }

    @Override
    public List<Cuenta> getAllCuentas() {
        return cuentaRepository.getAllCuentas();
    }
}
