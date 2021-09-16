plugins {
    java
    kotlin("jvm") version "1.5.30"
    id("com.github.johnrengelman.shadow") version "5.2.0"
}

repositories {
    mavenCentral()
    maven { url = uri("https://papermc.io/repo/repository/maven-public/") }
    maven { url = uri("https://repo.dmulloy2.net/repository/public/") }

}

subprojects {
    buildscript {
        repositories {
            jcenter()
        }
        dependencies {
            classpath("com.github.jengelman.gradle.plugins:shadow:5.2.0")
        }
    }

    apply(plugin = "java")
    apply(plugin = "org.jetbrains.kotlin.jvm")
    apply(plugin = "com.github.johnrengelman.shadow")

    dependencies {
        implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.1")
        compileOnly("io.papermc.paper:paper-api:1.17.1-R0.1-SNAPSHOT")
        compileOnly("com.comphenix.protocol:ProtocolLib:4.6.0")
    }


    java {
        sourceCompatibility = JavaVersion.VERSION_16
        targetCompatibility = JavaVersion.VERSION_16
    }
}
