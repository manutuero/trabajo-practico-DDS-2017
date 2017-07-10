package com.utn.dds.javaianos.serviceTest;

import com.utn.dds.javaianos.domain.Cotizacion;
import com.utn.dds.javaianos.domain.Cuenta;
import com.utn.dds.javaianos.domain.Empresa;
import com.utn.dds.javaianos.repository.CotizacionRepository;
import com.utn.dds.javaianos.service.CotizacionService;
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
public class CotizacionServiceImplTest {

    @Autowired
    CotizacionService cotizacionService;

    @Autowired
    CotizacionRepository cotizacionRepository;

    /* Los test deben hacerse con cuentas y empresas previamente cargadas en la DB, debido a la implementacion de los metodos 
       que utilizan llamadas a objetos. Si no se dispone de estos, se lanza una excepcion del tipo ConstraintViolationException, porque se
       esta violando el constraint UNIQUE en alguno de los campos "cuenta" o "empresa" del objeto cotizacion a cargar */
    @Test
    public void saveCotizaciones_conArchivoValido_guardaCuentasEnDb() throws ParseException, IOException {
        MockMultipartFile file
                = new MockMultipartFile("file", "cotizaciones.csv", "text/plain", ("EBITDA,Facebook,2017,1000\n"
                        + "INOD,Facebook,2017,1000")
                        .getBytes());

        cotizacionService.saveCotizaciones(file);
        assertEquals(6, cotizacionRepository.findAll().size());
    }
}
