package com.utn.dds.javaianos.service;

import java.nio.file.Path;
import org.springframework.web.multipart.MultipartFile;

public interface CuentaService extends ComponenteService {
    public void saveCuentas(MultipartFile file);
    public void saveCuentas(Path path);
}
