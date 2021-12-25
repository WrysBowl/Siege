package net.siegerpg.siege.core.levelReward

import net.siegerpg.siege.core.listeners.GoldExpListener
import net.siegerpg.siege.core.miscellaneous.Utils
import org.bukkit.Sound
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack

class Reward5(
		override val level : Short = 6,
		override val gold : Int = 800,
		override val items : List<ItemStack> = listOf()
             ) : LevelReward