package net.siegerpg.siege.core;

import co.aikar.commands.PaperCommandManager;
import com.gmail.filoghost.holographicdisplays.api.Hologram;
import io.github.retrooper.packetevents.PacketEvents;
import io.github.retrooper.packetevents.settings.PacketEventsSettings;
import io.github.retrooper.packetevents.utils.server.ServerVersion;
import net.siegerpg.siege.core.commands.*;
import net.siegerpg.siege.core.commands.admin.*;
import net.siegerpg.siege.core.crates.CrateOpen;
import net.siegerpg.siege.core.dungeons.DungeonCommand;
import net.siegerpg.siege.core.dungeons.DungeonListener;
import net.siegerpg.siege.core.miscellaneous.BossLeaderboardListener;
import net.siegerpg.siege.core.fishing.events.FishEvent;
import net.siegerpg.siege.core.fishing.events.RightClickEvent;
import net.siegerpg.siege.core.listeners.ArmorEquip.ArmorListener;
import net.siegerpg.siege.core.listeners.*;
import net.siegerpg.siege.core.listeners.NPC.*;
import net.siegerpg.siege.core.listeners.tasks.GoldReward;
import net.siegerpg.siege.core.listeners.tasks.HelpfulTips;
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
import org.bukkit.command.CommandExecutor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

@SuppressWarnings( "unused" )
public final class Core extends JavaPlugin {

	public static Color defaultLeatherColor;
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

	/**
	 * Method to get the spawn location
	 */
	public Location getHubSpawnLocation() {

		Location spawnLocation =
				Objects
						.requireNonNull(Bukkit
								                .getWorld("Hub"))
						.getSpawnLocation();
		spawnLocation.setYaw(168);
		return spawnLocation;
	}

	public ArrayList< Hologram > hologramsToBeDeleted = new ArrayList<>();

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


		commandManager.registerCommand(new BossLeaderboardCommand());
		commandManager.registerCommand(new PartyCommand());


		// The list of commands to register.
		// This is done in order to stop repeating everything tons of times
		HashMap< String, CommandExecutor > commandList = new HashMap<>();
		{
			commandList.put("hub", new Hub());
			commandList.put("setBed", new SetRespawn());
			commandList.put("help", new Help());
			commandList.put("discord", new Discord());
			commandList.put("webstore", new Webstore());
			commandList.put("getItem", new GetItem());
			commandList.put("spawn", new Spawn());
			commandList.put("invsee", new Invsee());
			commandList.put("leaderboard", new Leaderboard());
			commandList.put("level", new Level());
			commandList.put("buy", new WebstoreCommand());
			commandList.put("tips", new ToggleTips());
			commandList.put("getBooster", new GetBooster());
			commandList.put("updateScoreboard", new UpdateScoreboard());
			commandList.put("spawnExp", new SpawnExp());
			commandList.put("spawnGold", new SpawnGold());
			commandList.put("pay", new Pay());
			commandList.put("getKey", new GetKey());
			commandList.put("stats", new Stats());
			commandList.put("dungeon", new DungeonCommand());
			commandList.put("statUpgrade", new StatUpgrade());
			commandList.put("drops", new DropTable());

		}

		commandList.forEach((str, ex) -> this
				.getCommand(str)
				.setExecutor(ex));


		// The list of listeners to register.
		// This is done in order to stop repeating everything tons of times
		Listener[] listeners = new Listener[] {
				new BossLeaderboardListener(),
				new DropUtils(),
				new BlockBreakListener(),
				new ChatListener(),
				new DeathListener(),
				new InventoryCloseListener(),
				new GoldExpListener(),
				new PlayerJoinListener(),
				new PlayerQuitListener(),
				new StatGemListener(),
				new GemRemover(),
				new WorldListener(),
				new PortalEnterListener(),
				new TutorialListeners(),
				new FishEvent(),
				new RightClickEvent(),
				new PlayerData(),
				new EntityTeleportListener(),
				new HelpfulTips(),
				new GoldReward(),
				new CrateOpen(),
				new MobNames(),
				new SkillListener(),
				new DungeonListener(),
				new WebstoreListener(),
				new SmokyBlacksmith(),
				new MeraTransit(),
				new SymoneCollector(),
				new MeraTransit(),
				new RichardBanker(),
				new BartBeggar(),
				new Herbert(),
				new PerksTrader(),
				new Henry(),
				new ArmorListener(getConfig().getStringList("blocked")),
				new StatChangeListener(),
				new CosmeticsListener(),
				new CustomItemKotlinListener()
		};

		for (Listener listener : listeners) {
			getServer()
					.getPluginManager()
					.registerEvents(listener, this);
		}

		SmokyBlacksmith.resetItems();
		StatChangeListener.statBarDisplayTask();
		new RegenerationTask().startRegenTask();
		new HelpfulTips().broadcastTasks();
		new GoldReward().giveGold();

//        CustomRecipe recipe = new CustomRecipe();
//        recipe.s1(Pebble.Companion.tier(1));
//        CustomRecipe.Companion.registerRecipe(recipe);


		// Deserialize all parties
		partyConfig.initializeAllFromConfig();

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

		hologramsToBeDeleted.forEach(Hologram::delete);
		INSTANCE = null;
	}

}
