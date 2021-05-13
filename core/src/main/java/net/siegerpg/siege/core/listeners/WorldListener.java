package net.siegerpg.siege.core.listeners;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.block.EnderChest;
import org.bukkit.block.data.BlockData;
import org.bukkit.block.data.type.Door;
import org.bukkit.entity.Bee;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityEnterBlockEvent;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.Objects;

public class WorldListener implements Listener {
    
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
                BlockData block = Objects.requireNonNull(e.getClickedBlock()).getBlockData();
                if (block instanceof Door) { return; }
                else if (e.getClickedBlock().getType().equals(Material.ENDER_CHEST)) { return; }
                e.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onEntityEnter(EntityEnterBlockEvent e) {
        if (e.getEntity() instanceof Bee) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void denyEggSpawning(EntitySpawnEvent e) {
        if (e.getEntity().getType().equals(EntityType.EGG)) {
            e.setCancelled(true);
        }
    }
}