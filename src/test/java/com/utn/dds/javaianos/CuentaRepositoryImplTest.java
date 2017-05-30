package com.utn.dds.javaianos;

import com.utn.dds.javaianos.repository.impl.CuentaRepositoryImpl;
import java.io.File;
import java.io.IOException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;
import javax.script.ScriptException;
import static org.junit.Assert.*;

import org.junit.Test;
@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
@AutoConfigureMockMvc
public class CuentaRepositoryImplTest {

    @Autowired
    private CuentaRepositoryImpl cuentaRepositoryImpl;

    @Test
    public void ejecutarEngine() {
        String cadena = "3+2*(4+5)";
        ScriptEngineManager mgr = new ScriptEngineManager();
        ScriptEngine engine = mgr.getEngineByName("JavaScript");
        int result=0;
        try {
            cadena = engine.eval(cadena).toString();
            double doubleResult = Double.parseDouble(cadena);
            result = (int) doubleResult;
        } catch (ScriptException ex) {}
        assertEquals(21,result);
        
    }

    @Test
    public void saveCuentas_conFormatoValidoYNoVacio_guardaCorrectamenteEnDiscoLocal() throws IOException, Exception {
        MockMultipartFile multipartFile
                = new MockMultipartFile("file", "cuentas.txt", "text/plain", "Esto es una prueba".getBytes());

        String localPath
                = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test" + File.separator + "resources";

        File dir = new File(localPath);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        cuentaRepositoryImpl.saveCuentas(multipartFile);
    }
}
