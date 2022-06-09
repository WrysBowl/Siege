package net.siegerpg.siege.core.listeners

import net.siegerpg.siege.core.items.CustomItem
import net.siegerpg.siege.core.items.CustomItemUtils.getCustomItem
import net.siegerpg.siege.core.items.types.armor.CustomHelmet
import net.siegerpg.siege.core.items.types.misc.CustomSkill
import net.siegerpg.siege.core.items.types.subtypes.CustomCosmetic
import net.siegerpg.siege.core.items.types.subtypes.CustomWeapon
import net.siegerpg.siege.core.items.types.weapons.CustomBow
import net.siegerpg.siege.core.items.types.weapons.CustomMeleeWeapon
import net.siegerpg.siege.core.items.types.weapons.CustomWand
import net.siegerpg.siege.core.listeners.NPC.Herbert
import net.siegerpg.siege.core.miscellaneous.Scoreboard
import net.siegerpg.siege.core.miscellaneous.VaultHook
import net.siegerpg.siege.core.miscellaneous.sendMiniMessage
import net.siegerpg.siege.core.skills.Skill
import net.siegerpg.siege.core.skills.SkillClass
import net.siegerpg.siege.core.skills.SkillData
import org.bukkit.Sound
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.Action
import org.bukkit.event.inventory.InventoryAction
import org.bukkit.event.inventory.InventoryClickEvent
import org.bukkit.event.inventory.InventoryType
import org.bukkit.event.player.PlayerInteractEvent
import kotlin.String

class SkillListener : Listener {

	@EventHandler
	@Suppress("unused")
	fun onInventoryClick(e : InventoryClickEvent) {
		if (e.whoClicked !is Player) return
		if (e.action != InventoryAction.SWAP_WITH_CURSOR) return
		val player = e.whoClicked as Player
		val itemOnCursor = getCustomItem(e.cursor) //cosmetic helmet
		val itemInteractedWith = getCustomItem(e.currentItem) //helmet
		if (itemOnCursor == null && itemInteractedWith != null) { //remove cosmetic from helmet
			if (e.action != InventoryAction.PICKUP_HALF) return
			if (itemOnCursor !is CustomSkill) return
			if (itemInteractedWith !is CustomWeapon) return
			if (!e.inventory.type.equals(InventoryType.CRAFTING)) return

			//set clicked item's original values back
			itemInteractedWith.removeSkill()
			itemInteractedWith.updateMeta(false)

			e.currentItem = itemInteractedWith.getUpdatedItem(false) //change clicked item to the new cosmetic item
			e.isCancelled = true
			player.setItemOnCursor(itemInteractedWith.customSkill?.getUpdatedItem(false))

		} else if (itemOnCursor != null && itemInteractedWith != null) { //fusing held cosmetic to clicked item
			if (e.action != InventoryAction.SWAP_WITH_CURSOR) return
			if (itemOnCursor !is CustomSkill) return
			if (itemInteractedWith !is CustomWeapon) return
			if (!itemInteractedWith.hasSkill()) {
				player.sendMiniMessage("<red>That skill can not be merged onto this item!")
				return
			}
			if (!SkillData.hasSkillUnlocked(player, itemOnCursor.skill)) {
				player.sendMiniMessage("<red>You do not have this skill unlocked!")
				return
			}
			/*
			val cost = Herbert.getSellValue(e.currentItem)
			if (VaultHook.econ.getBalance(player) < Herbert.getSellValue(e.currentItem)) {
				player.sendMiniMessage("<red>You need ${String.format("%,d", cost)} \u26C1 to apply this book!")
				return
			}
			VaultHook.econ.withdrawPlayer(player, cost.toDouble())
			Scoreboard.updateScoreboard(player)
			 */

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

	@EventHandler
	fun onInteractEvent(e : PlayerInteractEvent) {
		val item : CustomItem = getCustomItem(e.player.inventory.itemInMainHand) ?: return
		if (item !is CustomWeapon) return

		val customSkill : CustomSkill = item.customSkill ?: return
		val skillClass : SkillClass = customSkill.skill.skillClass
		val actions : List<Action> = skillClass.clickActions
		val action : Action = e.action

		if (!actions.contains(action)) return

		//trigger
		customSkill.skill.trigger(e.player)
	}

}