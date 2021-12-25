package net.siegerpg.siege.core.levelReward

import net.siegerpg.siege.core.items.implemented.misc.food.GoldenCarrot
import net.siegerpg.siege.core.items.implemented.misc.food.Sugar
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.CharredStick
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.IceShard
import net.siegerpg.siege.core.items.implemented.weapons.ranged.Crossbow
import net.siegerpg.siege.core.listeners.GoldExpListener
import net.siegerpg.siege.core.miscellaneous.Utils
import org.bukkit.Sound
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack

class Reward37(
		override val level : Short = 38,
		override val gold : Int = 6000,
		override val items : List<ItemStack> = listOf(
				Sugar(0).getUpdatedItem(false).asQuantity(32),
				GoldenCarrot(0).getUpdatedItem(false).asQuantity(16)
		                                             )
              ) : LevelReward