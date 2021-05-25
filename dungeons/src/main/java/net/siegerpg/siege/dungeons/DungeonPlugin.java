package net.siegerpg.siege.dungeons;

import org.bukkit.plugin.java.JavaPlugin;

public class DungeonPlugin extends JavaPlugin {
    private static DungeonPlugin INSTANCE;

    public DungeonConfig dungeonConfig;
    @Override
    public void onEnable() {
        INSTANCE = this;
        dungeonConfig = new DungeonConfig();
    }

    @Override
    public void onDisable() {
        INSTANCE = null;
    }

    public static DungeonPlugin plugin() {
        return INSTANCE;
    }
}
