package net.siegerpg.siege.core.utils.cache;

import net.siegerpg.siege.core.utils.Levels;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.HashMap;

public class LevelEXPStorage implements Listener {

    public static HashMap<Player, Short> playerLevel = new HashMap<>();
    public static HashMap<Player, Integer> playerExperience = new HashMap<>();

    public LevelEXPStorage() {
        for (Player player : Bukkit.getOnlinePlayers()){
            playerLevel.put(player, Levels.INSTANCE.getExpLevel(player).getFirst());
            playerExperience.put(player, Levels.INSTANCE.getExpLevel(player).getSecond());
        }
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();
        playerLevel.put(player, Levels.INSTANCE.getExpLevel(player).getFirst());
        playerExperience.put(player, Levels.INSTANCE.getExpLevel(player).getSecond());
    }
}
