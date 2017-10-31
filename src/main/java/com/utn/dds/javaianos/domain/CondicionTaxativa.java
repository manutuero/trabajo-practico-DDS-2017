package com.utn.dds.javaianos.domain;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@DiscriminatorColumn(discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("Taxativa")
public class CondicionTaxativa extends StrategyCondicion {

    public CondicionTaxativa() {
    }

    @Override
    public void evaluarCondicion(Integer periodo, EmpresaValor empresaValor) {
        
    }

  

}
