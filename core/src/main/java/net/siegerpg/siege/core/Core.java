package net.siegerpg.siege.core;

import net.siegerpg.siege.core.commands.Hub;
import net.siegerpg.siege.core.listeners.RegenerationTask;
import net.siegerpg.siege.core.listeners.*;
import net.siegerpg.siege.core.party.PartyManager;
import net.siegerpg.siege.core.utils.VaultHook;
import org.bukkit.Color;
import org.bukkit.plugin.java.JavaPlugin;

@SuppressWarnings("unused")
public final class Core extends JavaPlugin {

    public static Core INSTANCE;

    public static PartyManager partyManager;

    public static Color defaultLeatherColor;

//    public PartyConfig partyConfig = new PartyConfig();

    @Override
    public void onEnable() {
        // Plugin startup logic
        INSTANCE = this;
        defaultLeatherColor = this.getServer().getItemFactory().getDefaultLeatherColor();
        (new VaultHook()).createHooks();

        this.getCommand("hub").setExecutor(new Hub());

        //partyManager = new PartyManager();

//        PaperCommandManager manager = new PaperCommandManager(this);
//        manager.registerCommand(new PartyCommand());
//        manager.getCommandCompletions().registerCompletion("partyMembers", c -> {
//            Party party = partyManager.getParty(c.getPlayer().getUniqueId());
//            List<UUID> members = party.getMembersRaw();
//            List<String> names = new ArrayList<>();
//            for (UUID member : members) {
//                names.add(Bukkit.getPlayer(member).getName());
//            }
//            return names;
//        });
//
//        manager.getCommandCompletions().registerCompletion("partyMembersExcludingSelf", c -> {
//            Party party = partyManager.getParty(c.getPlayer().getUniqueId());
//            List<UUID> members = party.getMembersRaw();
//            List<String> names = new ArrayList<>();
//            for (UUID member : members) {
//                if (member != c.getPlayer().getUniqueId()) names.add(Bukkit.getPlayer(member).getName());
//            }
//            return names;
//        });
//
//        manager.getCommandCompletions().registerCompletion("nonPartyMembers", c -> {
//            Party party = partyManager.getParty(c.getPlayer().getUniqueId());
//            List<UUID> members = party.getMembersRaw();
//            List<String> names = new ArrayList<>();
//            for (UUID member : members) {
//                names.add(Bukkit.getPlayer(member).getName());
//            }
//            List<String> allPlayerNames = Arrays.stream(Bukkit.getOfflinePlayers()).map(OfflinePlayer::getName)
//                    .collect(Collectors.toList());
//
//            return allPlayerNames.stream().filter(p -> !(names.contains(p))).collect(Collectors.toList());
//        });
//
//        manager.getCommandCompletions().registerCompletion("openToInvite", c -> {
//            List<Player> notInParty = Bukkit.getOnlinePlayers().stream()
//                    .filter(p -> partyManager.getParty(p.getUniqueId()) == null).collect(Collectors.toList());
//
//            return notInParty.stream().map(Player::getName)
//                    .collect(Collectors.toList());
//        });
        // TODO: uncomment this when working on party command


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

        plugin().getServer().getPluginManager().registerEvents(new CustomItemKotlinListener(), this);
        new RegenerationTask().startRegenTask();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        INSTANCE = null;
//        partyManager.saveAll();
    }

    public static Core plugin() {
        return INSTANCE; // Method to get the plugin from other classes, so you can use Core.plugin() in other classes to get the plugin
    }

}
