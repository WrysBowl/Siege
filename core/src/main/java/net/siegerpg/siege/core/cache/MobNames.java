package net.siegerpg.siege.core.cache;

import io.lumine.xikage.mythicmobs.MythicMobs;
import io.lumine.xikage.mythicmobs.api.bukkit.events.MythicMobSpawnEvent;
import io.lumine.xikage.mythicmobs.mobs.ActiveMob;
import net.siegerpg.siege.core.utils.Utils;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Mob;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import java.util.HashMap;

public class MobNames implements Listener {
    public static HashMap<Entity, String> mobNames = new HashMap<>();

    @EventHandler
    public void onSpawn(MythicMobSpawnEvent e) {
        if (!(e.getEntity() instanceof Mob)) return;
        String displayName = e.getMob().getDisplayName();
        if (displayName != null) {
            mobNames.put(e.getEntity(), displayName);
            double maxHealth = Utils.round(((Mob) e.getEntity()).getMaxHealth(), 1);
            e.getEntity().setCustomName(displayName + Utils.tacc("&a"+maxHealth+"&2/&a"+maxHealth));
            e.getEntity().setCustomNameVisible(true);
        }
    }
}
