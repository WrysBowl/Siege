package net.siegerpg.siege.core;

import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.ProtocolManager;
import net.siegerpg.siege.core.Webstore.RedeemBoosters;
import net.siegerpg.siege.core.Webstore.WebstoreCommand;
import net.siegerpg.siege.core.commands.admin.*;
import net.siegerpg.siege.core.listeners.tasks.GoldReward;
import net.siegerpg.siege.core.skills.SkillListener;
import net.siegerpg.siege.core.utils.cache.LevelEXPStorage;
import net.siegerpg.siege.core.utils.cache.MobNames;
import net.siegerpg.siege.core.utils.cache.PlayerBanking;
import net.siegerpg.siege.core.utils.cache.PlayerData;
import net.siegerpg.siege.core.commands.*;
import net.siegerpg.siege.core.fishing.commands.getBait;
import net.siegerpg.siege.core.fishing.events.FishEvent;
import net.siegerpg.siege.core.fishing.events.RightClickEvent;
import net.siegerpg.siege.core.items.recipes.CustomRecipe;
import net.siegerpg.siege.core.listeners.ArmorEquip.ArmorListener;
import net.siegerpg.siege.core.listeners.*;
import net.siegerpg.siege.core.listeners.NPC.*;
import net.siegerpg.siege.core.party.PartyConfig;
import net.siegerpg.siege.core.party.PartyManager;
import net.siegerpg.siege.core.listeners.tasks.HelpfulTips;
import net.siegerpg.siege.core.utils.VaultHook;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.plugin.java.JavaPlugin;

@SuppressWarnings("unused")
public final class Core extends JavaPlugin {

    private static Core INSTANCE;

    public static PartyManager partyManager;

    public static Color defaultLeatherColor;

    public PartyConfig partyConfig = new PartyConfig(this);

    public static Location spawnLocation;

    public static ProtocolManager protocolManager;

    @Override
    public void onEnable() {
        // Plugin startup logic
        INSTANCE = this;
        defaultLeatherColor = this.getServer().getItemFactory().getDefaultLeatherColor();
        (new VaultHook()).createHooks();

        spawnLocation = new Location(Bukkit.getWorld("SiegeHub"), 70.5, 71, 3.5, 90, 0);
        protocolManager = ProtocolLibrary.getProtocolManager();
        this.getCommand("hub").setExecutor(new Hub());
        this.getCommand("discord").setExecutor(new Discord());
        this.getCommand("webstore").setExecutor(new Webstore());
        this.getCommand("getItem").setExecutor(new GetItem());
        this.getCommand("spawn").setExecutor(new Spawn());
        this.getCommand("invsee").setExecutor(new Invsee());
        this.getCommand("leaderboard").setExecutor(new Leaderboard());
        this.getCommand("level").setExecutor(new Level());
        this.getCommand("buy").setExecutor(new WebstoreCommand());
        this.getCommand("tips").setExecutor(new ToggleTips());
        this.getCommand("getBooster").setExecutor(new GetBooster());
        this.getCommand("updateScoreboard").setExecutor(new UpdateScoreboard());
        this.getCommand("spawnExp").setExecutor(new SpawnExp());
        this.getCommand("spawnGold").setExecutor(new SpawnGold());
        this.getCommand("getBait").setExecutor(new getBait());
        this.getCommand("pay").setExecutor(new Pay());
        this.getCommand("getKey").setExecutor(new GetKey());
        this.getCommand("stats").setExecutor(new Stats());



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


        getServer().getPluginManager().registerEvents(new BlockBreakListener(), this);
        getServer().getPluginManager().registerEvents(new ChatListener(), this);
        getServer().getPluginManager().registerEvents(new DamageIndicatorListener(), this);
        getServer().getPluginManager().registerEvents(new DeathListener(), this);
        getServer().getPluginManager().registerEvents(new InventoryCloseListener(), this);
        getServer().getPluginManager().registerEvents(new GoldExpListener(), this);
        getServer().getPluginManager().registerEvents(new PlayerJoinListener(), this);
        getServer().getPluginManager().registerEvents(new PlayerQuitListener(), this);
        getServer().getPluginManager().registerEvents(new StatGemListener(), this);
        getServer().getPluginManager().registerEvents(new GemRemover(), this);
        getServer().getPluginManager().registerEvents(new WorldListener(), this);
        getServer().getPluginManager().registerEvents(new PortalEnterListener(), this);
        getServer().getPluginManager().registerEvents(new CustomCraftingEvents(), this);
        getServer().getPluginManager().registerEvents(new PlayerBanking(), this);
        getServer().getPluginManager().registerEvents(new TutorialListeners(), this);
        getServer().getPluginManager().registerEvents(new FishEvent(), this);
        getServer().getPluginManager().registerEvents(new RightClickEvent(), this);
        getServer().getPluginManager().registerEvents(new LevelEXPStorage(), this);
        getServer().getPluginManager().registerEvents(new PlayerData(), this);
        getServer().getPluginManager().registerEvents(new EntityTeleportListener(), this);
        getServer().getPluginManager().registerEvents(new HelpfulTips(), this);
        getServer().getPluginManager().registerEvents(new GoldReward(), this);

        getServer().getPluginManager().registerEvents(new MobNames(), this);
        getServer().getPluginManager().registerEvents(new SkillListener(), this);


        getServer().getPluginManager().registerEvents(new RedeemBoosters(), this);
        getServer().getPluginManager().registerEvents(new SmokyBlacksmith(), this);
        getServer().getPluginManager().registerEvents(new MeraTransit(), this);
        getServer().getPluginManager().registerEvents(new SymoneCollector(), this);
        getServer().getPluginManager().registerEvents(new BenButcher(), this);
        getServer().getPluginManager().registerEvents(new RichardBanker(), this);
        getServer().getPluginManager().registerEvents(new BartBeggar(), this);
        getServer().getPluginManager().registerEvents(new Herbert(), this);
        getServer().getPluginManager().registerEvents(new PerksTrader(), this);
        getServer().getPluginManager().registerEvents(new Henry(), this);

        getServer().getPluginManager().registerEvents(new ArmorListener(getConfig().getStringList("blocked")), this);
        getServer().getPluginManager().registerEvents(new StatChangeListener(), this);
        SmokyBlacksmith.resetItems();
        StatChangeListener.statBarDisplayTask();
        getServer().getPluginManager().registerEvents(new CustomItemKotlinListener(), this);
        getServer().getPluginManager().registerEvents(new VanillaCraftingListener(), this);
        new RegenerationTask().startRegenTask();
        new HelpfulTips().broadcastTasks();
        new GoldReward().giveGold();
        CustomRecipe.Companion.registerAllRecipes();

//        CustomRecipe recipe = new CustomRecipe();
//        recipe.s1(Pebble.Companion.tier(1));
//        CustomRecipe.Companion.registerRecipe(recipe);
        Bukkit.getLogger().info(String.valueOf(CustomRecipe.Companion.getRecipes().size()));



    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        INSTANCE = null;
//        partyManager.saveAll();
    }

    /**
     * Method to get the plugin from other classes
     * You can use Core.plugin() in other classes to get the plugin instance
     *
     * @return The main plugin
     */
    public static Core plugin() {
        return INSTANCE;
    }

}
