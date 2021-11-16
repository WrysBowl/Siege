package net.siegerpg.siege.core;

import co.aikar.commands.PaperCommandManager;
import io.github.retrooper.packetevents.PacketEvents;
import io.github.retrooper.packetevents.settings.PacketEventsSettings;
import io.github.retrooper.packetevents.utils.server.ServerVersion;
import net.siegerpg.siege.core.commands.*;
import net.siegerpg.siege.core.commands.admin.*;
import net.siegerpg.siege.core.crates.CrateOpen;
import net.siegerpg.siege.core.dungeons.DungeonCommand;
import net.siegerpg.siege.core.dungeons.DungeonListener;
import net.siegerpg.siege.core.events.BossLeaderboardListener;
import net.siegerpg.siege.core.fishing.events.FishEvent;
import net.siegerpg.siege.core.fishing.events.RightClickEvent;
import net.siegerpg.siege.core.listeners.ArmorEquip.ArmorListener;
import net.siegerpg.siege.core.listeners.*;
import net.siegerpg.siege.core.listeners.NPC.*;
import net.siegerpg.siege.core.listeners.tasks.GoldReward;
import net.siegerpg.siege.core.listeners.tasks.HelpfulTips;
import net.siegerpg.siege.core.miscellaneous.DamageIndicator;
import net.siegerpg.siege.core.miscellaneous.DropUtils;
import net.siegerpg.siege.core.miscellaneous.VaultHook;
import net.siegerpg.siege.core.miscellaneous.cache.MobNames;
import net.siegerpg.siege.core.miscellaneous.cache.PlayerData;
import net.siegerpg.siege.core.parties.PartyCommand;
import net.siegerpg.siege.core.parties.PartyConfig;
import net.siegerpg.siege.core.skills.SkillListener;
import net.siegerpg.siege.core.webstore.WebstoreCommand;
import net.siegerpg.siege.core.webstore.WebstoreListener;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.plugin.java.JavaPlugin;

@SuppressWarnings( "unused" )
public final class Core extends JavaPlugin {

	public static Color defaultLeatherColor;
	public static Location spawnLocation;
	private static Core INSTANCE;
	public PaperCommandManager commandManager;
	public PartyConfig partyConfig;

	/**
	 * Method to get the plugin from other classes
	 * You can use Core.plugin() in other classes to get the plugin instance
	 *
	 * @return The main plugin
	 */
	public static Core plugin() {

		return INSTANCE;
	}

	@Override
	public void onLoad() {
		// Set up packetevents
		PacketEvents.create(this);
		PacketEventsSettings settings = PacketEvents
				.get()
				.getSettings();
		settings
				.fallbackServerVersion(ServerVersion.v_1_16_5)
				.compatInjector(true)
				.checkForUpdates(false);
		PacketEvents
				.get()
				.loadAsyncNewThread();
	}

