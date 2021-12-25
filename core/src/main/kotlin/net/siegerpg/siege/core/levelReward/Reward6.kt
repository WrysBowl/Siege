package net.siegerpg.siege.core.levelReward

import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Wool
import net.siegerpg.siege.core.items.implemented.misc.statgems.healthGems.CrackedHealthGem
import net.siegerpg.siege.core.items.implemented.weapons.melee.heavy.GiantClub
import net.siegerpg.siege.core.listeners.GoldExpListener
import net.siegerpg.siege.core.miscellaneous.Utils
import org.bukkit.Sound
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack

class Reward6(
		override val level : Short = 7,
		override val gold : Int = 500,
		override val items : List<ItemStack> = listOf(
				GiantClub(Utils.randRarity()).getUpdatedItem(false)
		                                             )
             ) : LevelReward