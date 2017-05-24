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

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
@AutoConfigureMockMvc
public class CuentaRepositoryImplTest {

    @Autowired
    private CuentaRepositoryImpl cuentaRepositoryImpl;

    @Test
    public void saveCuentas_conFormatoValidoYNoVacio_guardaCorrectamente() throws IOException, Exception {
        MockMultipartFile multipartFile
                = new MockMultipartFile("file", "cuentas.txt", "text/plain", "Esto es una prueba".getBytes());
        
        String rootPath = System.getProperty("user.dir");
        String relativePath = File.separator + "src" + File.separator + "test" + File.separator + "resources";        
        String absolutePath = rootPath + relativePath; 
        
        File dir = new File(absolutePath);
        cuentaRepositoryImpl.setCuentasPath(dir.getAbsolutePath());
        cuentaRepositoryImpl.saveCuentas(multipartFile);
    }
}
