package net.siegerpg.siege.core.levelReward

import net.siegerpg.siege.core.items.implemented.misc.keys.cosmetic.EpicKey
import net.siegerpg.siege.core.items.implemented.misc.keys.cosmetic.RareKey
import net.siegerpg.siege.core.items.implemented.misc.keys.cosmetic.SpiritKey
import net.siegerpg.siege.core.items.implemented.weapons.ranged.LuminousBow
import net.siegerpg.siege.core.listeners.GoldExpListener
import net.siegerpg.siege.core.miscellaneous.Utils
import net.siegerpg.siege.core.miscellaneous.VaultHook
import net.siegerpg.siege.core.webstore.categories.boosters.EXPBooster_100
import net.siegerpg.siege.core.webstore.categories.boosters.GOLDBooster_100
import org.bukkit.Bukkit
import org.bukkit.Sound
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack

class Reward49(
		override val level : Short = 50,
		override val gold : Int = 25000,
		override val items : List<ItemStack> = listOf(
				EpicKey(0).getUpdatedItem(false).asQuantity(2)
		                                             )
              ) : LevelReward {

	override fun sendMessage(player : Player) {
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