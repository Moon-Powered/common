package fr.moonpowered.common.description;

/**
 * Marks a type as providing a description of type {@code T}.
 *
 * <p>The description may represent human-readable text, a structured model, or a localization key.</p>
 *
 * @param <T> the description type
 */
@FunctionalInterface
public interface Describable<T> {

  /**
   * Returns the description for this instance.
   *
   * @return the description value
   */
  T getDescription();
}
