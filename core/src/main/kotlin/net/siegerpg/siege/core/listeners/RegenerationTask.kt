package net.siegerpg.siege.core.listeners

import net.siegerpg.siege.core.Core
import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.StatTypes
import org.bukkit.Bukkit

class RegenerationTask : Runnable {


    fun startRegenTask() {
        Bukkit.getServer().scheduler.scheduleSyncRepeatingTask(Core.plugin(), {

            for (player in Bukkit.getOnlinePlayers()) {
                val regenStat = CustomItemUtils.getPlayerStat(player, StatTypes.REGENERATION) + 1.0
                val healthStat = CustomItemUtils.getPlayerStat(player, StatTypes.HEALTH) + player.maxHealth + (player.level*2)
                val currentCustomHealth = CustomItemUtils.getCustomHealth(player)
                val addedHealth = ((regenStat + currentCustomHealth)/healthStat) * player.maxHealth
                if (addedHealth <= player.maxHealth)
                    player.health = addedHealth
                else player.health = player.maxHealth
            }
        }, 100, 100)
    }

    override fun run() {
        TODO("Not yet implemented")
    }
}
