package net.siegerpg.siege.core.levelReward

import net.siegerpg.siege.core.items.enums.StatTypes
import net.siegerpg.siege.core.listeners.GoldExpListener
import net.siegerpg.siege.core.miscellaneous.Utils
import net.siegerpg.siege.core.skills.SkillData
import org.bukkit.Sound
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack
import java.lang.String

interface LevelReward {

	val level : Short
	val gold : Int
	val items : List<ItemStack>
	val stats : HashMap<StatTypes, Int>
	val skillPoints : Int


	fun sendReward(player : Player) {
		player.playSound(player.location, Sound.ENTITY_PLAYER_LEVELUP, 1.0f, 1.0f)
		player.sendTitle(
				Utils.tacc("&5Level Up!"),
				Utils.tacc("&d${level - 1} &7\u21E2 &5$level"),
				10,
				80,
				10)

		player.sendMessage("")
		player.sendMessage(Utils.parse("<color:#BE6CD1><bold><underlined>        LEVEL UP!        <reset>"))
		player.sendMessage(Utils.parse("<color:#CF97DD>You leveled up to level $level"))
		player.sendMessage("")
		if (gold > 0) {
			player.sendMessage(Utils.parse("<yellow>+ ${String.format("%,d", gold)} \u26C1"))
			GoldExpListener.giveGold(player, gold)
		}
		if (skillPoints > 0) {
			player.sendMessage(Utils.parse("<aqua>+ ${String.format("%,d", skillPoints)} SP"))
			val currentPoints : Int = SkillData.getSkillPoints(player)
			SkillData.setSkillPoints(player, currentPoints+skillPoints)
		}
		for (item in items) {
			val miniMessage = Utils.lore("<gray>\u27A5 " + item.itemMeta.displayName + " <yellow>x" + item.amount).hoverEvent(item)
			player.sendMessage(miniMessage)
			Utils.giveItem(player, item)
		}
		extraReward(player)
		player.sendMessage("")
		player.sendMessage(Utils.parse("<color:#BE6CD1><underlined>                                  "))
		player.sendMessage("")
	}

	fun extraReward(player : Player) {}
	fun statMessage(player : Player, stat : StatTypes, amount : Int) {
		player.sendMessage("+ $amount ${stat.color}$stat")
	}
}