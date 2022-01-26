package net.siegerpg.siege.core.levelReward

import net.siegerpg.siege.core.items.implemented.misc.keys.cosmetic.CommonKey
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Stick
import net.siegerpg.siege.core.listeners.GoldExpListener
import net.siegerpg.siege.core.miscellaneous.Utils
import org.bukkit.Sound
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack

class Reward8(
		override val level : Short = 9,
		override val gold : Int = 500,
		override val items : List<ItemStack> = listOf(
				CommonKey().getUpdatedItem(false).asQuantity(2)
		                                             )
             ) : LevelReward