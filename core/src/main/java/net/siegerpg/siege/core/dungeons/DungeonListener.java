package net.siegerpg.siege.core.dungeons;

import io.lumine.xikage.mythicmobs.MythicMobs;
import io.lumine.xikage.mythicmobs.mobs.ActiveMob;
import io.lumine.xikage.mythicmobs.mobs.MythicMob;
import org.bukkit.entity.Entity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDeathEvent;

import java.util.Map;

public class DungeonListener implements Listener {
    @EventHandler
    public void onBossDeath(final EntityDeathEvent e) {

        for (final Map.Entry<String, Dungeon> entry : DungeonCommand.dungeons.entrySet()) {
            final String key = entry.getKey();
            final Dungeon value = entry.getValue();
            final Entity boss = value.boss;
            if (boss == null) continue;
            if (boss.isDead()) value.boss = null;
        }
    }
}
