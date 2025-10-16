package fr.moonpowered.common.trace;

/**
 * Marks a type as traceable with creation metadata of type {@code T}.
 *
 * <p>The generic type is commonly a timestamp (e.g., {@code java.time.Instant}) or another
 * structure carrying creation information.</p>
 *
 * @param <T> the creation metadata type
 */
public interface Traceable<T> {

    /**
     * Returns the creation metadata for this instance.
     *
     * @return the creation metadata value
     */
    T getCreatedAt();
}
