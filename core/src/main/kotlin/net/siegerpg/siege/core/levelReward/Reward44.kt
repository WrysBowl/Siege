package net.siegerpg.siege.core.levelReward

import net.siegerpg.siege.core.items.implemented.misc.food.GoldenCarrot
import net.siegerpg.siege.core.items.implemented.misc.food.Sugar
import net.siegerpg.siege.core.items.implemented.misc.keys.cosmetic.RareKey
import net.siegerpg.siege.core.items.implemented.misc.keys.cosmetic.SpiritKey
import net.siegerpg.siege.core.items.implemented.weapons.melee.heavy.Nightshade
import net.siegerpg.siege.core.listeners.GoldExpListener
import net.siegerpg.siege.core.miscellaneous.Utils
import net.siegerpg.siege.core.webstore.categories.boosters.EXPBooster_100
import net.siegerpg.siege.core.webstore.categories.boosters.EXPBooster_50
import net.siegerpg.siege.core.webstore.categories.boosters.GOLDBooster_100
import org.bukkit.Sound
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack

class Reward44(
		override val level : Short = 45,
		override val gold : Int = 5000,
		override val items : List<ItemStack> = listOf(
				EXPBooster_50().boosterItem
		                                             )
              ) : LevelReward