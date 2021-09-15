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
    testImplementation("junit:junit:4.12")
    compileOnly("org.projectlombok:lombok:1.18.20")
    compileOnly("com.comphenix.protocol:ProtocolLib:4.5.0")
    compileOnly("io.lumine.xikage:MythicMobs:4.11.2") // MythicMobs API
    /*
    compileOnly("com.vexsoftware:nuvotifier-universal:2.6.0"){
        exclude("com.google.code.gson")
        exclude("org.checkerframework")
    } // NuVotifier API
     */
    implementation("org.reflections:reflections:0.9.12")
    compileOnly("com.github.MilkBowl:VaultAPI:1.7") // Vault API
    implementation("co.aikar:acf-paper:0.5.0-SNAPSHOT")
    implementation("com.github.stefvanschie.inventoryframework:IF:0.9.7")
    compileOnly("de.tr7zw:item-nbt-api-plugin:2.7.1")
    implementation("net.kyori:adventure-text-minimessage:4.1.0-SNAPSHOT")
    implementation("com.zaxxer:HikariCP:4.0.3")
    annotationProcessor("org.projectlombok:lombok:1.18.20")
    //compile(fileTree(include(["*.jar"]), dir("libs")))
}

tasks {
    shadowJar {
        relocate("co.aikar.commands", "net.siegerpg.siege.core.acf")
        relocate("co.aikar.locales", "net.siegerpg.siege.core.locales")
        relocate("com.github.stefvanschie.inventoryframework", "net.siegerpg.siege.core.inventoryframework")
        doFirst {
            exclude("fonts/*.csv")
        }
        archiveFileName.set("SiegeCore.jar")
    }
    build {
        dependsOn(shadowJar)
    }
    jar {
        dependsOn(shadowJar)
    }
    withType<KotlinCompile> {
        kotlinOptions.jvmTarget = "16"
    }
//    withType<KotlinCompile> {
//        kotlinOptions.jvmTarget = "1.8"
//    }
}
