package net.siegerpg.siege.core.levelReward

import net.siegerpg.siege.core.items.implemented.misc.keys.cosmetic.RareKey
import net.siegerpg.siege.core.items.implemented.misc.keys.cosmetic.SpiritKey
import net.siegerpg.siege.core.listeners.GoldExpListener
import net.siegerpg.siege.core.miscellaneous.Utils
import net.siegerpg.siege.core.webstore.categories.boosters.EXPBooster_100
import net.siegerpg.siege.core.webstore.categories.boosters.GOLDBooster_100
import org.bukkit.Sound
import org.bukkit.entity.Player

class Reward44 : LevelReward {

	override fun giveReward(player : Player) {
		val level : Short = 45
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
		player.sendMessage(Utils.lore("<yellow>+ 30,000 gold"))
		player.sendMessage(Utils.lore("<red>+ 2 HP"))
		player.sendMessage(Utils.lore("<green>+ 100% GOLD and EXP Boosters"))
		player.sendMessage(Utils.lore(""))

		GoldExpListener.giveGold(player, 30000)
		Utils.giveItem(player, GOLDBooster_100().boosterItem)
		Utils.giveItem(player, EXPBooster_100().boosterItem)

	}
}