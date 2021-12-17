package net.siegerpg.siege.core.customEvents;

import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class CustomEvent {

	public int duration = 1800; //default 30 minute duration

	/**
	 * Checks the event conditions
	 * @param e Any event
	 * @return boolean
	 */
	public boolean triggerable(Event e) { return false; }

	/**
	 * Calls the action of the event
	 * @param e Any event
	 */
	public void action(Event e) {}

	/**
	 * Clears the action of the event
	 * @param e Any event
	 */
	public void clearAction(Event e) {}

}
