package net.siegerpg.siege.core.levelReward

import net.siegerpg.siege.core.items.implemented.misc.keys.cosmetic.UncommonKey
import org.bukkit.inventory.ItemStack

class Reward15(
		override val level : Short = 16,
		override val gold : Int = 1000,
		override val items : List<ItemStack> = listOf(
				UncommonKey().getUpdatedItem(false).asQuantity(2)
		                                             )
              ) : LevelReward