package net.siegerpg.siege.core.customEvents;

import net.siegerpg.siege.core.Core;
import net.siegerpg.siege.core.customEvents.events.*;
import org.bukkit.event.Listener;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;

public class CustomEventListener implements Listener {
	public static ArrayList<CustomEvent> events = new ArrayList<>() {
		{
			add(new Fishing());
			add(new Mobs());
			add(new BlockBreak());
			add(new Haste_Buff());
			add(new More_Carrots());
			add(new More_Wheat());
			add(new Gold_Storm());
		}
	}; //fills up on start-up
	public static CustomEvent currentlyActive = null;
	private static final long eventWaitTimer = 1200 * 20L; //wait timer for events
	private static boolean eventDelayed = false;

	public CustomEventListener() {
		new BukkitRunnable() {
			@Override
			public void run() {
				triggers();
			}
		}.runTaskTimer(Core.plugin(), 20, 1800 * 20L);
	}

	public void triggers() {
		if (currentlyActive != null) return; //if an event is not active then allow code to trigger a new one
		if (eventDelayed) return;
		//allow to be shown 4 ticks later

		for (CustomEvent event : events) { //trigger all events
			if (!event.triggerable()) continue;

			event.action();
			startTimer(event);
			currentlyActive = event;

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
	private void startTimer(CustomEvent event) {
		new BukkitRunnable() {
			@Override
			public void run() {
				currentlyActive = null;
				event.clearAction();
			}
		}.runTaskLater(Core.plugin(), event.duration * 20L); //checks for event every 10 seconds
	}
}
