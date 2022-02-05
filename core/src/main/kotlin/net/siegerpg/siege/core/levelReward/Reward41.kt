package net.siegerpg.siege.core.levelReward

import net.siegerpg.siege.core.items.implemented.armor.chestplate.ReaperCloak
import net.siegerpg.siege.core.items.implemented.misc.food.Sugar
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Crystal
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.RefinedMetal
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.CorruptCrystal
import net.siegerpg.siege.core.items.implemented.misc.statgems.regenerationGems.SimpleRegenerationGem
import net.siegerpg.siege.core.items.implemented.misc.tools.Trowel
import net.siegerpg.siege.core.items.implemented.weapons.ranged.Crossbow
import net.siegerpg.siege.core.listeners.GoldExpListener
import net.siegerpg.siege.core.miscellaneous.Utils
import org.bukkit.Sound
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack

class Reward41(
		override val level : Short = 42,
		override val gold : Int = 5000,
		override val items : List<ItemStack> = listOf(
				Trowel().getUpdatedItem(false)
		                                             )
              ) : LevelReward