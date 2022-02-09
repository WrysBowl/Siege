package net.siegerpg.siege.core.levelReward

import net.siegerpg.siege.core.items.implemented.misc.food.GoldenCarrot
import net.siegerpg.siege.core.items.implemented.misc.food.Sugar
import net.siegerpg.siege.core.items.implemented.misc.keys.cosmetic.RareKey
import net.siegerpg.siege.core.items.implemented.misc.keys.crate.MobKey
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Crystal
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.RefinedMetal
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.CorruptCrystal
import net.siegerpg.siege.core.items.implemented.misc.statgems.luckGems.PolishedLuckGem
import net.siegerpg.siege.core.items.implemented.misc.statgems.toughGems.PristineToughGem
import net.siegerpg.siege.core.items.implemented.weapons.melee.heavy.Nightshade
import net.siegerpg.siege.core.items.implemented.weapons.ranged.LuminousBow
import net.siegerpg.siege.core.listeners.GoldExpListener
import net.siegerpg.siege.core.miscellaneous.Utils
import net.siegerpg.siege.core.miscellaneous.VaultHook
import org.bukkit.Bukkit
import org.bukkit.Sound
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack

class Reward59(
		override val level : Short = 60,
		override val gold : Int = 15000,
		override val items : List<ItemStack> = listOf(
				MobKey().getUpdatedItem(false).asQuantity(32)
		                                             )
              ) : LevelReward {

	override fun extraReward(player : Player) {
		Bukkit.getServer()
				.broadcast(Utils.lore("<green>${player.name} has reached level $level!"))
		player.sendMessage(Utils.lore("<green>+ 1 vault slot"))

		val highestPV = Utils.getHighestPV(player)
		VaultHook.perms.playerAdd(
				"global",
				player,
				"cosmicvaults.amount." + (highestPV + 1)
		                         )
	}
}