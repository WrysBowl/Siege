package net.siegerpg.siege.core;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

@SuppressWarnings("unused")
public final class Core extends JavaPlugin {

    public static Core INSTANCE;

    @Override
    public void onEnable() {
        // Plugin startup logic
        INSTANCE = this;
        Bukkit.getLogger().info("wow this works");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
