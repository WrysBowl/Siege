package net.siegerpg.siege.core.levelReward

import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Stick
import net.siegerpg.siege.core.listeners.GoldExpListener
import net.siegerpg.siege.core.miscellaneous.Utils
import org.bukkit.Sound
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack

class Reward11(
		override val level : Short = 12,
		override val gold : Int = 1200,
		override val items : List<ItemStack> = listOf()
              ) : LevelReward