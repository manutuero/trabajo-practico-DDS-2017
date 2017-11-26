package com.utn.dds.javaianos.domain;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorColumn(discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("Taxativa")
public class CondicionTaxativa extends StrategyCondicion {
//En esta si y en esta no
    public CondicionTaxativa() {
    }

  

}
