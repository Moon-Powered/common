package fr.moonpowered.common.factory;

@FunctionalInterface
public interface Factory<T> {

    T newInstance();

}
