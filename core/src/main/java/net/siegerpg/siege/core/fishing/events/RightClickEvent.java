package net.siegerpg.siege.core.fishing.events;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import tasks.FishingTask;

public class RightClickEvent implements Listener {
	
	
	@EventHandler
	public void onClick(PlayerInteractEvent e) {
		Player player = e.getPlayer();
		if(FishingTask.runningTasks.containsKey(player.getUniqueId())) {
			FishingTask task = FishingTask.runningTasks.get(player.getUniqueId());
			CustomFishEvent ce = task.getEvent();
			if(ce.getFishingData().isFishing())
			{
				player.sendMessage(ChatColor.RED + "FISHING");
				e.setCancelled(true);
				player.sendMessage("1");
				if(e.getAction() == Action.LEFT_CLICK_AIR || e.getAction() == Action.LEFT_CLICK_BLOCK)
				{ 
					player.sendMessage(String.valueOf(e.getAction() + "SCORE: " + ce.getFishingData().getScore()));
					if(ce.getFishingData().getCursor().getLoc() > 0){ 
						
						ce.getFishingData().getCursor().setLoc(ce.getFishingData().getCursor().getLoc()-1); 
						}
					player.sendMessage(String.valueOf(ce.getFishingData().getCursor().getLoc()));
				}
				if(e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK)
				{
					if(ce.getFishingData().getCursor().getLoc() < ce.getTotalLength()){ 
						ce.getFishingData().getCursor().setLoc(ce.getFishingData().getCursor().getLoc()+1); 
						}
					player.sendMessage(String.valueOf(ce.getFishingData().getCursor().getLoc()));
				}
			}
		}
	}

}
