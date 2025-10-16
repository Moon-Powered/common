package fr.moonpowered.common.cache;

import fr.moonpowered.common.identifier.Identifiable;
import java.util.Collection;
import java.util.function.Predicate;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.UnmodifiableView;

/**
 * A generic, in-memory-like cache contract for storing and querying {@link Identifiable} entities.
 *
 * <p>Implementations decide on the underlying data structure and thread-safety guarantees.
 * Unless otherwise documented by an implementation, operations are assumed to be non-blocking
 * and not thread-safe.</p>
 *
 * <p>Nullability is explicitly annotated using JetBrains annotations. Callers should respect
 * the contracts described here (e.g., never pass null to parameters annotated with {@link NotNull}).</p>
 *
 * @param <I> the identifier type used to reference entities
 * @param <E> the entity type stored in the cache; must be {@link Identifiable} by {@code I}
 */
public interface Cache<I, E extends Identifiable<I>> {

  /**
   * Returns an unmodifiable snapshot view of all entities currently present in the cache.
   *
   * @return an unmodifiable view of all entities; never null
   */
  @UnmodifiableView
  @NotNull
  Collection<@NotNull E> findAll();

  /**
   * Returns all entities that satisfy the provided filter predicate.
   *
   * @param filter a non-null predicate used to select entities
   * @return a collection of matching entities; never null (may be empty)
   */
  @NotNull
  Collection<@NotNull E> findAllBy(final @NotNull Predicate<? super @NotNull E> filter);

  /**
   * Inserts or replaces an entity under the given identifier.
   *
   * @param id the non-null identifier of the entity
   * @param entity the non-null entity to insert
   */
  void insert(final @NotNull I id, final @NotNull E entity);

  /**
   * Convenience method that inserts the entity using its {@link Identifiable#getId()}.
   *
   * @param entity the non-null entity to insert
   */
  @ApiStatus.NonExtendable
  default void insert(final @NotNull E entity) {
    this.insert(entity.getId(), entity);
  }

  /**
   * Deletes the entity associated with the given identifier, if present.
   *
   * @param id the non-null identifier of the entity to delete
   */
  void delete(final @NotNull I id);

  /**
   * Convenience method that deletes the provided entity by its identifier.
   *
   * @param entity the non-null entity to delete
   */
  @ApiStatus.NonExtendable
  default void delete(final @NotNull E entity) {
    this.delete(entity.getId());
  }

  /**
   * Checks whether an entity with the given identifier exists in the cache.
   *
   * @param id the non-null identifier to check
   * @return true if an entity exists with that id; false otherwise
   */
  @ApiStatus.NonExtendable
  default boolean existsById(final @NotNull I id) {
    return this.existsBy(e -> e.getId().equals(id));
  }

  /**
   * Checks whether the given entity exists in the cache (by its identifier).
   *
   * @param entity the non-null entity to check
   * @return true if an entity with the same id exists; false otherwise
   */
  @ApiStatus.NonExtendable
  default boolean exists(final @NotNull E entity) {
    return this.existsById(entity.getId());
  }

  /**
   * Checks for the existence of at least one entity matching the provided filter.
   *
   * @param filter a non-null predicate to match entities
   * @return true if a matching entity exists; false otherwise
   */
  boolean existsBy(final @NotNull Predicate<? super @NotNull E> filter);

  /**
   * Finds the first entity matching the provided filter.
   *
   * @param filter a non-null predicate to select an entity
   * @return the first matching entity, or null if none match
   */
  @Nullable
  E findBy(final @NotNull Predicate<? super @NotNull E> filter);

  /**
   * Finds the entity associated with the given identifier.
   *
   * @param id the non-null identifier to look up
   * @return the entity if present; otherwise null
   */
  @Nullable
  E findById(final @NotNull I id);

  /**
   * Returns the number of entities currently stored in the cache.
   *
   * @return the current size of the cache
   */
  int getSize();
}
