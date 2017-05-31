package com.utn.dds.javaianos.repository.impl;

import com.utn.dds.javaianos.domain.Cuenta;
import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

@Repository
public class CuentaRepositoryImpl  {
    
    
  //  @Override
    public void saveCuentas(MultipartFile file) {
        /*String currentLine;
        Connection cnn;
        String cadena;
        
        File convFile = new File(file.getOriginalFilename());
        PreparedStatement pst;
        ResultSet rs;
        try
        {
            cnn=DriverManager.getConnection("jdbc:hsqldb:mem:dbTest","SA","");
            file.transferTo(convFile);
            
            BufferedReader bufferedReader = new BufferedReader(new FileReader(convFile));
                while ((currentLine = bufferedReader.readLine()) != null)
                {
                    StringTokenizer st = new StringTokenizer(currentLine, ";");
    
                    Cuenta cuenta = new Cuenta();
                    cuenta.setNombre(st.nextToken());
                    cuenta.setEmpresa(st.nextToken());
                    cuenta.setValor(Double.parseDouble(st.nextToken()));
                    cuenta.setPeriodo(Integer.parseInt(st.nextToken()));

                    cadena="INSERT INTO cuenta VALUES("+cuenta.getNombre()+","+cuenta.getEmpresa()+","+cuenta.getPeriodo()+","+cuenta.getValor()+");";
                    
                    pst=cnn.prepareStatement(cadena);
                    pst.clearParameters();
                    rs=pst.executeQuery();
                    
                }
                
            } 
        catch (IOException ex) {
                //si falla genera un log en el sistema informando el fallo
                Logger.getLogger(CuentaRepositoryImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        catch (SQLException e) {
            Logger.getLogger(CuentaRepositoryImpl.class.getName()).log(Level.SEVERE, null, e);
        }*/
        
            
        }
    

    
//    @Override
    public List<Cuenta> getAllCuentas() {
        /*List<Cuenta> cuentas = new ArrayList<>();
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
        */
        return null;
    }
}
