package net.siegerpg.siege.core.dungeons;

import org.bukkit.entity.Entity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

import java.util.Map;

public class DungeonListener implements Listener {
	@EventHandler
	public void onBossDeath (EntityDeathEvent e) {

		for (Map.Entry<String, Dungeon> entry : DungeonCommand.dungeons.entrySet()) {
			String key = entry.getKey();
			Dungeon value = entry.getValue();
			Entity boss = value.boss;
			if (boss == null) continue;
			if (boss.isDead()) value.boss = null;
		}
	}
}
