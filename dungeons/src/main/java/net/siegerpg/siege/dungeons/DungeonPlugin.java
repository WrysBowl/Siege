package net.siegerpg.siege.dungeons;

import net.siegerpg.siege.dungeons.portals.PortalCommand;
import net.siegerpg.siege.dungeons.portals.PortalConfig;
import net.siegerpg.siege.dungeons.portals.PortalTeleport;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class DungeonPlugin extends JavaPlugin {
    private static DungeonPlugin INSTANCE;

    public DungeonConfig dungeonConfig = null;
    public PortalConfig portalConfig = null;

    @Override
    public void onEnable() {
        INSTANCE = this;
        portalConfig = new PortalConfig(this);

        dungeonConfig = new DungeonConfig();
        dungeonConfig.deserializeDungeonTypes();
        Bukkit.getPluginManager().registerEvents(new PortalTeleport(), this);
        Bukkit.getPluginCommand("portal").setExecutor(new PortalCommand());
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
