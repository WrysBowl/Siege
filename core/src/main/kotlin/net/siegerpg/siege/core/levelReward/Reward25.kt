package net.siegerpg.siege.core.levelReward

import net.siegerpg.siege.core.items.implemented.misc.food.GoldenCarrot
import net.siegerpg.siege.core.items.implemented.misc.food.Sugar
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.MetalScrap
import net.siegerpg.siege.core.items.implemented.weapons.ranged.Crossbow
import net.siegerpg.siege.core.listeners.GoldExpListener
import net.siegerpg.siege.core.miscellaneous.Utils
import org.bukkit.Sound
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack

class Reward25(
		override val level : Short = 26,
		override val gold : Int = 3000,
		override val items : List<ItemStack> = listOf(
				Sugar(0).getUpdatedItem(false).asQuantity(10),
				Crossbow(Utils.randRarity()).getUpdatedItem(false)
		                                             )
              ) : LevelReward