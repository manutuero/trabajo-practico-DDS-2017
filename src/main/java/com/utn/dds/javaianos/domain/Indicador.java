package com.utn.dds.javaianos.domain;

public class Indicador implements Componente {

    private String nombre;
    
    private String tipo;
    
    private String formula;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getFormula() {
        return formula;
    }

    public void setFormula(String formula) {
        this.formula = formula;
    }
    
    @Override
    public Double calcularValor() {
        
        return null;
    }
}
