package fr.moonpowered.common.key;

/**
 * Marks a type as being associated with a key of type {@code T}.
 *
 * <p>Often used for lookups, grouping, or mapping structures.</p>
 *
 * @param <T> the key type
 */
@FunctionalInterface
public interface Keyed<T> {

  /**
   * Returns the key for this instance.
   *
   * @return the key value
   */
  T getKey();
}