	@Override
	public void onEnable() {
		// Plugin startup logic
		INSTANCE = this;

		// Load packetevents
		PacketEvents
				.get()
				.registerListener(new DropUtils());
		PacketEvents
				.get()
				.init();

		// Other
		partyConfig = new PartyConfig();
		commandManager = new PaperCommandManager(this);
		defaultLeatherColor = this
				.getServer()
				.getItemFactory()
				.getDefaultLeatherColor();
		(new VaultHook()).createHooks();

		spawnLocation = Bukkit
				.getWorld("Hub")
				.getSpawnLocation();

		commandManager.registerCommand(new BossLeaderboardCommand());
		commandManager.registerCommand(new PartyCommand());
		this
				.getCommand("hub")
				.setExecutor(new Hub());
		this
				.getCommand("setBed")
				.setExecutor(new SetRespawn());
		this
				.getCommand("help")
				.setExecutor(new Help());
		this
				.getCommand("discord")
				.setExecutor(new Discord());
		this
				.getCommand("webstore")
				.setExecutor(new Webstore());
		this
				.getCommand("getItem")
				.setExecutor(new GetItem());
		this
				.getCommand("spawn")
				.setExecutor(new Spawn());
		this
				.getCommand("invsee")
				.setExecutor(new Invsee());
		this
				.getCommand("leaderboard")
				.setExecutor(new Leaderboard());
		this
				.getCommand("level")
				.setExecutor(new Level());
		this
				.getCommand("buy")
				.setExecutor(new WebstoreCommand());
		this
				.getCommand("tips")
				.setExecutor(new ToggleTips());
		this
				.getCommand("getBooster")
				.setExecutor(new GetBooster());
		this
				.getCommand("updateScoreboard")
				.setExecutor(new UpdateScoreboard());
		this
				.getCommand("spawnExp")
				.setExecutor(new SpawnExp());
		this
				.getCommand("spawnGold")
				.setExecutor(new SpawnGold());
		this
				.getCommand("pay")
				.setExecutor(new Pay());
		this
				.getCommand("getKey")
				.setExecutor(new GetKey());
		this
				.getCommand("stats")
				.setExecutor(new Stats());
		this
				.getCommand("dungeon")
				.setExecutor(new DungeonCommand());


		getServer()
				.getPluginManager()
				.registerEvents(new BossLeaderboardListener(), this);
		getServer()
				.getPluginManager()
				.registerEvents(new DropUtils(), this);
		getServer()
				.getPluginManager()
				.registerEvents(new BlockBreakListener(), this);
		getServer()
				.getPluginManager()
				.registerEvents(new ChatListener(), this);
		getServer()
				.getPluginManager()
				.registerEvents(new DeathListener(), this);
		getServer()
				.getPluginManager()
				.registerEvents(new InventoryCloseListener(), this);
		getServer()
				.getPluginManager()
				.registerEvents(new GoldExpListener(), this);
		getServer()
				.getPluginManager()
				.registerEvents(new PlayerJoinListener(), this);
		getServer()
				.getPluginManager()
				.registerEvents(new PlayerQuitListener(), this);
		getServer()
				.getPluginManager()
				.registerEvents(new StatGemListener(), this);
		getServer()
				.getPluginManager()
				.registerEvents(new GemRemover(), this);
		getServer()
				.getPluginManager()
				.registerEvents(new WorldListener(), this);
		getServer()
				.getPluginManager()
				.registerEvents(new PortalEnterListener(), this);
		getServer()
				.getPluginManager()
				.registerEvents(new TutorialListeners(), this);
		getServer()
				.getPluginManager()
				.registerEvents(new FishEvent(), this);
		getServer()
				.getPluginManager()
				.registerEvents(new RightClickEvent(), this);
		getServer()
				.getPluginManager()
				.registerEvents(new PlayerData(), this);
		getServer()
				.getPluginManager()
				.registerEvents(new EntityTeleportListener(), this);
		getServer()
				.getPluginManager()
				.registerEvents(new HelpfulTips(), this);
		getServer()
				.getPluginManager()
				.registerEvents(new GoldReward(), this);
		getServer()
				.getPluginManager()
				.registerEvents(new CrateOpen(), this);

		getServer()
				.getPluginManager()
				.registerEvents(new MobNames(), this);
		getServer()
				.getPluginManager()
				.registerEvents(new SkillListener(), this);
		getServer()
				.getPluginManager()
				.registerEvents(new DungeonListener(), this);


		getServer()
				.getPluginManager()
				.registerEvents(new WebstoreListener(), this);
		getServer()
				.getPluginManager()
				.registerEvents(new SmokyBlacksmith(), this);
		getServer()
				.getPluginManager()
				.registerEvents(new MeraTransit(), this);
		getServer()
				.getPluginManager()
				.registerEvents(new SymoneCollector(), this);
		getServer()
				.getPluginManager()
				.registerEvents(new BenButcher(), this);
		getServer()
				.getPluginManager()
				.registerEvents(new RichardBanker(), this);
		getServer()
				.getPluginManager()
				.registerEvents(new BartBeggar(), this);
		getServer()
				.getPluginManager()
				.registerEvents(new Herbert(), this);
		getServer()
				.getPluginManager()
				.registerEvents(new PerksTrader(), this);
		getServer()
				.getPluginManager()
				.registerEvents(new Henry(), this);

		getServer()
				.getPluginManager()
				.registerEvents(new ArmorListener(getConfig().getStringList("blocked")), this);
		getServer()
				.getPluginManager()
				.registerEvents(new StatChangeListener(), this);
		getServer()
				.getPluginManager()
				.registerEvents(new CosmeticsListener(), this);
		getServer()
				.getPluginManager()
				.registerEvents(new DamageIndicator(), this);


		SmokyBlacksmith.resetItems();
		StatChangeListener.statBarDisplayTask();
		getServer()
				.getPluginManager()
				.registerEvents(new CustomItemKotlinListener(), this);
		new RegenerationTask().startRegenTask();
		new HelpfulTips().broadcastTasks();
		new GoldReward().giveGold();

//        CustomRecipe recipe = new CustomRecipe();
//        recipe.s1(Pebble.Companion.tier(1));
//        CustomRecipe.Companion.registerRecipe(recipe);


	}

	/**
	 * Plugin shutdown logic.
	 */
	@Override
	public void onDisable() {
		// Stop packetevents
		PacketEvents
				.get()
				.terminate();
		INSTANCE = null;
	}

}
