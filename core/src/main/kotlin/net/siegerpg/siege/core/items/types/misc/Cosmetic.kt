package net.siegerpg.siege.core.items.types.misc

import net.siegerpg.siege.core.Core
import net.siegerpg.siege.core.items.enums.ItemTypes
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.subtypes.CustomCosmetic
import org.bukkit.Color
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

abstract class Cosmetic(
	override val name: String,
	override var customModelData: Int? = null,
	override val levelRequirement: Int? = null,
	override val description: List<String>,
	override val type: ItemTypes = ItemTypes.COSMETIC,
	override var material: Material,
	final override var quality: Int = -1,
	override var item: ItemStack = ItemStack(material),
	override var leatherColor: Color = Core.defaultLeatherColor
) : CustomCosmetic {

	override var rarity: Rarity = Rarity.COMMON


	init {
		this.rarity = Rarity.getFromInt(this.quality)
	}


	override fun equals(other: Any?): Boolean {
		other?.let { return false }
		if (this::class.qualifiedName != other!!::class.qualifiedName) return false
		return true
	}

	override fun hashCode(): Int {
		var result = name.hashCode()
		result = 31 * result + (customModelData ?: 0)
		result = 31 * result + (levelRequirement ?: 0)
		result = 31 * result + description.hashCode()
		result = 31 * result + material.hashCode()
		result = 31 * result + quality
		result = 31 * result + item.hashCode()
		result = 31 * result + type.hashCode()
		result = 31 * result + leatherColor.hashCode()
		result = 31 * result + rarity.hashCode()
		return result
	}

}