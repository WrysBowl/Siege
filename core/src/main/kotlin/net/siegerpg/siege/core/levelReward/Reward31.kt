package net.siegerpg.siege.core.levelReward

import net.siegerpg.siege.core.items.implemented.misc.food.Sugar
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.CursedBone
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.FairyDust
import net.siegerpg.siege.core.items.implemented.misc.statgems.luckGems.SimpleLuckGem
import net.siegerpg.siege.core.items.implemented.weapons.ranged.Crossbow
import net.siegerpg.siege.core.listeners.GoldExpListener
import net.siegerpg.siege.core.miscellaneous.Utils
import org.bukkit.Sound
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack

class Reward31(
		override val level : Short = 32,
		override val gold : Int = 5000,
		override val items : List<ItemStack> = listOf(
				SimpleLuckGem(0).getUpdatedItem(false).asQuantity(2)
		                                             )
              ) : LevelReward