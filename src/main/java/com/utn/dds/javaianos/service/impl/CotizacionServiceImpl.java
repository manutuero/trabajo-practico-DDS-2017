package com.utn.dds.javaianos.service.impl;

import com.utn.dds.javaianos.domain.Cotizacion;
import com.utn.dds.javaianos.domain.Cuenta;
import com.utn.dds.javaianos.domain.Empresa;
import com.utn.dds.javaianos.repository.CotizacionRepository;
import com.utn.dds.javaianos.repository.CuentaRepository;
import com.utn.dds.javaianos.repository.EmpresaRepository;
import com.utn.dds.javaianos.service.CotizacionService;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
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
}
