package net.siegerpg.siege.core.listeners;

import net.siegerpg.siege.core.informants.Scoreboard;
import net.siegerpg.siege.core.utils.*;
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
        e.setCancelled(true);
        int goldAmount = e.getItem().getItemStack().getAmount();
        VaultHook.econ.depositPlayer((OfflinePlayer) e.getEntity(), goldAmount);
        e.getItem().remove();
        ((Player) e.getEntity()).getPlayer().playSound(
                ((Player) e.getEntity()).getPlayer().getLocation(),
                Sound.ENTITY_EXPERIENCE_ORB_PICKUP
                , 1.0f, 1.0f);
        new Scoreboard().updateScoreboard((Player) e.getEntity());
    }
}
