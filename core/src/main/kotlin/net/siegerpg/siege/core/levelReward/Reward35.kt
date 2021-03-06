package net.siegerpg.siege.core.levelReward

import net.siegerpg.siege.core.items.implemented.armor.chestplate.IronChestplate
import net.siegerpg.siege.core.items.implemented.misc.food.Sugar
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Crystal
import net.siegerpg.siege.core.items.implemented.misc.statgems.toughGems.SimpleToughGem
import net.siegerpg.siege.core.items.implemented.weapons.ranged.Crossbow
import net.siegerpg.siege.core.listeners.GoldExpListener
import net.siegerpg.siege.core.miscellaneous.Utils
import org.bukkit.Sound
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack

class Reward35(
		override val level : Short = 36,
		override val gold : Int = 4000,
		override val items : List<ItemStack> = listOf(
				SimpleToughGem(Utils.randRarity()).getUpdatedItem(false),
				IronChestplate(Utils.randRarity()).getUpdatedItem(false)
		                                             )
              ) : LevelReward