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
    
    @Override
    public void saveCuentas(MultipartFile file) {
        
        if (!file.isEmpty()) {
            try {                
                byte[] bytes = file.getBytes();

                // crea el directorio en el arbol de directorios del servidor
                File dir = new File("C:"+ File.separator + "fileUpload");
                
                if (!dir.exists()) {
                    dir.mkdirs();
                }
     
                // crea el archivo en el arbol de directorios del servidor         
                File serverFile = new File("C:" + File.separator + "fileUpload" + File.separator + file.getOriginalFilename());
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

    
//    @Override
//    public void saveDBCuentas(MultipartFile file)
//    {
////        String txtFile = file.getOriginalFilename();
////        BufferedReader br = null;
////        String line = "";
////        String cvsSplitBy = ";";
////        Connection con;
////        Statement stmt;
////        String insert;
////
////        try {
////
////            br = new BufferedReader(new FileReader(txtFile));
////            while ((line = br.readLine()) != null) {
////
////                // use comma as separator
////                String[] campos = line.split(cvsSplitBy);
////
////                con = DriverManager.getConnection("jdbc:hsqldb:mem:dbTest","root","root");
////                stmt=(Statement)con.createStatement();
////
////                insert ="INSERT INTO cuenta VALUES('"+campos[0]+"','"+campos[1]+"','"+campos[2]+"','"+campos[3]+"','"+campos[4]+"');";
////                stmt.executeUpdate(insert);
////                
////                
////                //System.out.println("Country [code= " + country[4] + " , name=" + country[5] + "]");
////
////            }
////
////        } 
////        catch (FileNotFoundException e) 
////        {
////           Logger.getLogger(CuentaRepositoryImpl.class.getName()).log(Level.SEVERE, null, e);
////        } 
////        catch (IOException e) 
////        {
////            Logger.getLogger(CuentaRepositoryImpl.class.getName()).log(Level.SEVERE, null, e);
////        }
////        catch(Exception e)
////        {
////         JOptionPane.showMessageDialog(null, e.getMessage() ,"Error", 1);
////
////        }
////        finally
////        {
////            if (br != null)
////            {
////                try 
////                {
////                    br.close();
////                } catch (IOException e) {
////                    e.printStackTrace();
////                }
////            }
////        }
//    }
//    
    
    @Override
    public List<Cuenta> getAllCuentas() {
        List<Cuenta> cuentas = new ArrayList<>();
        String currentLine;

        try {
             File file = new File("C:" + File.separator +"fileUpload" + File.separator + "cuentas.txt");
            
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
}
