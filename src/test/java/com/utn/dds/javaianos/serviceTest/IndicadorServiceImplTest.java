package com.utn.dds.javaianos.serviceTest;

import com.utn.dds.javaianos.domain.Empresa;
import com.utn.dds.javaianos.domain.Indicador;
import com.utn.dds.javaianos.repository.IndicadorRepository;
import com.utn.dds.javaianos.service.EmpresaService;
import com.utn.dds.javaianos.service.IndicadorService;
import javax.transaction.Transactional;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
@Transactional
public class IndicadorServiceImplTest {

    @Autowired
    IndicadorService indicadorService;

    @Autowired
    IndicadorRepository indicadorRepository;

    @Autowired
    EmpresaService empresaService;
    
/*    @Test
    public void hello(){}*/

    @Test
    public void isValidFormula_conFormulaNoValida_devuelveFalse() {
        Boolean resultado = indicadorService.isValidExpression("++");
        assertEquals(false, resultado);
    }

    @Test
    public void isValidFormula_conFormulaValida_devuelveTrue() {
        Boolean resultado = indicadorService.isValidExpression("(Cuenta1+Indicador1)*(500-Cuenta2)");
        assertEquals(true, resultado);
    }

    @Test
    public void allComponentsExists_conComponentesNoExistentesEnDb_devuelveFalse() {
        Indicador indicador = new Indicador();
        indicador.setCodigo("I1");
        indicador.setNombre("I1");
        indicador.setUsuario("definido por el usuario");
        indicador.setFormula("(verdura/2)+1");

        assertEquals(false, indicadorService.allComponentsExists(indicador));
    }

    @Test
    public void allComponentsExists_conComponentesExistentesEnDb_devuelveTrue() {
        Indicador indicador = new Indicador();
        indicador.setCodigo("I1");
        indicador.setNombre("I1");
        indicador.setUsuario("definido por el usuario");
        indicador.setFormula("INOC+INOD");

        assertEquals(true, indicadorService.allComponentsExists(indicador));
    }

    @Test
    public void saveIndicador_conFormulaValidaYElementosExistentes_guardaYDevuelve0() {
        Indicador indicador = new Indicador();
        indicador.setCodigo("I1");
        indicador.setNombre("I1");
        indicador.setUsuario("admin");
        indicador.setFormula("INOC");

        int resultado = indicadorService.saveIndicador(indicador);

        Indicador indicadorGuardado = indicadorRepository.findByCodigo("I1");

        assertEquals("I1", indicadorGuardado.getNombre());
        assertEquals("admin", indicadorGuardado.getUsuario());
        assertEquals("INOC", indicadorGuardado.getFormula());
        assertEquals(0, resultado);
    }

    @Test
    public void saveIndicador_conFormulaNoValida_noGuardaYDevuelve1() {
        Indicador indicador = new Indicador();
        indicador.setNombre("I1");
        indicador.setUsuario("definido por el usuario");
        indicador.setFormula("$-*");

        int resultado = indicadorService.saveIndicador(indicador);

        assertEquals(null, indicadorRepository.findByCodigo("I1"));
        assertEquals(1, resultado);
    }

    @Test
    public void saveIndicador_conFormulaValidaYElementosNoExistentes_noGuardaYDevuelve2() {
        Indicador indicador = new Indicador();
        indicador.setNombre("I1");
        indicador.setUsuario("definido por el usuario");
        indicador.setFormula("C1+C3*10");

        int resultado = indicadorService.saveIndicador(indicador);

        assertEquals(null, indicadorRepository.findByCodigo("I1"));
        assertEquals(2, resultado);
    }

    @Test
    public void evaluarIndicador_conIndicadorNuevoFormulaSoloCuentas_devuelveValor() {
        Double valor;
        Indicador indicador = new Indicador();
        indicador.setCodigo("I_TestSoloCuenta");
        indicador.setNombre("I_TestSoloCuenta");
        indicador.setUsuario("definido por el usuario");
        indicador.setFormula("EBITDA*EFG");
        valor = indicadorService.evaluarIndicador(indicador, new Empresa("Facebook"), 2016);
        assertEquals(new Double(14870), valor);
    }

    @Test
    public void evaluarIndicador_conIndicadorNuevoFormulaCuentaEIndicador_devuelveValor() {
        Double valor;
        Indicador indicador = new Indicador();
        indicador.setCodigo("I_Test");
        indicador.setNombre("I_Test");
        indicador.setUsuario("definido por el usuario");
        indicador.setFormula("INETO*INOD+5");
        valor = indicadorService.evaluarIndicador(indicador, new Empresa("Facebook"), 2016);
        assertEquals(new Double(8555), valor);
    }

    @Test
    public void eliminarIndicador() {
        Integer num;

        Indicador indicador = new Indicador();
        indicador.setCodigo("unCodigo");
        indicador.setNombre("I_Test");
        indicador.setUsuario("admin");
        indicador.setFormula("INETO*INOD+5");

        indicadorService.saveIndicador(indicador);

        num = indicadorService.eliminarIndicador("unCodigo");

        assertEquals(num, (Integer) 1);

    }

//    @Test
//    public void getAllIndicadores() {
//        Indicador indicador = new Indicador();
//        indicador.setCodigo("unCodigo");
//        indicador.setNombre("I_Test");
//        indicador.setUsuario("nacho");
//        indicador.setFormula("INETO*INOD+5");
//
//        indicadorService.saveIndicador(indicador);
//
//        List<Indicador> indicadores = indicadorService.getAllIndicadores("nacho");
//        
//        assertEquals(true, indicadores.contains(indicador));
//
//    }
}
