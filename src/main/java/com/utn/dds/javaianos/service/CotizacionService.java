package com.utn.dds.javaianos.service;

import org.springframework.web.multipart.MultipartFile;

public interface CotizacionService {
    public void saveCotizaciones(MultipartFile file);
}
