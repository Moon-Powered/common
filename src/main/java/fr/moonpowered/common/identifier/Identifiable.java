package fr.moonpowered.common.identifier;

/**
 * Marks a type as having a stable identifier of type {@code T}.
 *
 * <p>Useful for caches, repositories, and collections where elements are referenced by id.</p>
 *
 * @param <T> the identifier type
 */
@FunctionalInterface
public interface Identifiable<T> {

  /**
   * Returns the identifier of this instance.
   *
   * @return the id value (never null unless implementor states otherwise)
   */
  T getId();
}
