package net.siegerpg.siege.core.utils;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.HashMap;

public class PlayerBanking implements Listener {

    public static HashMap<Player, Short> bankLevels = new HashMap<>();
    public static HashMap<Player, Integer> bankAmounts = new HashMap<>();

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        bankLevels.put(e.getPlayer(), Bank.INSTANCE.getBankLevel(e.getPlayer()));
        bankAmounts.put(e.getPlayer(), Bank.INSTANCE.getBankAmount(e.getPlayer()));
    }

}
