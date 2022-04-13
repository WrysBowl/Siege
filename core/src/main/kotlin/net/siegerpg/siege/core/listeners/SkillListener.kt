package net.siegerpg.siege.core.listeners

import net.siegerpg.siege.core.items.CustomItemUtils.getCustomItem
import net.siegerpg.siege.core.items.statgems.StatGem
import net.siegerpg.siege.core.items.types.misc.CustomSkill
import net.siegerpg.siege.core.items.types.misc.StatGemType
import net.siegerpg.siege.core.items.types.subtypes.CustomEquipment
import net.siegerpg.siege.core.items.types.subtypes.CustomWeapon
import net.siegerpg.siege.core.listeners.NPC.Herbert
import net.siegerpg.siege.core.miscellaneous.Levels
import net.siegerpg.siege.core.miscellaneous.Scoreboard
import net.siegerpg.siege.core.miscellaneous.VaultHook
import net.siegerpg.siege.core.miscellaneous.sendMiniMessage
import net.siegerpg.siege.core.skills.SkillData
import org.bukkit.Sound
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.inventory.InventoryAction
import org.bukkit.event.inventory.InventoryClickEvent
import java.lang.String

class SkillListener : Listener {

	@EventHandler
	@Suppress("unused")
	fun onInventoryClick(e : InventoryClickEvent) {
		if (e.whoClicked !is Player) return
		if (e.action != InventoryAction.SWAP_WITH_CURSOR) return
		val player = e.whoClicked as Player
		val itemOnCursor = getCustomItem(e.cursor)
		val itemInteractedWith = getCustomItem(e.currentItem)
		if (itemOnCursor == null || itemInteractedWith == null) return
		if (itemOnCursor !is CustomSkill) return
		if (itemInteractedWith !is CustomWeapon) return
		if (!itemInteractedWith.canAddSkill()) {
			player.sendMiniMessage("<red>That skill can not be merged onto this item!")
			return
		}
		if (!SkillData.hasSkillUnlocked(player, itemOnCursor.skill)) {
			player.sendMiniMessage("<red>You do not have this skill unlocked!")
			return
		}
		if (itemInteractedWith.hasSkill(itemOnCursor)) {
			player.sendMiniMessage("<red>This skill has already been applied.")
			return
		}
		val cost = (Herbert.getSellValue(e.currentItem) * 5).toInt()
		if (VaultHook.econ.getBalance(player) < cost) {
			player.sendMiniMessage("<red>You need ${String.format("%,d", cost)} \u26C1 to apply this book!")
			return
		}
		VaultHook.econ.withdrawPlayer(player, cost.toDouble())
		Scoreboard.updateScoreboard(player)

		player.playSound(
				player.location,
				Sound.BLOCK_CHORUS_FLOWER_DEATH,
				0.8f,
				1.2f)

		itemInteractedWith.addSkill(itemOnCursor)
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