plugins {
    kotlin("jvm") version "1.9.22"
}

group = "io.github.vootelerotov"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.jetbrains.kotlin:kotlin-test")
    testImplementation("org.jetbrains.kotlin:kotlin-reflect")

    testImplementation("com.spotify:github-client:0.2.14")
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(17)
}