package net.siegerpg.siege.core.levelReward

import net.siegerpg.siege.core.items.implemented.misc.food.GoldenCarrot
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Pebble
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Stick
import net.siegerpg.siege.core.items.implemented.weapons.melee.heavy.FemurBone
import net.siegerpg.siege.core.items.implemented.weapons.ranged.ReinforcedBow
import net.siegerpg.siege.core.listeners.GoldExpListener
import net.siegerpg.siege.core.miscellaneous.Utils
import org.bukkit.Sound
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack

class Reward18(
		override val level : Short = 19,
		override val gold : Int = 0,
		override val items : List<ItemStack> = listOf(
				ReinforcedBow(Utils.randRarity()).getUpdatedItem(false),
				GoldenCarrot(0).getUpdatedItem(false).asQuantity(5)
		                                             )
              ) : LevelReward