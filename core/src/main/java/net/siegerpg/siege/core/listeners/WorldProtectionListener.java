package net.siegerpg.siege.core.listeners;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class WorldProtectionListener implements Listener {
    
    @EventHandler
    public void onTrample(PlayerInteractEvent event) {
        if (!event.getAction().equals(Action.PHYSICAL)) return;
        if (event.getClickedBlock() == null || !event.getClickedBlock().getType().equals(Material.FARMLAND)) return;
        event.setCancelled(true);
    }
    
    @EventHandler
    public void onPlace(BlockPlaceEvent event) {
        if (event.getPlayer().getGameMode().equals(GameMode.CREATIVE)) return;
        event.setCancelled(true);
    }

    @EventHandler
    public void openDeniedBlocks(PlayerInteractEvent e) {
        if (e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
            if (e.getPlayer().getGameMode().equals(GameMode.SURVIVAL) || e.getPlayer().getGameMode().equals(GameMode.ADVENTURE)) {
                if (e.getClickedBlock().getType() == Material.CRAFTING_TABLE) {
                    e.setCancelled(false);
                    return;
                }
                e.setCancelled(true);
            }
        }
    }
}