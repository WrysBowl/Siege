package net.siegerpg.siege.core.levelReward

import net.siegerpg.siege.core.items.implemented.misc.keys.cosmetic.NormalKey
import net.siegerpg.siege.core.items.implemented.misc.keys.crate.MobKey
import net.siegerpg.siege.core.listeners.GoldExpListener
import net.siegerpg.siege.core.miscellaneous.Utils
import org.bukkit.Sound
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack

class Reward4(
		override val level : Short = 5,
		override val gold : Int = 750,
		override val items : List<ItemStack> = listOf(
				MobKey(0).getUpdatedItem(false).asQuantity(5)
		                                             )
             ) : LevelReward