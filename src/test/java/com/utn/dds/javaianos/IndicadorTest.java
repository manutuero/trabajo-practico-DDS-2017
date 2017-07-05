package com.utn.dds.javaianos;

import com.utn.dds.javaianos.domain.Componente;
import com.utn.dds.javaianos.domain.Cuenta;
import com.utn.dds.javaianos.domain.Indicador;
import com.utn.dds.javaianos.repository.CuentaRepository;
import com.utn.dds.javaianos.repository.IndicadorRepository;

import javax.transaction.Transactional;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
@Transactional

public class IndicadorTest {    
 
    @Autowired
    IndicadorRepository indicadorRepository;
    @Autowired
    CuentaRepository cuentaRepository;
    
    @Test
     public void calcularValor_indicadorValidoSoloCuenta_devuelveValor() {
        Indicador indicador = indicadorRepository.findByNombre("I_TestSoloCuenta");
        System.out.println("Antes de entrar a calcular valor:?????????????????¿¿¿¿¿********");
        Double resultado  = indicador.calcularValor("Facebook",2016);
       
       //System.out.println(indicador.getNombre()+"///////////////////////////////////////---------------");
       assertEquals(new Double(1489000.00),resultado);
     }
}
