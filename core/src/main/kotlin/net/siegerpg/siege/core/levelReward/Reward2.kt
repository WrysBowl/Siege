package net.siegerpg.siege.core.levelReward

import net.siegerpg.siege.core.items.enums.StatTypes
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Stick
import net.siegerpg.siege.core.listeners.GoldExpListener
import net.siegerpg.siege.core.miscellaneous.Utils
import org.bukkit.Sound
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack

class Reward2(
		override val level : Short = 3,
		override val gold : Int = 400,
		override val items : List<ItemStack> = listOf(),
		override val stats : HashMap<StatTypes, Int>,
		override val skillPoints : Int = 0
             ) : LevelReward