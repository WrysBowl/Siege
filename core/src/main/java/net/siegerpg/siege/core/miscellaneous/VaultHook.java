package net.siegerpg.siege.core.miscellaneous;

import net.milkbowl.vault.chat.Chat;
import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.permission.Permission;
import net.siegerpg.siege.core.Core;
import org.bukkit.Bukkit;
import org.bukkit.plugin.RegisteredServiceProvider;

import static org.bukkit.Bukkit.getServer;

public class VaultHook {

	public static Economy econ = null;
	public static Permission perms = null;
	public static Chat chat = null;

	public void createHooks () {

		if (!setupEconomy()) {
			Core.plugin().getLogger().severe("Vault was not found!");
			getServer().getPluginManager().disablePlugin(Core.plugin());
			return;
		}
		setupPermissions();
		setupChat();
	}

	private boolean setupEconomy () {

		if (Bukkit.getServer().getPluginManager().getPlugin("Vault") == null) {
			return false;
		}
		RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
		if (rsp == null) {
			return false;
		}
		econ = rsp.getProvider();
		return econ != null;
	}

	private void setupChat () {

		RegisteredServiceProvider<Chat> rsp = getServer().getServicesManager().getRegistration(Chat.class);
		chat = rsp.getProvider();
	}

	private void setupPermissions () {

		RegisteredServiceProvider<Permission> rsp = getServer().getServicesManager().getRegistration(Permission.class);
		perms = rsp.getProvider();
	}

}
