package net.siegerpg.siege.core.utils.cache;

import net.siegerpg.siege.core.utils.Bank;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.HashMap;

public class PlayerBanking implements Listener {

    public static HashMap<Player, Short> bankLevels = new HashMap<>();
    public static HashMap<Player, Integer> bankAmounts = new HashMap<>();

    public PlayerBanking() {
        for (Player player : Bukkit.getOnlinePlayers()){
            PlayerBanking.bankLevels.put(player, Bank.INSTANCE.getBankLevel(player));
            PlayerBanking.bankAmounts.put(player, Bank.INSTANCE.getBankAmount(player));
        }
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        bankLevels.put(e.getPlayer(), Bank.INSTANCE.getBankLevel(e.getPlayer()));
        bankAmounts.put(e.getPlayer(), Bank.INSTANCE.getBankAmount(e.getPlayer()));
    }
}
