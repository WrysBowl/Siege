package net.siegerpg.siege.core.utils.cache;

import io.lumine.xikage.mythicmobs.api.bukkit.events.MythicMobSpawnEvent;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Mob;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import java.util.HashMap;

public class MobNames implements Listener {
    public static HashMap<Entity, String> mobNames = new HashMap<>();

    @EventHandler
    public void onSpawn(final MythicMobSpawnEvent e) {
        if (!(e.getEntity() instanceof Mob)) return;
        final String displayName = e.getMob().getDisplayName();
        if (displayName != null) {
	        MobNames.mobNames.put(e.getEntity(), displayName);
        }
    }
}
