package fr.moonpowered.common.name;

/**
 * Marks a type as having a name of type {@code T}.
 *
 * <p>Useful for display purposes or human-readable identifiers.</p>
 *
 * @param <T> the name type (often {@link String})
 */
@FunctionalInterface
public interface Nameable<T> {

  /**
   * Returns the name for this instance.
   *
   * @return the name value
   */
  T getName();
}
