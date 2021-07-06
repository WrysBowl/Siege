import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

repositories {
    mavenCentral()
    maven { url = uri("https://mvn.intellectualsites.com/content/repositories/releases/") } // FAWE
    maven { url = uri("https://papermc.io/repo/repository/maven-public/") }
    mavenCentral()
    maven { url = uri("https://repo.aikar.co/content/groups/aikar/") }
    maven { url = uri("https://repo.codemc.org/repository/maven-public/") }
    maven { url = uri("https://mvn.lumine.io/repository/maven-public/") }
    maven { url = uri("https://jitpack.io") }
    maven { url = uri("https://repo.dmulloy2.net/nexus/repository/public/") }
    maven { url = uri("https://dl.bintray.com/ichbinjoe/public/") }
    maven { url = uri("https://maven.enginehub.org/repo/") }

}

dependencies {
    compileOnly(project(":core"))
    compileOnly("com.intellectualsites.fawe:FAWE-Bukkit:1.16-637") { isTransitive = false }
    compileOnly("com.intellectualsites.fawe:FAWE-Core:1.16-637")
    implementation("net.kyori:adventure-text-minimessage:4.1.0-SNAPSHOT")
    compileOnly("io.lumine.xikage:MythicMobs:4.11.2") // MythicMobs API

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
    withType<KotlinCompile> {
        kotlinOptions.jvmTarget = "11"
    }

}
