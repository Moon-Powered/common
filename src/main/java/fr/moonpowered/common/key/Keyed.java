package fr.moonpowered.common.key;

@FunctionalInterface
public interface Keyed<T> {

    T getKey();

}
