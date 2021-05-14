package net.siegerpg.siege.core.listeners;

import net.siegerpg.siege.core.informants.Scoreboard;
import net.siegerpg.siege.core.utils.Utils;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityPickupItemEvent;
import org.bukkit.inventory.ItemStack;

public class ItemPickupListener implements Listener{

    @EventHandler
    public void entityPickUp(EntityPickupItemEvent e) {
        ItemStack eGetItem = e.getItem().getItemStack();
        if (e.isCancelled()) return;
        if (!(e.getEntity() instanceof Player)) return;
        if (!eGetItem.getType().equals(Material.SUNFLOWER)) return;
        if (!Utils.strip(eGetItem.getItemMeta().getDisplayName()).equals("Gold Coin")) return;
        Player player = ((Player) e.getEntity()).getPlayer();
        e.setCancelled(true);
        int goldAmount = e.getItem().getItemStack().getAmount();
        net.siegerpg.siege.core.utils.VaultHook.econ.depositPlayer(player, goldAmount);
        e.getItem().remove();
        player.playSound(
                player.getLocation(),
                Sound.ENTITY_EXPERIENCE_ORB_PICKUP
                , 1.0f, 1.0f);
        player.sendActionBar(Utils.parse("<yellow>+ " + goldAmount + " <yellow>Gold"));
        Scoreboard.updateScoreboard((Player) e.getEntity());
    }
}
