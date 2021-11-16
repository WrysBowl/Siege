package net.siegerpg.siege.core.miscellaneous.cache;

import io.lumine.xikage.mythicmobs.api.bukkit.events.MythicMobSpawnEvent;
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
        }
    }
}
