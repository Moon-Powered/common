package fr.moonpowered.common.icon;

/**
 * Marks a type as having an icon representation of type {@code T}.
 *
 * <p>Commonly used for UI rendering where an object can be associated with an icon handle,
 * sprite identifier, URL, or any other icon-like representation.</p>
 *
 * @param <T> the icon type
 */
@FunctionalInterface
public interface Iconable<T> {

  /**
   * Returns the icon representation.
   *
   * @return the icon value
   */
  T getIcon();
}
