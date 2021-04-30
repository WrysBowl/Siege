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
    compileOnly("us.mcdevs.library.kotlin:Kotlin:1.4.0")
    compileOnly("org.projectlombok:lombok:1.18.16")
    compileOnly("com.destroystokyo.paper:paper-api:1.16.5-R0.1-SNAPSHOT")
    compileOnly("com.comphenix.protocol:ProtocolLib:4.5.0")
    compileOnly("io.lumine.xikage:MythicMobs:4.11.2") // MythicMobs API
    compileOnly("com.github.MilkBowl:VaultAPI:1.7") // Vault API
    implementation("co.aikar:acf-paper:0.5.0-SNAPSHOT")
    implementation("com.github.stefvanschie.inventoryframework:IF:0.9.0")
    compileOnly("de.tr7zw:item-nbt-api-plugin:2.7.1")
    implementation("net.kyori:adventure-text-minimessage:4.1.0-SNAPSHOT")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.3.7") {
        exclude("kotlin-stdlib-common")
        exclude("kotlin-stdlib")
    }
    annotationProcessor("org.projectlombok:lombok:1.18.16")
    //compile(fileTree(include(["*.jar"]), dir("libs")))
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
