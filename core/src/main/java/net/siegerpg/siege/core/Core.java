package net.siegerpg.siege.core;

import co.aikar.commands.PaperCommandManager;
import net.kyori.adventure.platform.bukkit.BukkitAudiences;
import net.siegerpg.siege.core.commands.PartyCommand;
import net.siegerpg.siege.core.party.Party;
import net.siegerpg.siege.core.party.PartyManager;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@SuppressWarnings("unused")
public final class Core extends JavaPlugin {

    public static Core INSTANCE;

    public static PartyManager partyManager = new PartyManager();

    public BukkitAudiences audiences;

    @Override
    public void onEnable() {
        // Plugin startup logic
        INSTANCE = this;
        audiences = BukkitAudiences.create(this);


        PaperCommandManager manager = new PaperCommandManager(this);
        manager.registerCommand(new PartyCommand());
        manager.getCommandCompletions().registerCompletion("partyMembers", c -> {
            Party party = partyManager.getParty(c.getPlayer().getUniqueId());
            List<UUID> members = party.getMembersRaw();
            List<String> names = new ArrayList<String>();
            for (UUID member : members) {
                names.add(Bukkit.getPlayer(member).getName());
            }
            return names;
        });

        manager.getCommandCompletions().registerCompletion("partyMembersExcludingSelf", c -> {
            Party party = partyManager.getParty(c.getPlayer().getUniqueId());
            List<UUID> members = party.getMembersRaw();
            List<String> names = new ArrayList<String>();
            for (UUID member : members) {
                if (member != c.getPlayer().getUniqueId()) names.add(Bukkit.getPlayer(member).getName());
            }
            return names;
        });

        manager.getCommandCompletions().registerCompletion("nonPartyMembers", c -> {
            Party party = partyManager.getParty(c.getPlayer().getUniqueId());
            List<UUID> members = party.getMembersRaw();
            List<String> names = new ArrayList<String>();
            for (UUID member : members) {
                names.add(Bukkit.getPlayer(member).getName());
            }
            List<String> allPlayerNames = Arrays.stream(Bukkit.getOfflinePlayers()).map(OfflinePlayer::getName)
                    .collect(Collectors.toList());

            return allPlayerNames.stream().filter(p -> !(names.contains(p))).collect(Collectors.toList());
        });

        manager.getCommandCompletions().registerCompletion("openToInvite", c -> {
            Party party = partyManager.getParty(c.getPlayer().getUniqueId());
            List<UUID> members = party.getMembersRaw();
            List<String> names = new ArrayList<String>();
            for (UUID member : members) {
                names.add(Bukkit.getPlayer(member).getName());
            }
            List<OfflinePlayer> notInParty = Bukkit.getOnlinePlayers().stream().filter(p -> partyManager.getParty(p.getUniqueId()) == null).collect(Collectors.toList());
            List<String> allPlayerNames = notInParty.stream().map(OfflinePlayer::getName)
                    .collect(Collectors.toList());

            return allPlayerNames;
        });

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        partyManager.saveAll();
    }
}
