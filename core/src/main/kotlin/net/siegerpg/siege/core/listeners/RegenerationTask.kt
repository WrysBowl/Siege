package net.siegerpg.siege.core.listeners

import net.siegerpg.siege.core.Core
import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.StatTypes
import org.bukkit.Bukkit
import kotlin.math.abs

class RegenerationTask : Runnable {


    fun startRegenTask() {
        Bukkit.getServer().scheduler.scheduleSyncRepeatingTask(Core.plugin(), {

            for (player in Bukkit.getOnlinePlayers()) {
                var regenStat = CustomItemUtils.getPlayerStat(player, StatTypes.REGENERATION) + 1.0
                val healthStat = abs(CustomItemUtils.getPlayerStat(player, StatTypes.HEALTH) + player.maxHealth + (player.level*2))
                val currentCustomHealth = abs(CustomItemUtils.getCustomHealth(player))
                val addedHealth = ((regenStat + currentCustomHealth)/healthStat) * player.maxHealth

                if (addedHealth <= player.maxHealth)
                    if (addedHealth < 0.0) player.damage(abs(player.health+addedHealth))
                    else player.health = addedHealth
                else player.health = player.maxHealth
            }
        }, 80, 80)
    }

    override fun run() {
        TODO("Not yet implemented")
    }
}
