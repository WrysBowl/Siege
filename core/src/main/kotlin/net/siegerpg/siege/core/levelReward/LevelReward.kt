package net.siegerpg.siege.core.levelReward

import org.bukkit.entity.Player

interface LevelReward {
    fun giveReward(player: Player){}
}