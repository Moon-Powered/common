package fr.moonpowered.common.cache;

import fr.moonpowered.common.identifier.Identifiable;
import java.util.Collection;
import java.util.function.Predicate;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.UnmodifiableView;

public interface Cache<I, E extends Identifiable<I>> {

    @UnmodifiableView
    @NotNull Collection<@NotNull E> findAll();

    @NotNull Collection<@NotNull E> findAllBy(final @NotNull Predicate<? super @NotNull E> filter);

    void insert(final @NotNull I id, final @NotNull E entity);

    @ApiStatus.NonExtendable
    default void insert(final @NotNull E entity) {
        this.insert(entity.getId(), entity);
    }

    void delete(final @NotNull I id);

    @ApiStatus.NonExtendable
    default void delete(final @NotNull E entity) {
        this.delete(entity.getId());
    }

    @ApiStatus.NonExtendable
    default boolean existsById(final @NotNull I id) {
        return this.existsBy(e -> e.getId().equals(id));
    }

    @ApiStatus.NonExtendable
    default boolean exists(final @NotNull E entity) {
        return this.existsById(entity.getId());
    }

    boolean existsBy(final @NotNull Predicate<? super @NotNull E> filter);

    @Nullable E findBy(final @NotNull Predicate<? super @NotNull E> filter);

    @Nullable E findById(final @NotNull I id);

    int getSize();

}
