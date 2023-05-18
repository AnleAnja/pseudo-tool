import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

val exposedVersion = "0.40.1"
val postgresVersion = "42.5.0"
dependencies {
    implementation("org.jetbrains.exposed:exposed-core:$exposedVersion")
    implementation("org.jetbrains.exposed:exposed-dao:$exposedVersion")
    implementation("org.jetbrains.exposed:exposed-jdbc:$exposedVersion")
    implementation("org.postgresql:postgresql:$postgresVersion")
}

plugins {
    kotlin("jvm") version "1.7.10"
}

group = "me.anja"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnit()
}

tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = "13"
}
