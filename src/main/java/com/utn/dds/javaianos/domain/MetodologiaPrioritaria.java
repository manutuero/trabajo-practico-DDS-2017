package com.utn.dds.javaianos.domain;

import java.util.List;

public class MetodologiaPrioritaria extends Metodologia {

    public List<Empresa> empresas;

    @Override
    public void evaluarMetodologia() {
        for (Empresa empresa : this.empresas) {
            //evaluo la metodologia(condicion) y ordena la lista de empresas en funcion de las condiciones que cumple
        }
    }
    //retorna la lista de empresas ordenada
;
}
