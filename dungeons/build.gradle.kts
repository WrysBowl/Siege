import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

repositories {
    mavenCentral()
    maven { url = uri("https://mvn.intellectualsites.com/content/repositories/releases/") } // FAWE
}

dependencies {
    compileOnly(project(":core"))
    compileOnly("com.intellectualsites.fawe:FAWE-Bukkit:1.16-637") { isTransitive = false }
    compileOnly("com.intellectualsites.fawe:FAWE-Core:1.16-637")
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
