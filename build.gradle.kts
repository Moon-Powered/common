plugins {
    `java-library`
    `maven-publish`
}

group = "fr.moonpowered.common"
version = "0.0.2"

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(21))
}

repositories {
    mavenCentral()
    mavenLocal()
}

dependencies {
    api(libs.jetbrains.annotations)

    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.test {
    useJUnitPlatform()
}

publishing {
    publications {
        create<MavenPublication>("common") {
            from(components["java"])

            groupId = project.group.toString()
            artifactId = project.name
            version = project.version.toString()
        }
    }

    repositories {
        maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/Moon-Powered/common")
            credentials {
                username = System.getenv("githubActor")
                password = System.getenv("githubPassword")
            }
        }
    }
}
