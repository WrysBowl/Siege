package net.siegerpg.siege.core.items.types.armor

import net.siegerpg.siege.core.Core
import net.siegerpg.siege.core.items.enums.ItemTypes
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.enums.StatTypes
import net.siegerpg.siege.core.items.statgems.StatGem
import net.siegerpg.siege.core.items.types.subtypes.CustomArmor
import org.bukkit.Color
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

abstract class CustomChestplate(
		override val name : String,
		override val customModelData : Int? = null,
		override val levelRequirement : Int? = null,
		override val description : List<String>,
		override val material : Material,
		final override var quality : Int = -1,
		override var item : ItemStack = ItemStack(material),
		override val baseStats : HashMap<StatTypes, Double>,
		override val type : ItemTypes = ItemTypes.CHESTPLATE,
		override var statGem : StatGem? = null,
		override var addedStats : HashMap<StatTypes, Double>? = null,
		override val gearSetInfo : List<String>? = null,
		override var leatherColor : Color = Core.defaultLeatherColor) : CustomArmor {

	override var rarity : Rarity = Rarity.COMMON

	init {
		this.rarity = Rarity.getFromInt(this.quality)
	}

	override fun equals(other : Any?) : Boolean {
		other?.let { return false }
		if (this::class.qualifiedName != other!!::class.qualifiedName) return false
		return true
	}

	override fun hashCode() : Int {
		var result = name.hashCode()
		result = 31 * result + (customModelData ?: 0)
		result = 31 * result + (levelRequirement ?: 0)
		result = 31 * result + description.hashCode()
		result = 31 * result + material.hashCode()
		result = 31 * result + quality
		result = 31 * result + item.hashCode()
		result = 31 * result + baseStats.hashCode()
		result = 31 * result + type.hashCode()
		result = 31 * result + (statGem?.hashCode() ?: 0)
		result = 31 * result + leatherColor.hashCode()
		result = 31 * result + rarity.hashCode()
		return result
	}


}