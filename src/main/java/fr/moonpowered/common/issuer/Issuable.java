package fr.moonpowered.common.issuer;

@FunctionalInterface
public interface Issuable<T> {

  T getIssuer();
}
