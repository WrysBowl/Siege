package net.siegerpg.siege.core.levelReward

import net.siegerpg.siege.core.items.implemented.misc.keys.cosmetic.SpiritKey
import net.siegerpg.siege.core.listeners.GoldExpListener
import net.siegerpg.siege.core.miscellaneous.Utils
import org.bukkit.Sound
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack

class Reward14(
		override val level : Short = 15,
		override val gold : Int = 3000,
		override val items : List<ItemStack> = listOf()
              ) : LevelReward