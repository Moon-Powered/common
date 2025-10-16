# MoonPowered Common

MoonPowered Common is a lightweight Java library that collects the cross-cutting concepts that routinely show up in MoonPowered projects. It provides a curated set of small, composable interfaces and annotations that describe common domain characteristics—such as names, identifiers, icons, locales, and descriptions—together with helper contracts for caching, factories, and tracing. The goal is to promote consistent modelling across services while keeping your domain classes focused on their business concerns.

## Features

- **Metadata interfaces** – Implement `Nameable`, `Describable`, `Iconable`, `Localizable`, `Identifiable`, `Keyed`, `Issuable`, and `Traceable` to express common traits on your domain objects without re-inventing boilerplate in each module.【F:src/main/java/fr/moonpowered/common/name/Nameable.java†L1-L7】【F:src/main/java/fr/moonpowered/common/description/Describable.java†L1-L7】【F:src/main/java/fr/moonpowered/common/icon/Iconable.java†L1-L7】【F:src/main/java/fr/moonpowered/common/locale/Localizable.java†L1-L9】【F:src/main/java/fr/moonpowered/common/identifier/Identifiable.java†L1-L7】【F:src/main/java/fr/moonpowered/common/key/Keyed.java†L1-L7】【F:src/main/java/fr/moonpowered/common/issuer/Issuable.java†L1-L7】【F:src/main/java/fr/moonpowered/common/trace/Traceable.java†L1-L7】
- **Mutable extensions** – Optional `Mutable*` interfaces make it easy to expose safe mutators alongside the read-only traits when your domain requires them.【F:src/main/java/fr/moonpowered/common/name/impl/MutableNameable.java†L1-L13】【F:src/main/java/fr/moonpowered/common/identifier/impl/MutableIdentifiable.java†L1-L13】【F:src/main/java/fr/moonpowered/common/description/impl/MutableDescribable.java†L1-L13】【F:src/main/java/fr/moonpowered/common/icon/impl/MutableIconable.java†L1-L13】【F:src/main/java/fr/moonpowered/common/key/impl/MutableKeyed.java†L1-L13】【F:src/main/java/fr/moonpowered/common/locale/impl/MutableLocalizable.java†L1-L11】
- **Declarative annotations** – Mark fields or components with lightweight annotations such as `@Name`, `@Identifier`, and `@Key` to surface intent and support reflection-based tooling.【F:src/main/java/fr/moonpowered/common/name/annotation/Name.java†L1-L11】【F:src/main/java/fr/moonpowered/common/identifier/annotation/Identifier.java†L1-L11】【F:src/main/java/fr/moonpowered/common/key/annotation/Key.java†L1-L11】
- **Caching contract** – A generic `Cache` interface centralises basic CRUD-style operations, including convenience overloads for working with identifiable entities.【F:src/main/java/fr/moonpowered/common/cache/Cache.java†L1-L47】
- **Factory and icon helpers** – Compose new objects through the simple `Factory` functional interface and supply icons that depend on the entity at runtime via `IconableEntity`.【F:src/main/java/fr/moonpowered/common/factory/Factory.java†L1-L7】【F:src/main/java/fr/moonpowered/common/icon/entity/IconableEntity.java†L1-L7】
- **Symbol constants** – Reuse curated unicode glyphs for UI or messaging through the `Symbol` utility class.【F:src/main/java/fr/moonpowered/common/util/Symbol.java†L1-L79】

## Project structure

```
.
├── build.gradle.kts       # Gradle build that configures Java 21, dependencies, and publishing
├── src/main/java          # Library source organised by domain concern
│   └── fr/moonpowered/common
│       ├── cache          # Cache abstraction
│       ├── description    # Description traits and mutable extensions
│       ├── factory        # Factory functional interface
│       ├── icon           # Icon traits and per-entity helpers
│       ├── identifier     # Identifier traits, annotations, and mutators
│       ├── issuer         # Issuer trait
│       ├── key            # Key traits, annotations, and mutators
│       ├── locale         # Locale trait and mutable variant
│       ├── name           # Name trait, annotation, and mutable variant
│       ├── trace          # Traceable interface for creation timestamps
│       └── util           # Shared utility constants
```

## Getting started

### Prerequisites

- Java 21 or newer (enforced via the Gradle toolchain configuration).【F:build.gradle.kts†L9-L11】
- Gradle 8+ (a Gradle wrapper is provided so you can simply run `./gradlew`).

### Building and testing

```bash
./gradlew build
./gradlew test
```

The build script already enables the JUnit 5 platform for the test task.【F:build.gradle.kts†L17-L24】

### Using the library

Add the dependency to your module (replace the version if a newer release is available):

```kotlin
repositories {
    mavenCentral()
    maven("https://maven.pkg.github.com/Moon-Powered/common")
}

dependencies {
    implementation("fr.moonpowered.common:common:0.0.1")
}
```

The published coordinates and GitHub Packages repository match the Gradle `group`, `version`, and publishing configuration shipped in this project.【F:build.gradle.kts†L1-L44】

#### Example

```java
import fr.moonpowered.common.identifier.Identifiable;
import fr.moonpowered.common.name.Nameable;
import fr.moonpowered.common.description.Describable;

public record GameItem(String id, String name, String description)
    implements Identifiable<String>, Nameable<String>, Describable<String> {
}
```

Combine traits as needed to concisely express the contracts your domain objects satisfy. When mutation is required, implement the corresponding `Mutable*` variant instead of exposing ad-hoc setters.

## Publishing

A ready-to-use Maven publication named `common` is configured for GitHub Packages. Provide the `githubActor` and `githubPassword` environment variables when running `./gradlew publish` to push a new version.【F:build.gradle.kts†L26-L44】

## Contributing

Issues and pull requests are welcome! When contributing new traits or utilities, please accompany them with documentation and unit tests where appropriate. Run the test suite locally before submitting your changes to ensure the shared abstractions remain stable.

## License

This repository does not currently declare a license. If you plan to use the code in a public or commercial setting, please contact the maintainers or open an issue to clarify licensing terms.
