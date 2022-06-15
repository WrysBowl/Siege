package net.siegerpg.siege.core.levelReward

import net.siegerpg.siege.core.items.enums.StatTypes
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
		override val gold : Int = 15000,
		override val items : List<ItemStack> = listOf(
				EpicKey().getUpdatedItem(false).asQuantity(2)
		                                             ),
		override val stats : HashMap<StatTypes, Int> = hashMapOf(),
		override val skillPoints : Int = 0
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