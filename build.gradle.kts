plugins {
	java
	kotlin("jvm") version "1.6.10"
	id("com.github.johnrengelman.shadow") version "7.1.2"
}

repositories {
	mavenCentral()
	maven { url = uri("https://papermc.io/repo/repository/maven-public/") }
	maven { url = uri("https://repo.dmulloy2.net/repository/public/") }
}

subprojects {

	apply(plugin = "java")
	apply(plugin = "org.jetbrains.kotlin.jvm")
	apply(plugin = "com.github.johnrengelman.shadow")

	dependencies {
		compileOnly("io.papermc.paper:paper-api:1.17.1-R0.1-SNAPSHOT")
	}

	java {
		sourceCompatibility = JavaVersion.VERSION_16
		targetCompatibility = JavaVersion.VERSION_16
	}
}
