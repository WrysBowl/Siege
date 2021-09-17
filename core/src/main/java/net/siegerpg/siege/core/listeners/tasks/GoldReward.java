package net.siegerpg.siege.core.listeners.tasks;

import net.siegerpg.siege.core.Core;
import net.siegerpg.siege.core.listeners.GoldExpListener;
import net.siegerpg.siege.core.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class GoldReward implements Listener {

    public void giveGold() {
        Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(Core.plugin(), () -> {
            for (Player p : Bukkit.getOnlinePlayers()) {
                int level = LevelEXPStorage.playerLevel.get(p);
                int gold = level*10;
                GoldExpListener.giveGold(p, gold);
                p.sendMessage(Utils.parse(""));
                p.sendMessage(Utils.parse("  <yellow>You received "+gold+" gold for existing!"));
                p.sendMessage(Utils.parse(""));

            }
        }, 72000, 72000);
    }
}
