package fr.moonpowered.common.identifier.impl;

import fr.moonpowered.common.identifier.Identifiable;

public interface MutableIdentifiable<T> extends Identifiable<T> {

    @Override
    T getId();

    void setId(final T id);

}
