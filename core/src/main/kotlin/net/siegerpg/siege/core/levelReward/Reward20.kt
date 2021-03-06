package net.siegerpg.siege.core.levelReward

import net.siegerpg.siege.core.items.implemented.misc.food.GoldenCarrot
import net.siegerpg.siege.core.items.implemented.misc.statgems.strengthGems.FlawedStrengthGem
import net.siegerpg.siege.core.items.implemented.weapons.melee.light.daggers.StrongDagger
import net.siegerpg.siege.core.items.implemented.weapons.ranged.ReinforcedBow
import net.siegerpg.siege.core.listeners.GoldExpListener
import net.siegerpg.siege.core.miscellaneous.Utils
import org.bukkit.Sound
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack

class Reward20(
		override val level : Short = 21,
		override val gold : Int = 500,
		override val items : List<ItemStack> = listOf(
				FlawedStrengthGem(0).getUpdatedItem(false),
				GoldenCarrot(0).getUpdatedItem(false).asQuantity(5)
		                                             )
              ) : LevelReward