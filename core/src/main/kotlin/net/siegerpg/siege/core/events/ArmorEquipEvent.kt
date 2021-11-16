package net.siegerpg.siege.core.events


import net.siegerpg.siege.core.listeners.armorequip.ArmorType
import org.bukkit.entity.Player
import org.bukkit.event.Cancellable
import org.bukkit.event.HandlerList
import org.bukkit.event.player.PlayerEvent
import org.bukkit.inventory.ItemStack


/**
 * @author Arnah
 * @since Jul 30, 2015
 */
/**
 * @param player The player who put on / removed the armor.
 * @param type The ArmorType of the armor added
 * @param oldArmorPiece The ItemStack of the armor removed.
 * @param newArmorPiece The ItemStack of the armor added.
 */
class ArmorEquipEvent(
	player: Player?,
	/**
	 * Gets the method used to either equip or unequip an armor piece.
	 */
	val method: EquipMethod, val type: ArmorType?,
	/**
	 * Returns the last equipped armor piece, could be a piece of armor, or null
	 */
	var oldArmorPiece: ItemStack?,
	var newArmorPiece: ItemStack?
) :
	PlayerEvent(player!!), Cancellable {
	private var cancel = false


	/**
	 * Gets a list of handlers handling this event.
	 *
	 * @return A list of handlers handling this event.
	 */
	override fun getHandlers(): HandlerList {
		return handlerList
	}

	/**
	 * Sets if this event should be cancelled.
	 *
	 * @param cancel If this event should be cancelled.
	 */
	override fun setCancelled(cancel: Boolean) {
		this.cancel = cancel
	}

	/**
	 * Gets if this event is cancelled.
	 *
	 * @return If this event is cancelled
	 */
	override fun isCancelled(): Boolean {
		return cancel
	}

	enum class EquipMethod {
		// These have got to be the worst documentations ever.
		/**
		 * When you shift click an armor piece to equip or unequip
		 */
		SHIFT_CLICK,

		/**
		 * When you drag and drop the item to equip or unequip
		 */
		DRAG,

		/**
		 * When you manually equip or unequip the item. Use to be DRAG
		 */
		PICK_DROP,

		/**
		 * When you right click an armor piece in the hotbar without the inventory open to equip.
		 */
		HOTBAR,

		/**
		 * When you press the hotbar slot number while hovering over the armor slot to equip or unequip
		 */
		HOTBAR_SWAP,

		/**
		 * When in range of a dispenser that shoots an armor piece to equip.<br></br>
		 * Requires the spigot version to have [org.bukkit.event.block.BlockDispenseArmorEvent] implemented.
		 */
		DISPENSER,

		/**
		 * When an armor piece is removed due to it losing all durability.
		 */
		BROKE,

		/**
		 * When you die causing all armor to unequip
		 */
		DEATH
	}

	companion object {
		/**
		 * Gets a list of handlers handling this event.
		 *
		 * @return A list of handlers handling this event.
		 */
		val handlerList = HandlerList()
	}
}