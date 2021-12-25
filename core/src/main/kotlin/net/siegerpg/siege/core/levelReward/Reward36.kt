package net.siegerpg.siege.core.levelReward

import net.siegerpg.siege.core.items.implemented.misc.food.Sugar
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Crystal
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.CorruptCrystal
import net.siegerpg.siege.core.items.implemented.weapons.melee.light.RefinedDagger
import net.siegerpg.siege.core.items.implemented.weapons.ranged.Crossbow
import net.siegerpg.siege.core.listeners.GoldExpListener
import net.siegerpg.siege.core.miscellaneous.Utils
import org.bukkit.Sound
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack

class Reward36(
		override val level : Short = 37,
		override val gold : Int = 5000,
		override val items : List<ItemStack> = listOf(
				RefinedDagger(Utils.randRarity()).getUpdatedItem(false)
		                                             )
              ) : LevelReward