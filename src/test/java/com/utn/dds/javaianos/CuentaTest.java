package com.utn.dds.javaianos;

import com.utn.dds.javaianos.domain.Cuenta;
import com.utn.dds.javaianos.domain.Empresa;
import com.utn.dds.javaianos.service.CotizacionService;
import com.utn.dds.javaianos.service.CuentaService;
import javax.transaction.Transactional;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class CuentaTest {
    
    @Autowired
    CotizacionService cotizacionService;
    
    @Autowired
    CuentaService cuentaService;
    
    @Test
    public void calcularValor_conCotizacionExistente_devuelveValor() {
        Cuenta cuenta = new Cuenta("EBITDA","Earnings Before Interest Taxes Depreciation and Amortization");
        //assertEquals(new Double(14870),cuenta.calcularValor(new Empresa("Facebook"), 2016));
    }
}
