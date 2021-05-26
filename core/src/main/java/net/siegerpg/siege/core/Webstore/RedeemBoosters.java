package net.siegerpg.siege.core.Webstore;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public class RedeemBoosters {

    @EventHandler
    public void onEXPBoosterRedeem(PlayerInteractEvent e) {
        if (e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
            Player player = e.getPlayer();
            ItemStack item = player.getInventory().getItemInMainHand();
            if (item.getItemMeta().getDisplayName().contains("EXP Booster")) {
                List<String> lore = item.getLore();

            }
        }
    }
}
