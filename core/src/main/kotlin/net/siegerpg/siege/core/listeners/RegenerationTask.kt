package net.siegemc.core.listeners

import net.siegerpg.siege.core.Core
import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.StatTypes
import org.bukkit.Bukkit

class RegenerationTask : Runnable {

    fun startRegenTask() {
        Bukkit.getServer().scheduler.scheduleSyncRepeatingTask(Core.plugin(), {

            for (player in Bukkit.getOnlinePlayers()) {
                val regenStat = CustomItemUtils.getPlayerStat(player, StatTypes.REGENERATION)
                val healthStat = CustomItemUtils.getPlayerStat(player, StatTypes.HEALTH)
                val currentCustomHealth = CustomItemUtils.getHealth(player)
                player.health += ((regenStat + currentCustomHealth)/healthStat) * player.maxHealth
                if (player.health > player.maxHealth) {
                    player.health = player.maxHealth
                }
            }
        }, 100, 100)
    }

    override fun run() {
        TODO("Not yet implemented")
    }
}
