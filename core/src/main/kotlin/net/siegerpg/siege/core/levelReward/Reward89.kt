package net.siegerpg.siege.core.levelReward

import net.siegerpg.siege.core.dungeons.Dungeon
import net.siegerpg.siege.core.dungeons.DungeonCommand
import net.siegerpg.siege.core.items.enums.StatTypes
import net.siegerpg.siege.core.items.implemented.misc.keys.cosmetic.CommonKey
import net.siegerpg.siege.core.miscellaneous.Utils
import net.siegerpg.siege.core.miscellaneous.VaultHook
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack

class Reward89(
		override val level : Short = 90,
		override val gold : Int = 0,
		override val items : List<ItemStack> = listOf(),
		override val stats : HashMap<StatTypes, Int> = hashMapOf(),
		override val skillPoints : Int = 1
              ) : LevelReward {

	override fun extraReward(player : Player) {
		player.sendMessage(Utils.lore("<green>+ 1 vault slot"))

		val highestPV = Utils.getHighestPV(player)
		VaultHook.perms.playerAdd(
				"global",
				player,
				"cosmicvaults.amount." + (highestPV + 1)
		                         )
	}
}