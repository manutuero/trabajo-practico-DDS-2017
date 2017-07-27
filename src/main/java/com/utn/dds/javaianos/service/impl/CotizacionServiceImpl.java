package com.utn.dds.javaianos.service.impl;

import com.utn.dds.javaianos.domain.Componente;
import com.utn.dds.javaianos.domain.Cotizacion;
import com.utn.dds.javaianos.domain.Cuenta;
import com.utn.dds.javaianos.domain.Empresa;
import com.utn.dds.javaianos.repository.CotizacionRepository;
import com.utn.dds.javaianos.repository.CuentaRepository;
import com.utn.dds.javaianos.repository.EmpresaRepository;
import com.utn.dds.javaianos.service.CotizacionService;
import java.io.IOException;
import java.util.List;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class CotizacionServiceImpl implements CotizacionService {

    @Autowired
    private CotizacionRepository cotizacionRepository;
    @Autowired
    private CuentaRepository cuentaRepository;
    @Autowired
    private EmpresaRepository empresaRepository;

    @Override
    public void saveCotizaciones(MultipartFile file) {
        try {
            byte[] bytes = file.getBytes();
            String data = new String(bytes);
            String[] rows = data.split("\\n");

            for (String row : rows) {
                StringTokenizer st = new StringTokenizer(row, ",");
                Cotizacion cotizacion = new Cotizacion();
                cotizacion.setCuenta(cuentaRepository.findFirstByCodigo(st.nextToken()));
                cotizacion.setEmpresa(empresaRepository.findByNombre(st.nextToken()));
                cotizacion.setPeriodo(Integer.parseInt(st.nextToken()));
                cotizacion.setValor(Double.parseDouble(st.nextToken()));
                cotizacionRepository.save(cotizacion);
            }
        } catch (IOException ex) {
            Logger.getLogger(CuentaServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /* Inicio metodos del patron composite */
    @Override
    public void add(Componente componente) {
        // metodo no implementado en nodo hoja (leaf)
    }

    @Override
    public void remove(Componente componente) {
        // metodo no implementado en nodo hoja (leaf)
    }

    @Override
    public Componente getChild(int i) {
        // metodo no implementado en nodo hoja (leaf)
        return null;
    }

    /* Fin metodos del patron composite */

    @Override
    public Cotizacion buscarCotizacion(Cuenta cuenta, Empresa empresa, Integer periodo) {
        return cotizacionRepository.findByCuentaAndEmpresaAndPeriodo((Cuenta) cuenta, empresa, periodo);
    }

    @Override
    public List<Cotizacion> getFilteredCotizaciones(Empresa empresa, Integer periodo) {
        List<Cotizacion> cotizaciones = cotizacionRepository.findAll();
        return cotizaciones
                .stream()
                .filter((Cotizacion cotizacion) -> cotizacion.getEmpresa().getNombre()
                        .equals(empresa.getNombre())&& 
                        cotizacion.getPeriodo()
                        .equals(periodo))
                .collect(Collectors.toList());
    }

    @Override
    public Double calcularValor(Componente cuenta, Empresa empresa, Integer periodo) {
        return this.buscarCotizacion((Cuenta) cuenta, empresa, periodo).getValor();
    }
}
