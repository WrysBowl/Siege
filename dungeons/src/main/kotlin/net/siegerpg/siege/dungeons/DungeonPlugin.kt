package net.siegerpg.siege.dungeons

import org.bukkit.plugin.java.JavaPlugin

class DungeonPlugin : JavaPlugin() {
    companion object {
        private var instance: DungeonPlugin? = null
    }

    var dungeonConfig = DungeonConfig(this)

    override fun onEnable() {
        logger.info("SiegeDungeons has enabled!")
        instance = this
    }

    override fun onDisable() {
        instance = null
    }

    /**
     * Get the plugin's instance
     */
    public fun plugin(): DungeonPlugin {
        return instance!!
    }
}