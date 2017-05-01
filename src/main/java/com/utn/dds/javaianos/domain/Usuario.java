package com.utn.dds.javaianos.domain;

/**
 *
 * @author GaboXXZHP
 */
public class Usuario {
    private final String nombre;
    
    public Usuario(String nombreUsu){
        this.nombre=nombreUsu;
    }

    public String getNombre() {
        return nombre;
    }
}
