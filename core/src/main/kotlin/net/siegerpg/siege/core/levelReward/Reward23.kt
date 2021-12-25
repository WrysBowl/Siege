package net.siegerpg.siege.core.levelReward

import net.siegerpg.siege.core.items.implemented.armor.helmet.BoneHelmet
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Bone
import net.siegerpg.siege.core.items.implemented.misc.statgems.strengthGems.FlawedStrengthGem
import net.siegerpg.siege.core.listeners.GoldExpListener
import net.siegerpg.siege.core.miscellaneous.Utils
import org.bukkit.Sound
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack

class Reward23(
		override val level : Short = 24,
		override val gold : Int = 1000,
		override val items : List<ItemStack> = listOf(
				BoneHelmet(Utils.randRarity()).getUpdatedItem(false)
		                                             )
              ) : LevelReward