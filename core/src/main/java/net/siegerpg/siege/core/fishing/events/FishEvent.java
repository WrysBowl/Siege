package net.siegerpg.siege.core.fishing.events;

import net.siegerpg.siege.core.fishing.FishingTask;
import net.siegerpg.siege.core.fishing.fish.FishCore;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.event.player.PlayerFishEvent.State;
import org.bukkit.event.server.PluginEnableEvent;

public class FishEvent implements Listener {

	@EventHandler
	public void onEnable(PluginEnableEvent e) {
		FishCore.registerFish();
	}

	@EventHandler
	public void onFish(PlayerFishEvent e) {
		if(FishingTask.runningTasks.containsKey(e.getPlayer().getUniqueId())) {
			FishingTask task = FishingTask.runningTasks.get(e.getPlayer().getUniqueId());
			CustomFishEvent ce = task.getEvent();
			if(ce.getFishingData().isFishing())
			{
				e.setCancelled(true);
			}
		}
		if(e.getState() == State.CAUGHT_FISH) {
			e.setCancelled(true);
			CustomFishEvent cfe = new CustomFishEvent(e);
			cfe.trigger();
		}
		
	}
	
	

}
