package net.siegerpg.siege.dungeons;

import net.siegerpg.siege.dungeons.portals.PortalCommand;
import net.siegerpg.siege.dungeons.portals.PortalConfig;
import net.siegerpg.siege.dungeons.portals.PortalTeleport;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class DungeonPlugin extends JavaPlugin {
    private static DungeonPlugin INSTANCE;

    public DungeonConfig dungeonConfig;
    public PortalConfig portalConfig;

    @Override
    public void onEnable() {
	    DungeonPlugin.INSTANCE = this;
	    this.portalConfig = new PortalConfig(this);

	    this.dungeonConfig = new DungeonConfig();
	    this.dungeonConfig.deserializeDungeonTypes();
        Bukkit.getPluginManager().registerEvents(new PortalTeleport(), this);
        Bukkit.getPluginManager().registerEvents(new DungeonRejoin(this), this);
        Bukkit.getPluginCommand("portal").setExecutor(new PortalCommand());
	    this.getLogger().info("SiegeDungeons has enabled!");
    }

    @Override
    public void onDisable() {
	    DungeonPlugin.INSTANCE = null;
    }

    /**
     * Method to get the plugin from other classes
     * You can use Core.plugin() in other classes to get the plugin instance
     *
     * @return The main plugin
     */
    public static DungeonPlugin plugin() {
        return DungeonPlugin.INSTANCE;
    }
}
