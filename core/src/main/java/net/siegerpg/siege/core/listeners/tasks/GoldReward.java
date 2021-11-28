package net.siegerpg.siege.core.listeners.tasks;

import net.siegerpg.siege.core.Core;
import net.siegerpg.siege.core.listeners.GoldExpListener;
import net.siegerpg.siege.core.miscellaneous.Levels;
import net.siegerpg.siege.core.miscellaneous.Utils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import java.util.ArrayList;

public class GoldReward implements Listener {

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

}
