package fr.moonpowered.common.cache;

import fr.moonpowered.common.identifier.Identifiable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Simple in-memory cache for tests using a HashMap.
 */
class TestMapCache<I, E extends Identifiable<I>> implements Cache<I, E> {

    private final Map<I, E> map = new HashMap<>();

    @Override
    public @NotNull Collection<@NotNull E> findAll() {
        return Collections.unmodifiableCollection(new ArrayList<>(map.values()));
    }

    @Override
    public @NotNull Collection<@NotNull E> findAllBy(@NotNull Predicate<? super @NotNull E> filter) {
        return map.values().stream().filter(filter).collect(Collectors.toList());
    }

    @Override
    public void insert(@NotNull I id, @NotNull E entity) {
        map.put(id, entity);
    }

    @Override
    public void delete(@NotNull I id) {
        map.remove(id);
    }

    @Override
    public boolean existsBy(@NotNull Predicate<? super @NotNull E> filter) {
        for (E e : map.values()) {
            if (filter.test(e)) return true;
        }
        return false;
    }

    @Override
    public @Nullable E findBy(@NotNull Predicate<? super @NotNull E> filter) {
        for (E e : map.values()) {
            if (filter.test(e)) return e;
        }
        return null;
    }

    @Override
    public @Nullable E findById(@NotNull I id) {
        return map.get(id);
    }

    @Override
    public int getSize() {
        return map.size();
    }
}