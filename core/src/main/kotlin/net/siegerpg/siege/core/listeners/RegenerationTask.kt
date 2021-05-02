package net.siegerpg.siege.core.listeners

import net.siegerpg.siege.core.Core
import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.StatTypes
import org.bukkit.Bukkit

class RegenerationTask : Runnable {


    fun startRegenTask() {
        Bukkit.getServer().scheduler.scheduleSyncRepeatingTask(Core.plugin(), {

            for (player in Bukkit.getOnlinePlayers()) {
                var regenStat = CustomItemUtils.getPlayerStat(player, StatTypes.REGENERATION)
                var healthStat = CustomItemUtils.getPlayerStat(player, StatTypes.HEALTH)
                var currentCustomHealth = CustomItemUtils.getCustomHealth(player)
                if (regenStat == 0.0) regenStat = 1.0
                if (healthStat == 0.0)  healthStat = player.maxHealth
                if (currentCustomHealth == 0.0) currentCustomHealth = player.health
                //Bukkit.getLogger().info(player.name + " RegenStat: " + regenStat.toString() + " HealthStat: " + healthStat + " currentCustomHealth: " + currentCustomHealth)
                val addHealth = ((regenStat + currentCustomHealth)/healthStat) * player.maxHealth
                if (addHealth <= healthStat)
                    player.health = addHealth
                else player.health = healthStat
            }
        }, 100, 100)
    }

    override fun run() {
        TODO("Not yet implemented")
    }
}
