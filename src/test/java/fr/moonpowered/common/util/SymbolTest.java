package fr.moonpowered.common.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SymbolTest {

    @Test
    void constants_areNotNull_andSomeExactValues() {
        assertNotNull(Symbol.BAR);
        assertNotNull(Symbol.HEART);
        assertEquals("✔", Symbol.CHECKMARK);
        assertEquals("✖", Symbol.CROSS);
        assertEquals("∞", Symbol.INFINITE);
    }
}
