package fr.moonpowered.common.cache;

import fr.moonpowered.common.support.TestEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class CacheTest {

    private TestMapCache<String, TestEntity> cache;

    @BeforeEach
    void setUp() {
        cache = new TestMapCache<>();
        cache.insert("1", new TestEntity("1", "One"));
        cache.insert("2", new TestEntity("2", "Two"));
        cache.insert("3", new TestEntity("3", "Three"));
    }

    @Test
    void findAll_returnsUnmodifiableSnapshot() {
        Collection<TestEntity> all = cache.findAll();
        assertEquals(3, all.size());
        assertThrows(UnsupportedOperationException.class, () -> all.clear());
    }

    @Test
    void findAllBy_filtersCorrectly() {
        List<TestEntity> withT = cache.findAllBy(e -> e.getName().startsWith("T")).stream().toList();
        assertEquals(2, withT.size());
        assertTrue(withT.stream().allMatch(e -> e.getName().startsWith("T")));
    }

    @Test
    void insert_usingEntityDefaultMethod() {
        TestEntity e = new TestEntity("4", "Four");
        cache.insert(e);
        assertEquals(4, cache.getSize());
        assertTrue(cache.existsById("4"));
        assertSame(e, cache.findById("4"));
    }

    @Test
    void delete_usingEntityDefaultMethod() {
        TestEntity e = Objects.requireNonNull(cache.findById("2"));
        cache.delete(e);
        assertEquals(2, cache.getSize());
        assertFalse(cache.existsById("2"));
    }

    @Test
    void existsById_and_exists() {
        assertTrue(cache.existsById("1"));
        assertFalse(cache.existsById("99"));
        assertTrue(cache.exists(new TestEntity("1", "irrelevant")));
        assertFalse(cache.exists(new TestEntity("99", "nope")));
    }

    @Test
    void findBy_and_findById() {
        assertNotNull(cache.findById("3"));
        assertNull(cache.findById("404"));
        assertEquals("Two", Objects.requireNonNull(cache.findBy(e -> e.getName().equals("Two"))).getName());
        assertNull(cache.findBy(e -> e.getName().equals("Missing")));
    }
}
