package net.siegerpg.siege.core.rebirthReward

import net.siegerpg.siege.core.items.enums.StatTypes
import net.siegerpg.siege.core.miscellaneous.Utils
import net.siegerpg.siege.core.miscellaneous.VaultHook
import net.siegerpg.siege.core.skills.SkillData
import org.bukkit.Sound
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack
import java.lang.String

interface RebirthTier {

	val tier : Short
	val items : List<ItemStack>
	val stats : HashMap<StatTypes, Int>
	val skillPoints : Int

	fun startRebirth(player : Player) {


		//TODO Rebirth animation
		/*
		0. Reset player's gold and exp
		1. Play a beacon sound that sounds like something is leveling up, or awakening for 5 seconds
		2. Blind the player and teleport them to spawn
		3. Flash a title to the player, "What is this feeling?" 3 seconds
		4. Flash a title to the player, "Where am I?" 3 seconds
		5. Play a sound effect which sounds like the dragon was killed to all players
		6. Un-blind the player
		7. Send rewards to player
		8. Broadcast that player has been reborn to x tier
		 */
		player.playSound(player.location, Sound.ENTITY_PLAYER_LEVELUP, 1.0f, 1.0f)
		player.sendTitle(
				Utils.tacc("&cREBIRTH"),
				Utils.tacc("&d${tier - 1} &7\u21E2 &5$tier"),
				10,
				80,
				10)
	}

	fun sendReward(player : Player) {

		//TODO use gold to multiply the amount of rewards the player can get
		val gold : Double = VaultHook.econ.getBalance(player)

		player.sendMessage("")
		player.sendMessage(Utils.parse("<color:#de6d47><bold><underlined>        REBIRTH        <reset>"))
		player.sendMessage(Utils.parse("<color:#de9747>Rebirth # <gray>$tier"))
		player.sendMessage("")
		if (skillPoints > 0) {
			player.sendMessage(Utils.parse("<light_blue>+ ${String.format("%,d", skillPoints)} SP"))
			val currentPoints : Int = SkillData.getSkillPoints(player)
			SkillData.setSkillPoints(player, currentPoints+skillPoints)
		}
		for (item in items) {
			val miniMessage = Utils.lore("<gray>\u27A5 " + item.itemMeta.displayName + " <yellow>x" + item.amount).hoverEvent(item)
			player.sendMessage(miniMessage)
			Utils.giveItem(player, item)
		}
		for (stat in stats) {
			player.sendMessage("+ ${stat.value} ${stat.key.color}${stat.key}")
		}
		extraReward(player)
		player.sendMessage("")
		player.sendMessage(Utils.parse("<color:#de6d47><underlined>                                  "))
		player.sendMessage("")
	}

	fun extraReward(player : Player) {}
}