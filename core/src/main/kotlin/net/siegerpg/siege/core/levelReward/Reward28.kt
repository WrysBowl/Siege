package net.siegerpg.siege.core.levelReward

import net.siegerpg.siege.core.items.enums.StatTypes
import net.siegerpg.siege.core.items.implemented.misc.food.GoldenCarrot
import net.siegerpg.siege.core.items.implemented.misc.food.Sugar
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Chain
import net.siegerpg.siege.core.items.implemented.weapons.ranged.Crossbow
import net.siegerpg.siege.core.listeners.GoldExpListener
import net.siegerpg.siege.core.miscellaneous.Utils
import org.bukkit.Sound
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack

class Reward28(
		override val level : Short = 29,
		override val gold : Int = 4000,
		override val items : List<ItemStack> = listOf(
				GoldenCarrot().getUpdatedItem(false).asQuantity(16)
		                                             ),
		override val stats : HashMap<StatTypes, Int>,
		override val skillPoints : Int = 0
              ) : LevelReward