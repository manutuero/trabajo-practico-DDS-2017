package com.utn.dds.javaianos.domain;

import com.utn.dds.javaianos.repository.MetodologiaRepository;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name = "Metodologia")
public class Metodologia implements Serializable{

    @Id
    private String nombre;

    @Transient
    private List<Componente> componentes;

    @Autowired
    @Transient
    MetodologiaRepository metodologiaRepository;

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setComponentes(List<Componente> componentes) {
        this.componentes = componentes;
    }

    public List<Componente> getComponentes() {
        return componentes;
    }

    public String getNombre() {
        return nombre;
    }

    public Metodologia() {
        this.componentes = new ArrayList();
    }

    public Metodologia(String nombre) {
        this.nombre = nombre;
        this.componentes = new ArrayList();
    }

}
