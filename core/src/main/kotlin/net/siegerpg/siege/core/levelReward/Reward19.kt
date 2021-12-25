package net.siegerpg.siege.core.levelReward

import net.siegerpg.siege.core.listeners.GoldExpListener
import net.siegerpg.siege.core.miscellaneous.Utils
import net.siegerpg.siege.core.miscellaneous.VaultHook
import net.siegerpg.siege.core.webstore.categories.boosters.EXPBooster_50
import net.siegerpg.siege.core.webstore.categories.boosters.GOLDBooster_50
import org.bukkit.Bukkit
import org.bukkit.Sound
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack

class Reward19(
		override val level : Short = 20,
		override val gold : Int = 10000,
		override val items : List<ItemStack> = listOf()
              ) : LevelReward {

	override fun extraReward(player : Player) {
		Bukkit.getServer().broadcast(Utils.lore("<green>${player.name} has reached level $level!"))
		player.sendMessage(Utils.lore("<green>+ 1 vault slot"))

		val highestPV = Utils.getHighestPV(player)
		VaultHook.perms.playerAdd(
				"global",
				player,
				"cosmicvaults.amount." + (highestPV + 1)
		                         )
	}
}