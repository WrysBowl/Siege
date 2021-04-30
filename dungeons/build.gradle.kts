import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

repositories {
    maven { url = uri("https://papermc.io/repo/repository/maven-public/") }
    mavenCentral()

    maven { url = uri("https://nexus.mcdevs.us/repository/mcdevs/") }
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
//    withType<KotlinCompile> {
//        kotlinOptions.jvmTarget = "1.8"
//    }
}
