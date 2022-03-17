package net.siegerpg.siege.core.levelReward

import net.siegerpg.siege.core.dungeons.Dungeon
import net.siegerpg.siege.core.dungeons.DungeonCommand
import net.siegerpg.siege.core.items.enums.StatTypes
import net.siegerpg.siege.core.items.implemented.misc.keys.cosmetic.CommonKey
import net.siegerpg.siege.core.items.implemented.misc.keys.cosmetic.RareKey
import net.siegerpg.siege.core.items.implemented.misc.keys.cosmetic.SpiritKey
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack

class Reward92(
		override val level : Short = 93,
		override val gold : Int = 5000,
		override val items : List<ItemStack> = listOf(
				SpiritKey().getUpdatedItem(false).asQuantity(1)),
		override val stats : HashMap<StatTypes, Int> = hashMapOf(StatTypes.REGENERATION to 6),
		override val skillPoints : Int = 0
              ) : LevelReward {

	override fun extraReward(player : Player) {

		for (entry in stats) {
			statMessage(player, entry.key, entry.value)
		}
	}
}