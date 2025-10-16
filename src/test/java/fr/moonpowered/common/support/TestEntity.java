package fr.moonpowered.common.support;

import fr.moonpowered.common.description.Describable;
import fr.moonpowered.common.icon.Iconable;
import fr.moonpowered.common.identifier.Identifiable;
import fr.moonpowered.common.issuer.Issuable;
import fr.moonpowered.common.key.Keyed;
import fr.moonpowered.common.locale.Localizable;
import fr.moonpowered.common.name.Nameable;
import fr.moonpowered.common.trace.Traceable;
import org.jetbrains.annotations.NotNull;

import java.time.Instant;
import java.util.Locale;
import java.util.Objects;

public class TestEntity implements Identifiable<String>, Nameable<String>, Describable<String>, Keyed<String>, Localizable, Iconable<String>, Issuable<String>, Traceable<Instant> {
    private final String id;
    private final String name;
    private final String description;
    private final String key;
    private final Locale locale;
    private final String icon;
    private final String issuer;
    private final Instant createdAt;

    public TestEntity(String id, String name) {
        this(id, name, name + " description", "key:" + id, Locale.ENGLISH, "icon:" + id, "issuer:" + id, Instant.EPOCH);
    }

    public TestEntity(String id, String name, String description, String key, Locale locale, String icon, String issuer, Instant createdAt) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.key = key;
        this.locale = locale;
        this.icon = icon;
        this.issuer = issuer;
        this.createdAt = createdAt;
    }

    @Override
    public String getId() { return id; }

    @Override
    public String getName() { return name; }

    @Override
    public String getDescription() { return description; }

    @Override
    public String getKey() { return key; }

    @Override
    public @NotNull Locale getLocale() { return locale; }

    @Override
    public String getIcon() { return icon; }

    @Override
    public String getIssuer() { return issuer; }

    @Override
    public Instant getCreatedAt() { return createdAt; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TestEntity that)) return false;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}