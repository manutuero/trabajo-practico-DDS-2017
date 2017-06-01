package com.utn.dds.javaianos;

import com.utn.dds.javaianos.repository.CuentaRepository;
import com.utn.dds.javaianos.service.CuentaService;
import java.io.IOException;
import java.text.ParseException;
import javax.transaction.Transactional;
import static org.junit.Assert.assertEquals;
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
@Transactional
public class CuentaServiceImplTest {

    /*
    @Autowired
    DataSource dataSource;
     
    @Autowired
    JdbcTemplate jdbcTemplate;   
     */
    @Autowired
    CuentaService cuentaService;

    @Autowired
    CuentaRepository cuentaRepository;

    /*
    @Before
    public void setUp() {
        jdbcTemplate.setDataSource(dataSource);
    }*/
    
    @Test
    public void saveCuentas_conMultiPartFileValido_guardaCorrectamenteEnBaseDeDatos() throws ParseException, IOException {
        MockMultipartFile multipartFile
                = new MockMultipartFile("file", "cuentas.txt", "text/plain", ("Cuenta prueba 1;Facebook;1344345;2016\n"
                        + "Cuenta prueba 2;Twitter;1000000;2016").getBytes());

        cuentaService.saveCuentas(multipartFile);

        assertEquals("Facebook", cuentaRepository.findAll().get(0).getEmpresa());
        assertEquals("Twitter", cuentaRepository.findAll().get(1).getEmpresa());
    }
}