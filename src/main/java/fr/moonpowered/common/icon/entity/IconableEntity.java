package fr.moonpowered.common.icon.entity;

@FunctionalInterface
public interface IconableEntity<T, E> {

    T getIcon(final E entity);

}
