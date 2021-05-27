package net.siegerpg.siege.dungeons;

import org.bukkit.plugin.java.JavaPlugin;

public class DungeonPlugin extends JavaPlugin {
    private static DungeonPlugin INSTANCE;

    DungeonConfig dungeonConfig = null;

    @Override
    public void onEnable() {
        INSTANCE = this;
        dungeonConfig = new DungeonConfig();
        getLogger().info("SiegeDungeons has enabled!");
    }

    @Override
    public void onDisable() {
        INSTANCE = null;
    }


    /**
     * Method to get the plugin from other classes
     * You can use Core.plugin() in other classes to get the plugin instance
     *
     * @return The main plugin
     */
    public static DungeonPlugin plugin() {
        return INSTANCE;
    }
}
