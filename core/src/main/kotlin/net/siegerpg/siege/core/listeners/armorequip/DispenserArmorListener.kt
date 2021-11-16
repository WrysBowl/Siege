package net.siegerpg.siege.core.listeners.armorequip

import net.siegerpg.siege.core.events.ArmorEquipEvent
import org.bukkit.Bukkit
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.BlockDispenseArmorEvent


/**
 * @author Arnah
 * @since Feb 08, 2019
 */
class DispenserArmorListener : Listener {

	@EventHandler
	fun dispenseArmorEvent(event : BlockDispenseArmorEvent) {
		val type = ArmorType.matchType(event.item)
		if (type != null) {
			if (event.targetEntity is Player) {
				val p = event.targetEntity as Player
				val armorEquipEvent = ArmorEquipEvent(
						p,
						ArmorEquipEvent.EquipMethod.DISPENSER,
						type,
						null,
						event.item
				                                     )
				Bukkit.getServer().pluginManager.callEvent(armorEquipEvent)
				if (armorEquipEvent.isCancelled()) {
					event.isCancelled = true
				}
			}
		}
	}
}