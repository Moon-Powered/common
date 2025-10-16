package fr.moonpowered.common.issuer;

/**
 * Marks a type as having an issuer (originator) of type {@code T}.
 *
 * <p>Useful when tracking ownership, authorship, or the source of an action/event.</p>
 *
 * @param <T> the issuer type
 */
@FunctionalInterface
public interface Issuable<T> {

  /**
   * Returns the issuer associated with this instance.
   *
   * @return the issuer value
   */
  T getIssuer();
}
