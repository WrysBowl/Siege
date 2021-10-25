package net.siegerpg.siege.core.listeners;

import com.destroystokyo.paper.event.entity.ExperienceOrbMergeEvent;
import net.siegerpg.siege.core.Core;
import net.siegerpg.siege.core.utils.Utils;
import org.bukkit.*;
import org.bukkit.block.EnderChest;
import org.bukkit.block.data.BlockData;
import org.bukkit.block.data.type.Door;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.*;
import org.bukkit.event.entity.*;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.*;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

import java.util.Objects;

public class WorldListener implements Listener, Runnable {
    
    @EventHandler
    public void onTrample(final PlayerInteractEvent event) {
        if (!event.getAction().equals(Action.PHYSICAL)) return;
        if (event.getClickedBlock() == null || !event.getClickedBlock().getType().equals(Material.FARMLAND)) return;
        event.setCancelled(true);
    }
    
    @EventHandler
    public void onPlace(final BlockPlaceEvent event) {
        if (event.getPlayer().getGameMode().equals(GameMode.CREATIVE)) return;
        event.setCancelled(true);
    }

    @EventHandler
    public void openDeniedBlocks(final PlayerInteractEvent e) {
        if (e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
            if (!e.getPlayer().getGameMode().equals(GameMode.CREATIVE)) {
                final BlockData block = Objects.requireNonNull(e.getClickedBlock()).getBlockData();
                if (block instanceof Door) { return; }
                else if (e.getClickedBlock().getType().equals(Material.ENDER_CHEST)) { return; }
                e.setCancelled(true);
            }
        }
    }

    public void denyInventory(final InventoryOpenEvent e) {
        if (!e.getPlayer().getGameMode().equals(GameMode.CREATIVE)) {
            if (e.getInventory().getType().equals(InventoryType.CHEST)) return;
            if (e.getInventory().getType().equals(InventoryType.PLAYER)) return;
            if (e.getInventory().getType().equals(InventoryType.ENDER_CHEST)) return;
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void closeInv(final InventoryCloseEvent e) {
        new BukkitRunnable() {
            @Override
            public void run() {
                final Player p = (Player) e.getPlayer();
                p.updateInventory();
            }
        }.runTaskLater(Core.plugin(), 1);
    }

    @EventHandler
    public void onEntityEnter(final EntityEnterBlockEvent e) {
        if (e.getEntity() instanceof Bee) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void denySpawning(final ItemSpawnEvent e) {
        final Material type = e.getEntity().getItemStack().getType();
        if (type == Material.ARROW) {
            e.setCancelled(true);
        } else if (type == Material.EGG) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void expMerge(final ExperienceOrbMergeEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void preventClick(final PlayerInteractEvent e) {
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
    public void preventClick(final PlayerInteractEntityEvent e) {
        final Entity entity = e.getRightClicked();
        final Player player = e.getPlayer();
        if (entity instanceof ItemFrame) {
            if (player.getGameMode().equals(GameMode.CREATIVE)) {return;}
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void preventDamage(final EntityDamageEvent e) {
        if(e instanceof EntityDamageByEntityEvent) {
            if (((EntityDamageByEntityEvent) e).getDamager() instanceof Player) {
                final Player player = (Player) ((EntityDamageByEntityEvent) e).getDamager();
                if (player.getGameMode().equals(GameMode.CREATIVE)) { return; }
            }
        }
        if (e.getEntity() instanceof ItemFrame) {
            e.setCancelled(true);
        }
        if (e.getEntity() instanceof Player) {
            final World hub = Core.plugin().getServer().getWorld("Hub");
            final World siegeHub = Core.plugin().getServer().getWorld("SiegeHub");
            if (e.getEntity().getWorld().equals(hub) || e.getEntity().getWorld().equals(siegeHub)) e.setCancelled(true);
        }
    }

    @EventHandler
    public void spawnProt(final EntityDamageByEntityEvent e) {
        if (e.getDamager() instanceof Player) {
            final Player player = (Player) e.getDamager();
            if (player.getGameMode().equals(GameMode.CREATIVE)) {
                return;
            }
        }
        if (e.getEntity().getLocation().distance(e.getEntity().getWorld().getSpawnLocation()) < 3) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void preventTame(final EntityTameEvent e) {
        final Player player = (Player) e.getOwner();
        if (!player.getGameMode().equals(GameMode.CREATIVE)) {
            e.setCancelled(true);
        }
    }
    @EventHandler
    public void preventBreed(final EntityBreedEvent e) {
        final Player player = (Player) e.getBreeder();
        if (player != null) {
            if (player.getGameMode().equals(GameMode.CREATIVE)) {
                return;
            }
        }
        e.setCancelled(true);
    }
    @EventHandler
    public void preventExplosion(final BlockExplodeEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void preventExplosion2(final EntityExplodeEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void denySlimeSplit(final SlimeSplitEvent e) { e.setCancelled(true); }

    @EventHandler
    public void denyLeavesDecay(final LeavesDecayEvent e) { e.setCancelled(true); }

    @EventHandler
    public void denyBurn(final BlockBurnEvent e) { e.setCancelled(true); }

    @EventHandler
    public void denyCraft(final CraftItemEvent e) { e.setCancelled(true); }

    @EventHandler
    public void denyBlockExp(final BlockExpEvent e) { e.setExpToDrop(0); }

    @EventHandler
    public void denyBlockFade(final BlockFadeEvent e) { e.setCancelled(true); }

    @Override
    public void run() {

    }
}