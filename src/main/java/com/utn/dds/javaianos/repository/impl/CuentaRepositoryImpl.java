package com.utn.dds.javaianos.repository.impl;

import com.utn.dds.javaianos.domain.Cuenta;
import com.utn.dds.javaianos.repository.CuentaRepository;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

@Repository
public class CuentaRepositoryImpl implements CuentaRepository {

    private String cuentasPath;
    
    @Override
    public void saveCuentas(MultipartFile file, String path) {
        if (!file.isEmpty()) {
            try {
                this.cuentasPath = path;
                
                byte[] bytes = file.getBytes();

                // crea el directorio en el arbol de directorios de la aplicacion
                File dir = new File(path + File.separator + "files");
                if (!dir.exists()) {
                    dir.mkdirs();
                }

                // crea el archivo en el servidor
                File serverFile = new File(dir.getAbsoluteFile() + File.separator + "cuentas.txt");

                /* uso un BufferedOutputStream para mejorar el rendimiento,
                pasandole como argumento un FileOutputStream en su constructor.
                Hago lo mismo con el constructor de FileOutputStream
                pasandole un File (serverFile).*/
                try (BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile))) {
                    stream.write(bytes);
                    stream.close();
                }
            } catch (IOException ex) {
                //si falla genera un log en el sistema informando el fallo
                Logger.getLogger(CuentaRepositoryImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public List<Cuenta> getAllCuentas() {
        List<Cuenta> cuentas = new ArrayList<>();
        String currentLine;

        try {
            File file = new File(cuentasPath);
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            while ((currentLine = bufferedReader.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(currentLine, ";");
                
                Cuenta cuenta = new Cuenta();
                cuenta.setIdCuenta(st.nextToken());
                cuenta.setNombre(st.nextToken());
                cuenta.setEmpresa(st.nextToken());
                cuenta.setValor(Double.parseDouble(st.nextToken()));
                cuenta.setPeriodo(Integer.parseInt(st.nextToken()));

                cuentas.add(cuenta);
            }
        } catch (IOException ex) {
            Logger.getLogger(CuentaRepositoryImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cuentas;
    }

    public String getCuentasPath() {
        return this.cuentasPath;
    }

    public void setCuentasPath(String path) {
        this.cuentasPath = path;
    }
}
