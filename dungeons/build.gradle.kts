buildscript {
    repositories {
        jcenter()
    }
    dependencies {
        classpath("com.github.jengelman.gradle.plugins:shadow:5.2.0")
    }
}

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

plugins {
    java
    kotlin("jvm") version "1.4.32"
    id("com.github.johnrengelman.shadow") version "6.1.0"
}

group = "net.siegerpg.siege"
version = "0.1.0"

repositories {
    mavenCentral()
    maven { url = uri("https://nexus.mcdevs.us/repository/mcdevs/") }
    maven { url = uri("https://papermc.io/repo/repository/maven-public/") }

}

dependencies {
    compileOnly("us.mcdevs.library.kotlin:Kotlin:1.4.0")
    compileOnly("com.destroystokyo.paper:paper-api:1.16.5-R0.1-SNAPSHOT")
    // TODO Add FAWE as a dependency
}


tasks {
    shadowJar {
        archiveFileName.set("SiegeDungeons.jar")
    }
    build {
        dependsOn(shadowJar)
    }
    jar {
        dependsOn(shadowJar)
    }
}