package net.siegerpg.siege.core.listeners

import net.siegerpg.siege.core.items.CustomItemUtils.getCustomItem
import net.siegerpg.siege.core.items.statgems.StatGem
import net.siegerpg.siege.core.items.types.misc.StatGemType
import net.siegerpg.siege.core.items.types.subtypes.CustomEquipment
import net.siegerpg.siege.core.listeners.NPC.Herbert
import net.siegerpg.siege.core.miscellaneous.Levels
import net.siegerpg.siege.core.miscellaneous.Scoreboard
import net.siegerpg.siege.core.miscellaneous.VaultHook
import net.siegerpg.siege.core.miscellaneous.sendMiniMessage
import org.bukkit.Sound
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.inventory.InventoryAction
import org.bukkit.event.inventory.InventoryClickEvent
import java.lang.String

class StatGemListener : Listener {

	@EventHandler
	@Suppress("unused")
	fun onInventoryClick(e : InventoryClickEvent) {
		if (e.whoClicked !is Player) return
		if (e.action != InventoryAction.SWAP_WITH_CURSOR) return
		val player = e.whoClicked as Player
		val itemOnCursor = getCustomItem(e.cursor)
		val itemInteractedWith = getCustomItem(e.currentItem)
		if (itemOnCursor == null || itemInteractedWith == null) return
		if (itemOnCursor !is StatGemType) return
		if (itemInteractedWith !is CustomEquipment) return
		itemInteractedWith.statGem?.let {
			player.sendMiniMessage("<red>That item already has a stat gem!")
			return
		}
		if (itemOnCursor.levelRequirement!! > (Levels.blockingGetExpLevel(player)?.first ?: 0)) {
			player.sendMiniMessage("<red>You are too low level to use this gem!")
			return
		}
		val cost = (Herbert.getSellValue(e.currentItem) * 5).toInt()
		if (VaultHook.econ.getBalance(player) < cost) {
			player.sendMiniMessage("<red>You need ${String.format("%,d", cost)} \u26C1 to apply this gem!")
			return
		}
		VaultHook.econ.withdrawPlayer(player, cost.toDouble())
		Scoreboard.updateScoreboard(player)

		player.playSound(
				player.location,
				Sound.ENTITY_ENDER_EYE_DEATH,
				0.8f,
				1.2f)

		itemInteractedWith.addStatGem(
				StatGem(
						itemOnCursor.statType,
						itemOnCursor.statAmount
				       )
		                             )
		itemInteractedWith.updateMeta(false)
		e.currentItem = itemInteractedWith.item
		e.isCancelled = true
		val newItem = e.cursor
		if (newItem != null) {
			newItem.amount = newItem.amount - 1
		}
		player.setItemOnCursor(newItem)
	}
}