package net.siegerpg.siege.dungeons

import net.siegerpg.siege.core.utils.ConfigurationBase
import org.bukkit.configuration.ConfigurationSection
import org.bukkit.configuration.InvalidConfigurationException
import java.io.File
import java.io.IOException

class DungeonConfig(var plugin: DungeonPlugin) : ConfigurationBase(File(plugin.dataFolder, "dungeons.yml")) {

    @Throws(IOException::class, InvalidConfigurationException::class)
    override fun createConfig() {
        super.createConfig()
        deserializeDungeonTypes()

    }

    /**
     * @param dungeonName The dungeon type's name
     * @return The configuration section
     */
    fun getDungeonType(dungeonName: String?): ConfigurationSection? {
        var section = configuration.getConfigurationSection(dungeonName!!)
        if (section == null) section = configuration.createSection(dungeonName)
        return section
    }


    /**
     * @param dungeonType The type of the dungeon
     * @return ConfigurationSection The config's data on the list of dungeons of that type
     */
    fun getDungeons(dungeonType: DungeonType): ConfigurationSection { // Get the dungeons of a specific type from the file
        val section = getDungeonType(dungeonType.name)
        var dungeonSection = section!!.getConfigurationSection("dungeons")
        if (dungeonSection == null) dungeonSection = section.createSection("dungeons")
        return dungeonSection
    }

    /**
     * @param dungeonType The type of the dungeon
     * @param index       The index the dungeon is at.
     * @return The config's data on the dungeon
     */
    fun getDungeon(
        dungeonType: DungeonType,
        index: Int
    ): ConfigurationSection { // Get the dungeon at number index of a specific dungeon, not done yet
        val dungeons = getDungeons(dungeonType)
        if (dungeons.isConfigurationSection(index.toString())) {
            return dungeons.getConfigurationSection(index.toString()) as ConfigurationSection
        } else {
            return dungeons.createSection(
                index.toString()
            )
        }
    }

    fun deserializeDungeonTypes() {
        configuration.getKeys(false).forEach { key ->
            DungeonType.dungeonTypes.add(
                DungeonType.deserialize(
                    configuration.getConfigurationSection(
                        key
                    )!!, key, plugin
                )
            )
        }
    }
}