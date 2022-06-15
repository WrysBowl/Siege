package net.siegerpg.siege.core.levelReward

import net.siegerpg.siege.core.items.enums.StatTypes
import net.siegerpg.siege.core.listeners.GoldExpListener
import net.siegerpg.siege.core.miscellaneous.Utils
import net.siegerpg.siege.core.miscellaneous.VaultHook
import net.siegerpg.siege.core.webstore.categories.boosters.EXPBooster_100
import net.siegerpg.siege.core.webstore.categories.boosters.GOLDBooster_100
import org.bukkit.Bukkit
import org.bukkit.Sound
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack

class Reward29(
		override val level : Short = 30,
		override val gold : Int = 10000,
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