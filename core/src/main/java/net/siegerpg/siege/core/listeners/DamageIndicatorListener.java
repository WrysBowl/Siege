package net.siegerpg.siege.core.listeners;

import net.siegerpg.siege.core.Core;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class DamageIndicatorListener implements Listener {
    private static final HashMap<Entity, ArmorStand> indicators = new HashMap<>();
    /*
    @EventHandler(priority = EventPriority.HIGH)
    public void onDamage(EntityDamageByEntityEvent event) {
        if (!(event.getDamager() instanceof Player) && !(event.getDamager() instanceof Arrow) || event.isCancelled()) return;
        int damage = Math.toIntExact(Math.round(event.getFinalDamage()));
        Entity victim = event.getEntity();
    
        showIndicator(victim, damage, false);
    }

    public static void clearIndicators() {
        for (World world : Bukkit.getWorlds()) {
            List<Entity> armorStands = world.getEntities().stream().filter((Entity e) -> e instanceof ArmorStand).collect(Collectors.toList());
            for (Entity armorStand : armorStands) {
                int isIndicator = NBT.getInt(armorStand, "indicator");
                if (isIndicator == 1) armorStand.remove();
            }
        }
    }
    
    public static void showIndicator(Entity entity, double damage, boolean critical) {
        if (indicators.containsKey(entity)) {
            indicators.get(entity).remove();
            indicators.remove(entity);
        }
        Location loc = entity.getLocation();
        String color = critical ? "§6" : "§c";
        ArmorStand indicator = loc.getWorld().spawn(entity.getLocation().add(0, entity.getHeight(), 0), ArmorStand.class, new InvisibleArmorStand());
        
        indicator.setCustomName(color+damage);
        indicator.setCustomNameVisible(true);
    
        NBT.addInt(indicator, "indicator", 1);
        indicators.put(entity, indicator);
        
        new BukkitRunnable() {
            @Override
            public void run() {
                indicator.remove();
                indicators.remove(entity);
            }
        }.runTaskLaterAsynchronously(Core.plugin(), 20);
    }
    */
}
