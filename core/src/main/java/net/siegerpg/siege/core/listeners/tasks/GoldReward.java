package net.siegerpg.siege.core.listeners.tasks;

import kotlin.Pair;
import net.siegerpg.siege.core.Core;
import net.siegerpg.siege.core.listeners.GoldExpListener;
import net.siegerpg.siege.core.listeners.PlayerJoinListener;
import net.siegerpg.siege.core.miscellaneous.Levels;
import net.siegerpg.siege.core.miscellaneous.Utils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.ArrayList;

public class GoldReward implements Listener {

	static public int serverGold = 0;

	public void giveGold() {

		Bukkit
				.getServer()
				.getScheduler()
				.scheduleSyncRepeatingTask(Core.plugin(), () -> {
					if (Bukkit
							.getOnlinePlayers()
							.isEmpty()) return;
					Levels.INSTANCE.getExpLevel(
							new ArrayList< Player >(Bukkit.getOnlinePlayers()),
							uuidPairHashMap -> {
								uuidPairHashMap.forEach((uuid, shortIntegerPair) ->
								                        {
									                        Player p = Bukkit.getPlayer(uuid);
									                        if (p == null) return;
									                        int level = shortIntegerPair.getFirst();
									                        int gold = (int)
											                        (level * 50);
									                        GoldExpListener.giveGold(p, gold);
									                        p.sendMessage(Utils.parse(""));
									                        p.sendMessage(Utils.parse(
											                        "  <yellow>You received " +
											                        gold + " gold for existing!"));
									                        p.sendMessage(Utils.parse(""));
								                        });
								return null;
							}
					                           );
				}, 72000, 72000);
	}

	//each player contributes level*2000 gold to requirement
	//if player count drops then requirement also drops, and difference subtracted
	//Gold reward gives 0.5% of gold requirement to everyone

	public void addRequirement(PlayerJoinEvent e) {
		Player player = e.getPlayer();
		Pair< Short, Integer > levelExp = Levels.INSTANCE.blockingGetExpLevel(player);
		serverGold += (levelExp != null ? levelExp.getFirst() : 1) * 2000;
	}

	public void removeRequirement(PlayerQuitEvent e) {
		Player player = e.getPlayer();
		Pair< Short, Integer > levelExp = Levels.INSTANCE.blockingGetExpLevel(player);
		serverGold -= (levelExp != null ? levelExp.getFirst() : 1) * 2000;
	}

}
