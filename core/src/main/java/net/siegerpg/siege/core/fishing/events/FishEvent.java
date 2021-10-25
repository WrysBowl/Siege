package net.siegerpg.siege.core.fishing.events;

import net.siegerpg.siege.core.Core;
import net.siegerpg.siege.core.fishing.FishingTask;
import net.siegerpg.siege.core.fishing.baits.BaitCore;
import net.siegerpg.siege.core.fishing.fish.FishCore;
import org.bukkit.Sound;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.event.server.PluginEnableEvent;

import java.util.logging.Level;

public class FishEvent implements Listener {

	@EventHandler
	public void onEnable(final PluginEnableEvent e) {
		BaitCore.registerAllBaits();
		Core.plugin().getLogger().log(Level.INFO, "Baited registering baits");
	}

	@EventHandler
	public void onFish(final PlayerFishEvent e) {
		if(FishingTask.runningTasks.containsKey(e.getPlayer().getUniqueId())) {
			final FishingTask task = FishingTask.runningTasks.get(e.getPlayer().getUniqueId());
			final CustomFishEvent ce = task.getEvent();
			if(ce.getFishingData().isFishing()) {
				e.setCancelled(true);
			}
		}
		if(e.getState() == PlayerFishEvent.State.CAUGHT_FISH) {
			e.setCancelled(true);
			final CustomFishEvent cfe = new CustomFishEvent(e);
			cfe.trigger();
		}
		
	}
	
	

}
