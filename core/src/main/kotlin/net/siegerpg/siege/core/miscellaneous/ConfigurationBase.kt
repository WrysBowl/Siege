package net.siegerpg.siege.core.miscellaneous

import org.bukkit.configuration.InvalidConfigurationException
import org.bukkit.configuration.file.FileConfiguration
import org.bukkit.configuration.file.YamlConfiguration
import java.io.File
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.*

/**
 * @param file The file the configuration will be saved to
 */
open class ConfigurationBase(file: File) {
	protected var configFile: File = file
	lateinit var configuration: FileConfiguration

	init {
		this.createConfig()
	}

	/**
	 * Creates the config
	 */
	@Throws(IOException::class, InvalidConfigurationException::class)
	open fun createConfig() {
		if (!configFile.exists()) configFile.parentFile.mkdirs()
		configuration = YamlConfiguration()
		try {
			configFile.createNewFile()
			loadFile()
		} catch (e: Exception) {
			throw e
		}
	}

	/**
	 * Saves the configuration to a file
	 *
	 * @throws IOException when the file can't be written to
	 */
	@Throws(IOException::class)
	fun save() { // Saves the configuration to file
		try {
			configuration.save(configFile)
		} catch (e: IOException) {
			throw e
		}
	}

	/**
	 * Loads the configuration from the file. This will override the current values in memory
	 */
	fun loadFile() {
		configuration.load(configFile)
	}

	/**
	 * Resets the configuration, deleting ALL data.
	 * Beware as this can't be rolled back!
	 */
	fun reset() {
		configFile.delete()
		createConfig()
	}

	fun backup(directory: File) {
		val fileName = SimpleDateFormat("yyyy.MM.dd G 'at' HH:mm:ss").format(Date())
		configFile.copyTo(File(directory, fileName))
	}

}
