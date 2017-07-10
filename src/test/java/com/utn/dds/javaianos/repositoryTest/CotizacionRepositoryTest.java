package com.utn.dds.javaianos.repositoryTest;

import com.utn.dds.javaianos.domain.Cotizacion;
import com.utn.dds.javaianos.domain.Cuenta;
import com.utn.dds.javaianos.domain.Empresa;
import com.utn.dds.javaianos.repository.CotizacionRepository;
import javax.transaction.Transactional;
import static org.junit.Assert.assertNull;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class CotizacionRepositoryTest {
    
    @Autowired
    CotizacionRepository cotizacionRepository;
    
    @Test(expected = DataIntegrityViolationException.class)
    public void save_conCotizacionYaExistente_noAgregaOtraCotizacion() throws DataIntegrityViolationException {
        Cotizacion cotizacion = new Cotizacion();
        cotizacion.setId(5000L);
        cotizacion.setCuenta(new Cuenta("INOD","Ingreso Neto En Operaciones Discontinuadas"));
        cotizacion.setEmpresa(new Empresa("Facebook"));
        cotizacion.setPeriodo(2016);
        cotizacion.setValor(500.00);
        
        cotizacionRepository.save(cotizacion);
        assertNull(cotizacionRepository.findOne(5000L));
    }
}