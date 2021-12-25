package net.siegerpg.siege.core.levelReward

import net.siegerpg.siege.core.items.implemented.misc.keys.cosmetic.UncommonKey
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Pebble
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Stick
import net.siegerpg.siege.core.items.implemented.weapons.melee.heavy.FemurBone
import net.siegerpg.siege.core.listeners.GoldExpListener
import net.siegerpg.siege.core.miscellaneous.Utils
import net.siegerpg.siege.core.webstore.categories.cosmetics.UncommonCosmeticKey
import org.bukkit.Sound
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack

class Reward15(
		override val level : Short = 16,
		override val gold : Int = 1000,
		override val items : List<ItemStack> = listOf(
				UncommonKey(0).getUpdatedItem(false).asQuantity(2)
		                                             )
              ) : LevelReward