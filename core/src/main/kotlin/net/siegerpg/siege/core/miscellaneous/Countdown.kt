package net.siegerpg.siege.core.miscellaneous

import net.siegerpg.siege.core.Core
import org.bukkit.entity.Player
import org.bukkit.scheduler.BukkitRunnable

class Countdown {

	fun countdown(player : Player, countDown : Int) { //A method
		object : BukkitRunnable() {
			//BukkitRunnable, not Runnable
			var countdown =
					countDown //Instance variable in our anonymous class to easily hold the countdown value

			override fun run() {
				if (countdown <= 0 || !player.isOnline) { //countdown is over or player left the server, just two example reasons to exit
					this.cancel() //cancel the repeating task
					return  //exit the method
				}
				//Something goes here
				countdown-- //decrement
			}
		}.runTaskTimer(
				Core.plugin(),
				0,
				20
		              ) //Repeating task with 0 ticks initial delay, run once per 20 ticks (one second). Make sure you pass a valid instance of your plugin.
	}
}