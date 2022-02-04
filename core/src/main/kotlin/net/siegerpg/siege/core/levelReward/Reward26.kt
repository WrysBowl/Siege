package net.siegerpg.siege.core.levelReward

import net.siegerpg.siege.core.items.implemented.misc.food.GoldenCarrot
import net.siegerpg.siege.core.items.implemented.misc.food.Sugar
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Bone
import net.siegerpg.siege.core.items.implemented.weapons.ranged.Crossbow
import net.siegerpg.siege.core.listeners.GoldExpListener
import net.siegerpg.siege.core.miscellaneous.Utils
import org.bukkit.Sound
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack

class Reward26(
		override val level : Short = 27,
		override val gold : Int = 1000,
		override val items : List<ItemStack> = listOf(
				Sugar().getUpdatedItem(false).asQuantity(15),
				GoldenCarrot().getUpdatedItem(false).asQuantity(10)
		                                             )
              ) : LevelReward