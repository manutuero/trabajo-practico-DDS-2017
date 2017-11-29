package com.utn.dds.javaianos.service;

import com.utn.dds.javaianos.domain.Cotizacion;
import com.utn.dds.javaianos.domain.Cuenta;
import com.utn.dds.javaianos.domain.Empresa;
import java.nio.file.Path;
import java.util.List;
import org.springframework.web.multipart.MultipartFile;

public interface CotizacionService extends ComponenteService {
    public void saveCotizaciones(MultipartFile file);
    public void saveCotizaciones(Path path);
    public void deleteAll();
    public Cotizacion buscarCotizacion(Cuenta cuenta, Empresa empresa, Integer periodo);
    public List<Cotizacion> getFilteredCotizaciones(Empresa empresa, Integer periodo);
}
