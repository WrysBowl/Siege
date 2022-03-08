package net.siegerpg.siege.core.levelReward

import net.siegerpg.siege.core.dungeons.Dungeon
import net.siegerpg.siege.core.dungeons.DungeonCommand
import net.siegerpg.siege.core.items.enums.StatTypes
import net.siegerpg.siege.core.items.implemented.misc.keys.cosmetic.CommonKey
import net.siegerpg.siege.core.items.implemented.misc.keys.cosmetic.UncommonKey
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack

class Reward81(
		override val level : Short = 82,
		override val gold : Int = 5000,
		override val items : List<ItemStack> = listOf(
				UncommonKey().getUpdatedItem(false).asQuantity(5)),
		override val stats : HashMap<StatTypes, Int> = hashMapOf(StatTypes.STRENGTH to 4)
              ) : StatReward {

	override fun extraReward(player : Player) {

		for (entry in stats) {
			statMessage(player, entry.key, entry.value)
		}
	}
}