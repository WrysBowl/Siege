package net.siegerpg.siege.core.levelReward

import net.siegerpg.siege.core.items.enums.StatTypes
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
		override val gold : Int = 10000,
		override val items : List<ItemStack> = listOf(),
		override val stats : HashMap<StatTypes, Int> = hashMapOf(),
		override val skillPoints : Int = 0
              ) : LevelReward