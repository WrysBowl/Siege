package net.siegerpg.siege.core.utils.levelReward

import org.bukkit.entity.Player

interface LevelReward {
    fun giveReward(player: Player, level: Short){}
}