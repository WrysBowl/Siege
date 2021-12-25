package net.siegerpg.siege.core.levelReward

import net.siegerpg.siege.core.items.implemented.armor.chestplate.BoneChestplate
import net.siegerpg.siege.core.items.implemented.misc.food.GoldenCarrot
import net.siegerpg.siege.core.items.implemented.misc.keys.cosmetic.SpiritKey
import net.siegerpg.siege.core.items.implemented.misc.statgems.strengthGems.FlawedStrengthGem
import net.siegerpg.siege.core.listeners.GoldExpListener
import net.siegerpg.siege.core.miscellaneous.Utils
import org.bukkit.Sound
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack

class Reward24(
		override val level : Short = 25,
		override val gold : Int = 4000,
		override val items : List<ItemStack> = listOf(
				GoldenCarrot(0).getUpdatedItem(false).asQuantity(10),
				BoneChestplate(Utils.randRarity()).getUpdatedItem(false)
		                                             )
              ) : LevelReward