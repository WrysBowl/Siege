package net.siegerpg.siege.core.levelReward

import net.siegerpg.siege.core.items.implemented.armor.chestplate.MagmaChestplate
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Magma
import net.siegerpg.siege.core.items.implemented.weapons.melee.heavy.FemurBone
import net.siegerpg.siege.core.listeners.GoldExpListener
import net.siegerpg.siege.core.miscellaneous.Utils
import org.bukkit.Sound
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack

class Reward13(
		override val level : Short = 14,
		override val gold : Int = 3000,
		override val items : List<ItemStack> = listOf()
              ) : LevelReward