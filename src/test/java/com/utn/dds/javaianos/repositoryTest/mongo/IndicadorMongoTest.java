package com.utn.dds.javaianos.repositoryTest.mongo;

import com.mongodb.DuplicateKeyException;
import com.utn.dds.javaianos.repository.IndicadorRepositoryMongo;
import javax.transaction.Transactional;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.utn.dds.javaianos.domain.IndicadorMongo;
import static org.junit.Assert.assertEquals;

/**
 *
 * @author Manu_
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class IndicadorMongoTest {

    @Autowired
    private IndicadorRepositoryMongo repository;

    @Test
    public void saveIndicador_conIndicadorValido_guardaCorrectamente() {
   /*     IndicadorMongo indicador = new IndicadorMongo();
        indicador.setId(0);
        indicador.setCodigo("INDICA");
        indicador.setNombre("Un indicador personalizado");
        indicador.setUsuario("admin");
        indicador.setFormula("ALGO+OTRACOSA");

        repository.save(indicador);

        IndicadorMongo indicadorGuardado = repository.findById(0);

        assertEquals("INDICA", indicadorGuardado.getCodigo());
        assertEquals("Un indicador personalizado", indicadorGuardado.getNombre());
        assertEquals("admin", indicadorGuardado.getUsuario());
        assertEquals("ALGO+OTRACOSA", indicadorGuardado.getFormula());*/
    }
}
