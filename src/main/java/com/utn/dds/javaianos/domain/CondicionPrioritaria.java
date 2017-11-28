package com.utn.dds.javaianos.domain;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorColumn(discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("Prioritaria")
public class CondicionPrioritaria extends StrategyCondicion {

    public CondicionPrioritaria() {
    }

}
