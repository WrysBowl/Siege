package net.siegerpg.siege.core.levelReward

import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Magma
import net.siegerpg.siege.core.items.implemented.weapons.melee.heavy.FemurBone
import net.siegerpg.siege.core.items.implemented.weapons.melee.light.Shovel
import net.siegerpg.siege.core.listeners.GoldExpListener
import net.siegerpg.siege.core.miscellaneous.Utils
import org.bukkit.Sound
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack

class Reward12(
		override val level : Short = 13,
		override val gold : Int = 500,
		override val items : List<ItemStack> = listOf(
				Shovel(Utils.randRarity()).getUpdatedItem(false)
		                                             )
              ) : LevelReward