package net.siegerpg.siege.core.items.types.misc

import net.siegerpg.siege.core.items.CustomItem
import net.siegerpg.siege.core.items.enums.ItemTypes
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.miscellaneous.Utils
import net.siegerpg.siege.core.miscellaneous.lore
import net.siegerpg.siege.core.miscellaneous.name
import org.bukkit.Material
import org.bukkit.inventory.ItemFlag
import org.bukkit.inventory.ItemStack

@Suppress("unused")
abstract class CustomMaterial(
		override val name : String,
		override val customModelData : Int? = null,
		override val levelRequirement : Int? = null,
		override val description : List<String>,
		override val material : Material,
		final override var quality : Int = -1,
		override var item : ItemStack = ItemStack(material),
		override val type : ItemTypes = ItemTypes.MATERIAL) : CustomItem {

	override var rarity : Rarity = Rarity.COMMON

	init {
		this.rarity = Rarity.getFromInt(this.quality)
		this.serialize()
	}

	override fun getSellValue() : Int {
		return quality/10
	}

	override fun updateMeta(hideRarity : Boolean) : ItemStack {

		val meta = item.itemMeta

		meta.name("<r><gray>$name")

		if (meta.hasLore()) meta.lore(mutableListOf())

		val length =
				if (name.length > 16) name.length
				else 16
		meta.lore(" ")
		Utils.getTextArray(description, length).forEach {
			meta.lore("<r><dark_gray>$it")
		}

		meta.lore(" ")
		if (!hideRarity && quality > 0) {
			meta.lore("<r><color:#E2DE5D>${String.format("%,d", getSellValue())} \u26C1")
		}
		meta.isUnbreakable = true
		meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_UNBREAKABLE)
		item.itemMeta = meta
		return item
	}

	override fun equals(other : Any?) : Boolean {
		if (other == null) return false
		if (this::class.qualifiedName != other::class.qualifiedName) return false
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
		result = 31 * result + type.hashCode()
		result = 31 * result + rarity.hashCode()
		return result
	}


}