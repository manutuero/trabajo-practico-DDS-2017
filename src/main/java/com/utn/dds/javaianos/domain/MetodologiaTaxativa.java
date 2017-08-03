package com.utn.dds.javaianos.domain;

public class MetodologiaTaxativa extends Metodologia {

    public boolean convieneInvertir = false;

    @Override
    public void evaluarMetodologia() {
        for (Condicion condicion : this.listCondiciones) {
            //saco cuantas condiciones se cumplen
        }
        //si cumple mas del XX % setea el bool en true
    }
;

}
