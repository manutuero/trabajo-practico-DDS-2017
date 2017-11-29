package com.utn.dds.javaianos.domain;

import java.io.Serializable;
import javax.persistence.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class IndicadorMongo implements Serializable, Componente {

    @Id
    private int id;
    private String codigo;
    private String nombre;
    private String usuario;
    private String formula;

    public IndicadorMongo() {
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getFormula() {
        return formula;
    }

    public void setFormula(String formula) {
        this.formula = formula;
    }

    @Override
    public String toString() {
        return String.format("Indicador[id=%s,codigo=%s, nombre=%s, usuario=%s, formula=%s]", id, codigo, nombre, usuario, formula);
    }
}
