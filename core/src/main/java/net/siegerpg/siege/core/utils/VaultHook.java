package net.siegerpg.siege.core.utils;

import net.milkbowl.vault.chat.Chat;
import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.permission.Permission;
import net.siegerpg.siege.core.Core;
import org.bukkit.Bukkit;
import org.bukkit.plugin.RegisteredServiceProvider;

import static org.bukkit.Bukkit.getServer;

public class VaultHook {
    public static Economy econ;
    public static Permission perms;
    public static Chat chat;

    public void createHooks() {
        if (!this.setupEconomy()) {
            Core.plugin().getLogger().severe("Vault was not found!");
            getServer().getPluginManager().disablePlugin(Core.plugin());
            return;
        }
        this.setupPermissions();
        this.setupChat();
    }

    private boolean setupEconomy() {
        if (getServer().getPluginManager().getPlugin("Vault") == null) {
            return false;
        }
        final RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
        if (rsp == null) {
            return false;
        }
        VaultHook.econ = rsp.getProvider();
        return VaultHook.econ != null;
    }

    private void setupChat() {
        final RegisteredServiceProvider<Chat> rsp = getServer().getServicesManager().getRegistration(Chat.class);
        VaultHook.chat = rsp.getProvider();
    }

    private void setupPermissions() {
        final RegisteredServiceProvider<Permission> rsp = getServer().getServicesManager().getRegistration(Permission.class);
        VaultHook.perms = rsp.getProvider();
    }
}
