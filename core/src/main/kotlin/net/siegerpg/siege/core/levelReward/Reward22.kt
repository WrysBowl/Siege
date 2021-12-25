package net.siegerpg.siege.core.levelReward

import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.MetalScrap
import net.siegerpg.siege.core.items.implemented.misc.statgems.strengthGems.FlawedStrengthGem
import net.siegerpg.siege.core.items.implemented.weapons.melee.heavy.GreatSword
import net.siegerpg.siege.core.listeners.GoldExpListener
import net.siegerpg.siege.core.miscellaneous.Utils
import org.bukkit.Sound
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack

class Reward22(
		override val level : Short = 23,
		override val gold : Int = 3000,
		override val items : List<ItemStack> = listOf(
				GreatSword(Utils.randRarity()).getUpdatedItem(false)
		                                             )
              ) : LevelReward