package com.utn.dds.javaianos.controller.rest;

public class JsonResponse {

    private String resultado;
    
    public JsonResponse(String resultado) {
        this.resultado = resultado;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }
}
