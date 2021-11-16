import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

repositories {
	mavenCentral()
	maven {
		url = uri("https://mvn.intellectualsites.com/content/repositories/releases/")
	} // FAWE
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
	implementation("co.aikar:acf-paper:0.5.0-SNAPSHOT")
	implementation("com.github.stefvanschie.inventoryframework:IF:0.10.3")
	compileOnly("de.tr7zw:item-nbt-api-plugin:2.7.1")
	compileOnly("com.github.MilkBowl:VaultAPI:1.7")
	implementation("net.kyori:adventure-text-minimessage:4.1.0-SNAPSHOT")
}

tasks {

	shadowJar {
		relocate("co.aikar.commands", "net.siegerpg.siege.shops.acf")
		relocate("co.aikar.locales", "net.siegerpg.siege.shops.locales")
		relocate(
				"com.github.stefvanschie.inventoryframework",
				"net.siegerpg.siege.shops.inventoryframework"
		        )
		archiveFileName.set("SiegeShops.jar")
	}

	build {
		dependsOn(shadowJar)
	}
	jar {
		dependsOn(shadowJar)
	}
	withType<JavaCompile> {
		options.compilerArgs.add("-parameters")
	}
	withType<KotlinCompile> {
		kotlinOptions.jvmTarget = "11"
		kotlinOptions.javaParameters = true
	}

}