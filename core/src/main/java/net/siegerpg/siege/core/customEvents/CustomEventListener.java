package net.siegerpg.siege.core.customEvents;

import net.siegerpg.siege.core.Core;
import net.siegerpg.siege.core.customEvents.events.Gold_Storm;
import net.siegerpg.siege.core.customEvents.events.Thunder_Storm;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;

public class CustomEventListener implements Listener {
	public static HashMap<String, CustomEvent> events = new HashMap<>() {
		{
			put("GOLD_STORM", new Gold_Storm());
			put("THUNDER_STORM", new Thunder_Storm());

		}
	}; //fills up on start-up
	public static CustomEvent currentlyActive = null;
	private static boolean rateCalculating = false;
	private static boolean rateRemoval = false;
	private static final long eventWaitTimer = 1800 * 20L; //wait timer for events
	private static boolean eventDelayed = false;

	@EventHandler
	public void triggers(Event e) {
		if (currentlyActive != null) return; //if an event is not active then allow code to trigger a new one
		if (eventDelayed) return;
		if (rateCalculating) {

			//if calculation has been processed, add to rate limiter arraylist
			if (!rateRemoval) {
				rateRemoval = true;

				//allow to be shown 4 ticks later
				new BukkitRunnable() {
					@Override
					public void run() {
						rateRemoval = false;
						rateCalculating = false;
						for (CustomEvent event : events.values()) { //trigger all events
							if (!event.triggerable(e)) continue;
							event.action(e);
							startTimer(event, e);

							//delay next event
							eventDelayed = true;
							new BukkitRunnable() {
								@Override
								public void run() {
									eventDelayed = false;
								}
							}.runTaskLater(Core.plugin(), eventWaitTimer);

							return;
						}
					}
				}.runTaskLater(Core.plugin(), 200); //checks for event every 10 seconds
			}

		} else {
			rateCalculating = true;
		}
	}
	private void startTimer(CustomEvent event, Event e) {
		new BukkitRunnable() {
			@Override
			public void run() {
				currentlyActive = null;
				event.clearAction(e);
			}
		}.runTaskLater(Core.plugin(), event.duration * 20L); //checks for event every 10 seconds
	}
}
