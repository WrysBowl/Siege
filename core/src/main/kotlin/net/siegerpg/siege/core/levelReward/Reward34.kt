package net.siegerpg.siege.core.levelReward

import net.siegerpg.siege.core.items.implemented.misc.food.Sugar
import net.siegerpg.siege.core.items.implemented.misc.keys.cosmetic.RareKey
import net.siegerpg.siege.core.items.implemented.misc.keys.cosmetic.SpiritKey
import net.siegerpg.siege.core.items.implemented.weapons.melee.heavy.Clobber
import net.siegerpg.siege.core.items.implemented.weapons.ranged.Crossbow
import net.siegerpg.siege.core.listeners.GoldExpListener
import net.siegerpg.siege.core.miscellaneous.Utils
import org.bukkit.Sound
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack

class Reward34(
		override val level : Short = 35,
		override val gold : Int = 5000,
		override val items : List<ItemStack> = listOf(
				Clobber(Utils.randRarity()).getUpdatedItem(false)
		                                             )
              ) : LevelReward