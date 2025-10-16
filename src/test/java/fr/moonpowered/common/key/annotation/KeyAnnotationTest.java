package fr.moonpowered.common.key.annotation;

import org.junit.jupiter.api.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import static org.junit.jupiter.api.Assertions.*;

class KeyAnnotationTest {

    @Key("hello")
    static class WithKey {}

    @Test
    void hasRuntimeRetention_andValueAccessible() throws Exception {
        // retention runtime
        Retention retention = Key.class.getAnnotation(Retention.class);
        assertNotNull(retention);
        assertEquals(RetentionPolicy.RUNTIME, retention.value());

        // class value
        Key k = WithKey.class.getAnnotation(Key.class);
        assertNotNull(k);
        assertEquals("hello", k.value());

        // method presence
        Method m = Key.class.getMethod("value");
        assertTrue(Modifier.isPublic(m.getModifiers()));
        assertEquals(String.class, m.getReturnType());
        assertEquals(0, m.getParameterCount());
    }
}
