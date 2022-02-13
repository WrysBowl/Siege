package net.siegerpg.siege.core.listeners

import net.siegerpg.siege.core.Core
import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.StatTypes
import org.bukkit.Bukkit
import java.lang.Math.floor

class RegenerationTask : Runnable {


	fun startRegenTask() {
		Bukkit.getServer().scheduler.scheduleSyncRepeatingTask(Core.plugin(), {
			for (player in Bukkit.getOnlinePlayers()) {
				val regenStat = CustomItemUtils.getPlayerStat(player, StatTypes.REGENERATION) + 1.0
				CustomItemUtils.addHealth(player, regenStat)
			}
		}, 100, 100)
	}

	override fun run() {
		TODO("Not yet implemented")
	}
}
