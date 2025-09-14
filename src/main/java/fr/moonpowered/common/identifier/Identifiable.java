package fr.moonpowered.common.identifier;

@FunctionalInterface
public interface Identifiable<T> {

  T getId();
}
