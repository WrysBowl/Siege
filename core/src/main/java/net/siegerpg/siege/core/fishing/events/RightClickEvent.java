package net.siegerpg.siege.core.fishing.events;

import net.siegerpg.siege.core.fishing.FishingTask;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.event.player.PlayerInteractEvent;


public class RightClickEvent implements Listener {
	
	
	@EventHandler
	public void onClick(PlayerInteractEvent e) {
		Player player = e.getPlayer();
		if(FishingTask.runningTasks.containsKey(player.getUniqueId())) {
			FishingTask task = FishingTask.runningTasks.get(player.getUniqueId());
			CustomFishEvent ce = task.getEvent();
			if(ce.getFishingData().isFishing())
			{
				e.setCancelled(true);
				if(e.getAction() == Action.LEFT_CLICK_AIR || e.getAction() == Action.LEFT_CLICK_BLOCK)
				{
					if (task.direction == -1) {
						task.direction = 1;
					} else {
						task.direction = -1;
					}
				}
			}
		}
	}

}
