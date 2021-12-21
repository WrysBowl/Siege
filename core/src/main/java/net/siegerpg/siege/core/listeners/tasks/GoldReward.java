package net.siegerpg.siege.core.listeners.tasks;

import kotlin.Pair;
import net.siegerpg.siege.core.Core;
import net.siegerpg.siege.core.listeners.GoldExpListener;
import net.siegerpg.siege.core.miscellaneous.*;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.server.PluginEnableEvent;
import org.bukkit.scoreboard.Objective;

import java.util.ArrayList;

public class GoldReward implements Listener {

	static public int goldRequirement = 0;
	static public int serverGold = 0;
	static public int serverGoldReward = 0;
	static public ArrayList<Player> players = new ArrayList<>();

	public void giveGold() {

		Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(Core.plugin(), () -> {
			if (Bukkit.getOnlinePlayers().isEmpty()) return;
			Levels.INSTANCE.getExpLevel(new ArrayList< Player >(Bukkit.getOnlinePlayers()),
			                            uuidPairHashMap -> {
				uuidPairHashMap.forEach((uuid, shortIntegerPair) ->
				                        {
				                        	Player p = Bukkit.getPlayer(uuid);
				                        	if (p == null) return;
				                        	int level = shortIntegerPair.getFirst();
				                        	int gold = (int) (level * 50);
				                        	GoldExpListener.giveGold(p, gold);
				                        	p.sendMessage(Utils.parse(""));
				                        	p.sendMessage(Utils.parse(
				                        			"  <yellow>You received " +
							                        gold + " gold for existing!"));
				                        	p.sendMessage(Utils.parse(""));
				                        });
				return null;
			});
			}, 72000, 72000);
	}

	//each player contributes level*2000 gold to requirement
	//if player count drops then requirement also drops, and difference subtracted
	//Gold reward gives 0.5% of gold requirement to everyone

	@EventHandler
	public static void onEnable(PluginEnableEvent e) {
		if (Bukkit.getOnlinePlayers().isEmpty()) return;
		players.addAll(Bukkit.getOnlinePlayers());
		setGoldRequirement();
		BossBars.showGoldProgress();
	}

	public static void addPlayer(PlayerJoinEvent e) {
		Player player = e.getPlayer();
		players.add(player);
		setGoldRequirement();
		BossBars.showGoldProgress();
	}

	public static void removePlayer(PlayerQuitEvent e) {
		Player player = e.getPlayer();
		players.remove(player);
		setGoldRequirement();
		BossBars.showGoldProgress();
	}

	public static void setGoldRequirement() {
		goldRequirement = 2000;
		for (Player player : players) {
			Pair< Short, Integer > levelExp = Levels.INSTANCE.blockingGetExpLevel(player);
			goldRequirement += (levelExp != null ? levelExp.getFirst() : 1) * 2000;
		}

		serverGoldReward = (int)Math.ceil(goldRequirement*0.03);
	}
	public static void addServerGold(int gold) {
		int sum = gold + serverGold;
		if (sum >= goldRequirement) {
			sum -= goldRequirement;
			giveGoldReward();
		}
		serverGold = sum;
		BossBars.showGoldProgress();
	}
	public static void giveGoldReward() {
		for (Player player : players) {
			player.playSound(player.getLocation(), Sound.ENTITY_FIREWORK_ROCKET_LARGE_BLAST, 0.6f, 1.25f);
			VaultHook.econ.depositPlayer(player, serverGoldReward);
			player.sendActionBar(Utils.parse("<yellow>+ " + String.format("%,d", serverGoldReward) + " <yellow>Gold"));
			player.sendTitle("", Utils.tacc("&e+ " + String.format("%,d", serverGoldReward) + " &7Gold!"), 20, 100, 20);
			Scoreboard.updateScoreboard(player);
		}
	}

}
