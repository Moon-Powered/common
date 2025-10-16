package fr.moonpowered.common.interfaces;

import fr.moonpowered.common.support.TestEntity;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;

class InterfacesContractTest {

    @Test
    void basicGetterContracts_workAsExpected() {
        TestEntity e = new TestEntity(
                "id-1",
                "Name",
                "Desc",
                "key:1",
                Locale.CANADA_FRENCH,
                "icon:id-1",
                "issuer:john",
                Instant.ofEpochSecond(123)
        );

        assertEquals("id-1", e.getId());
        assertEquals("Name", e.getName());
        assertEquals("Desc", e.getDescription());
        assertEquals("key:1", e.getKey());
        assertEquals(Locale.CANADA_FRENCH, e.getLocale());
        assertEquals("icon:id-1", e.getIcon());
        assertEquals("issuer:john", e.getIssuer());
        assertEquals(Instant.ofEpochSecond(123), e.getCreatedAt());
    }
}