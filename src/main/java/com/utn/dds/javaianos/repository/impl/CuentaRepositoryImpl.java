package com.utn.dds.javaianos.repository.impl;

import com.utn.dds.javaianos.domain.Cuenta;
import com.utn.dds.javaianos.repository.CuentaRepository;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

@Repository
public class CuentaRepositoryImpl implements CuentaRepository {
    
    private String cuentasPath;
    
    public CuentaRepositoryImpl() {
        String rootPath = System.getProperty("user.dir");
        String relativePath = File.separator + "src" + File.separator + "main" + File.separator + "resources";        
        String absolutePath = rootPath + relativePath;        
        
        File directory = new File(absolutePath);
        cuentasPath = directory.getAbsolutePath();
    }
    
/*
    @Override
    public List<Cuenta> getAllCuentas(MultipartFile file) {
        List<Cuenta> listaCuentas = new ArrayList<>();

        String sCadena;

        BufferedReader bf = null;
        try {
            bf = new BufferedReader(file);
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
        return null;//listaCuentas;
    }
*/
    @Override
    public void saveCuentas(MultipartFile file) {
        if(!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();
                           
                File dir = new File(cuentasPath);                
                if(!dir.exists()) dir.mkdirs();
                
                // crea el archivo en el servidor
                File serverFile = new File(dir.getAbsolutePath() + File.separator + "cuentas.txt");
                
                 /* uso un BufferedOutputStream para mejorar el rendimiento,
                pasandole como argumento un FileOutputStream en su constructor.
                Hago lo mismo con el constructor de FileOutputStream
                pasandole un File (serverFile).*/
                try (BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile))) {
                    stream.write(bytes);
                }
            } catch (IOException ex) {
                 //si falla genera un log en el sistema informando el fallo
                Logger.getLogger(CuentaRepositoryImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
    }

    @Override
    public List<Cuenta> getAllCuentas() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public String getCuentasPath() {
        return this.cuentasPath;
    }
    
    public void setCuentasPath(String path) {
        this.cuentasPath = path;
    }
}
