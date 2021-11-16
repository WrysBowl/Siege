package net.siegerpg.siege.core.listeners.armorequip

import net.siegerpg.siege.core.items.CustomItemUtils
import org.bukkit.inventory.ItemStack


/**
 * @author Arnah
 * @since Jul 30, 2015
 */
enum class ArmorType(val slot: Int) {
	HELMET(5), CHESTPLATE(6), LEGGINGS(7), BOOTS(8);

	companion object {
		/**
		 * Attempts to match the ArmorType for the specified ItemStack.
		 *
		 * @param itemStack The ItemStack to parse the type of.
		 * @return The parsed ArmorType, or null if not found.
		 */
		fun matchType(itemStack: ItemStack?): ArmorType? {
			if (ArmorListener.isAirOrNull(itemStack)) return null
			val type = itemStack!!.type.name
			val customItem = CustomItemUtils.getCustomItem(itemStack)
			return if (type.endsWith("_HELMET") || type.endsWith("_SKULL") || type.endsWith("_HEAD") || customItem != null) HELMET else if (type.endsWith(
					"_CHESTPLATE"
				) || type == "ELYTRA"
			) CHESTPLATE else if (type.endsWith("_LEGGINGS")) LEGGINGS else if (type.endsWith("_BOOTS")) BOOTS else null
		}
	}
}