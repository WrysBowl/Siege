package net.siegerpg.siege.core.levelReward

import net.siegerpg.siege.core.items.implemented.armor.helmet.SlimyHelmet
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Slime
import net.siegerpg.siege.core.items.implemented.weapons.wands.LivingTwig
import net.siegerpg.siege.core.listeners.GoldExpListener
import net.siegerpg.siege.core.miscellaneous.Utils
import org.bukkit.Sound
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack

class Reward3(
		override val level : Short = 4,
		override val gold : Int = 500,
		override val items : List<ItemStack> = listOf()
             ) : LevelReward
