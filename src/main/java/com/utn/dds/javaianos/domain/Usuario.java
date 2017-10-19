package com.utn.dds.javaianos.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Usuario")
public class Usuario implements Serializable {
    @Id
    private String usuario;
    private String password;
    
    public Usuario(){};

    public String getUsuario() {
        return usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
}
