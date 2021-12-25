package net.siegerpg.siege.core.levelReward

import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.implemented.misc.food.Sugar
import net.siegerpg.siege.core.items.implemented.misc.keys.cosmetic.SpiritKey
import net.siegerpg.siege.core.items.implemented.weapons.ranged.Crossbow
import net.siegerpg.siege.core.listeners.GoldExpListener
import net.siegerpg.siege.core.miscellaneous.Utils
import net.siegerpg.siege.core.miscellaneous.VaultHook
import org.bukkit.Bukkit
import org.bukkit.Sound
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack

class Reward39(
		override val level : Short = 40,
		override val gold : Int = 10000,
		override val items : List<ItemStack> = listOf()
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