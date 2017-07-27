package com.utn.dds.javaianos.service;

import org.springframework.web.multipart.MultipartFile;

public interface CuentaService extends ComponenteService {
    public void saveCuentas(MultipartFile file);
}
