package com.utn.dds.javaianos;

import com.utn.dds.javaianos.domain.Indicador;
import com.utn.dds.javaianos.repository.CuentaRepository;
import com.utn.dds.javaianos.repository.IndicadorRepository;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class IndicadorTest {

    @Autowired
    IndicadorRepository indicadorRepository;
    
    @Test
    public void testMethod() {
        
    }

    /*@Test
    public void calcularValor_indicadorValidoSoloCuenta_devuelveValor() {
        Indicador indicador = indicadorRepository.findByNombre("I_TestSoloCuenta");
        Double resultado = indicador.calcularValor("Facebook", 2016);

        assertEquals(new Double(1489000), resultado);
    }*/
}
