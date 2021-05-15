package net.siegerpg.siege.core.listeners;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.block.EnderChest;
import org.bukkit.block.data.BlockData;
import org.bukkit.block.data.type.Door;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.*;
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
            if (!e.getPlayer().getGameMode().equals(GameMode.CREATIVE)) {
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

    @EventHandler
    public void preventLeftClick(PlayerInteractEvent e) {
        if (e.getAction().equals(Action.LEFT_CLICK_AIR) || e.getAction().equals(Action.LEFT_CLICK_BLOCK) ||
                e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
            if (e.getClickedBlock() == null) { return; }
            if (e.getClickedBlock() instanceof ItemFrame) {
                if (e.getPlayer().getGameMode().equals(GameMode.CREATIVE)) { return; }
                e.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void preventDamage(EntityDamageEvent e) {
        if(e instanceof EntityDamageByEntityEvent) {
            Player player = (Player) ((EntityDamageByEntityEvent) e).getDamager();
            if (player.getGameMode().equals(GameMode.CREATIVE)) { return; }
        }
        if (e.getEntity() instanceof ItemFrame) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void spawnProt(EntityDamageByEntityEvent e) {
        Player player = (Player) e.getDamager();
        if (player.getGameMode().equals(GameMode.CREATIVE)) { return; }
        if (e.getEntity().getLocation().distance(e.getEntity().getWorld().getSpawnLocation()) < 3) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void preventTame(EntityTameEvent e) {
        Player player = (Player) e.getOwner();
        if (!player.getGameMode().equals(GameMode.CREATIVE)) {
            e.setCancelled(true);
        }
    }
    @EventHandler
    public void preventBreed(EntityBreedEvent e) {
        Player player = (Player) e.getBreeder();
        if (player != null) {
            if (player.getGameMode().equals(GameMode.CREATIVE)) {
                return;
            }
        }
        e.setCancelled(true);
    }

}