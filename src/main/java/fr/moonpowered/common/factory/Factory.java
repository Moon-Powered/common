package fr.moonpowered.common.factory;

/**
 * A simple factory functional interface for creating new instances of a given type.
 *
 * <p>This is useful for dependency injection, testing, or deferred creation of objects
 * without exposing concrete constructors.</p>
 *
 * @param <T> the type of object produced by this factory
 */
@FunctionalInterface
public interface Factory<T> {

  /**
   * Creates a new instance of {@code T}.
   *
   * @return a freshly created instance; never null unless the factory is documented to do so
   */
  T newInstance();
}
