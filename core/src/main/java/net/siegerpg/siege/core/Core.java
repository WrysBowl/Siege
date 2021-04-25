package net.siegerpg.siege.core;

import co.aikar.commands.PaperCommandManager;
import net.kyori.adventure.platform.bukkit.BukkitAudiences;
import net.siegerpg.siege.core.commands.PartyCommand;
import net.siegerpg.siege.core.listeners.*;
import net.siegerpg.siege.core.party.Party;
import net.siegerpg.siege.core.party.PartyConfig;
import net.siegerpg.siege.core.party.PartyManager;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@SuppressWarnings("unused")
public final class Core extends JavaPlugin {

    public static Core INSTANCE;

    public static PartyManager partyManager;

    public PartyConfig partyConfig = new PartyConfig(this);

    public BukkitAudiences audiences;

    @Override
    public void onEnable() {
        // Plugin startup logic
        INSTANCE = this;
        audiences = BukkitAudiences.create(this);
        partyManager = new PartyManager();

        PaperCommandManager manager = new PaperCommandManager(this);
        manager.registerCommand(new PartyCommand());
        manager.getCommandCompletions().registerCompletion("partyMembers", c -> {
            Party party = partyManager.getParty(c.getPlayer().getUniqueId());
            List<UUID> members = party.getMembersRaw();
            List<String> names = new ArrayList<>();
            for (UUID member : members) {
                names.add(Bukkit.getPlayer(member).getName());
            }
            return names;
        });

        manager.getCommandCompletions().registerCompletion("partyMembersExcludingSelf", c -> {
            Party party = partyManager.getParty(c.getPlayer().getUniqueId());
            List<UUID> members = party.getMembersRaw();
            List<String> names = new ArrayList<>();
            for (UUID member : members) {
                if (member != c.getPlayer().getUniqueId()) names.add(Bukkit.getPlayer(member).getName());
            }
            return names;
        });

        manager.getCommandCompletions().registerCompletion("nonPartyMembers", c -> {
            Party party = partyManager.getParty(c.getPlayer().getUniqueId());
            List<UUID> members = party.getMembersRaw();
            List<String> names = new ArrayList<>();
            for (UUID member : members) {
                names.add(Bukkit.getPlayer(member).getName());
            }
            List<String> allPlayerNames = Arrays.stream(Bukkit.getOfflinePlayers()).map(OfflinePlayer::getName)
                    .collect(Collectors.toList());

            return allPlayerNames.stream().filter(p -> !(names.contains(p))).collect(Collectors.toList());
        });

        manager.getCommandCompletions().registerCompletion("openToInvite", c -> {
            List<Player> notInParty = Bukkit.getOnlinePlayers().stream()
                    .filter(p -> partyManager.getParty(p.getUniqueId()) == null).collect(Collectors.toList());

            return notInParty.stream().map(Player::getName)
                    .collect(Collectors.toList());
        });

        plugin().getServer().getPluginManager().registerEvents(new BlockBreakListener(), this);
        plugin().getServer().getPluginManager().registerEvents(new ChatListener(), this);
        plugin().getServer().getPluginManager().registerEvents(new CustomCraftingEvents(), this);
        plugin().getServer().getPluginManager().registerEvents(new DamageIndicatorListener(), this);
        plugin().getServer().getPluginManager().registerEvents(new DeathListener(), this);
        plugin().getServer().getPluginManager().registerEvents(new InventoryCloseListener(), this);
        plugin().getServer().getPluginManager().registerEvents(new ItemPickupListener(), this);
        plugin().getServer().getPluginManager().registerEvents(new PlayerJoinListener(), this);
        plugin().getServer().getPluginManager().registerEvents(new PlayerQuitListener(), this);
        plugin().getServer().getPluginManager().registerEvents(new StatGemListener(), this);
        plugin().getServer().getPluginManager().registerEvents(new WorldProtectionListener(), this);
        plugin().getServer().getPluginManager().registerEvents(new PortalEnterListener(), this);
        plugin().getServer().getPluginManager().registerEvents(new InventoryClickListener(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        INSTANCE = null;
        partyManager.saveAll();
    }

    public static Core plugin() {
        return INSTANCE; // Method to get the plugin from other classes, so you can use Core.plugin() in other classes to get the plugin
    }

}
