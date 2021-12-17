package net.siegerpg.siege.core.customEvents;

import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class CustomEvent {

	public int duration = 1800; //default 30 minute duration

	/**
	 * Checks the event conditions
	 * @return boolean
	 */
	public boolean triggerable() { return false; }

	/**
	 * Calls the action of the event
	 */
	public void action() {}

	/**
	 * Clears the action of the event
	 */
	public void clearAction() {}

}
