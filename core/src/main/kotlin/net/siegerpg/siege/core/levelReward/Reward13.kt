package net.siegerpg.siege.core.levelReward

import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Magma
import net.siegerpg.siege.core.listeners.GoldExpListener
import net.siegerpg.siege.core.miscellaneous.Utils
import org.bukkit.Sound
import org.bukkit.entity.Player

class Reward13 : LevelReward {

	override fun giveReward(player : Player) {
		val level : Short = 14
		player.playSound(player.location, Sound.ENTITY_PLAYER_LEVELUP, 5.0f, 5.0f)
		player.sendTitle(
				Utils.tacc("&5Level Up!"),
				Utils.tacc("&d${level - 1} &7\u21E2 &5$level"),
				10,
				80,
				10
		                )
		player.sendMessage(Utils.lore(""))
		player.sendMessage(Utils.lore("<gray>You leveled up to level $level!"))
		player.sendMessage(Utils.lore("<gold><bold>Level Reward"))
		player.sendMessage(Utils.lore("<yellow>+ 2,000 gold"))
		player.sendMessage(Utils.lore("<red>+ 2 HP"))
		player.sendMessage(Utils.lore("<green>+ Magma \u272a\u272a x16"))
		player.sendMessage(Utils.lore(""))

		GoldExpListener.giveGold(player, 2000)
		Utils.giveItem(player, Magma.tier(2).getUpdatedItem(false).asQuantity(16))

	}
}