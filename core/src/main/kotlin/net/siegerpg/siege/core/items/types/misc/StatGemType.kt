package net.siegerpg.siege.core.items.types.misc

import net.siegerpg.siege.core.items.CustomItem
import net.siegerpg.siege.core.items.enums.ItemTypes
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.enums.StatTypes
import net.siegerpg.siege.core.items.setNbtTags
import net.siegerpg.siege.core.miscellaneous.lore
import net.siegerpg.siege.core.miscellaneous.name
import org.bukkit.Material
import org.bukkit.inventory.ItemFlag
import org.bukkit.inventory.ItemStack

abstract class StatGemType(
	override val name: String,
	override val customModelData: Int? = null,
	override val levelRequirement: Int? = null,
	override val description: List<String>,
	override val material: Material,
	final override var quality: Int = -1,
	override var item: ItemStack = ItemStack(material),
	override val type: ItemTypes = ItemTypes.STATGEM,
	val statType: StatTypes,
	val statAmount: Double = 0.0
                          ) : CustomItem {

	override var rarity: Rarity = Rarity.COMMON


	init {
		this.rarity = Rarity.getFromInt(this.quality)
	}

	override fun serialize() {
		super.serialize()
		item = item.setNbtTags(
			"statGemTypeStat" to statType,
			"statGemTypeAmount" to statAmount
		                      )
	}

	override fun updateMeta(hideRarity: Boolean): ItemStack {

		val meta = item.itemMeta

		val shownRarity = if (hideRarity) Rarity.UNCOMMON else rarity

		meta.name(if (shownRarity == Rarity.SPECIAL) "<r><rainbow><b>$name</b></rainbow>" else "<light_purple>$name")

		if (meta.hasLore()) meta.lore(mutableListOf())
		if (shownRarity == Rarity.SPECIAL) meta.lore("<r><rainbow><b>${shownRarity.id}</b></rainbow> <gray>${if (hideRarity) 50 else quality}%")
		meta.lore(" ")
		meta.lore("<r><color:#FF3CFF>+${statAmount} <gray>${statType.stylizedName}")
		meta.lore(" ")
		description.forEach {
			meta.lore("<r><dark_gray>$it")
		}
		meta.lore(" ")
		meta.lore("<yellow><bold>DRAG ONTO ITEM TO APPLY")
		meta.lore("<gray>Merge these stats to your gear!")
		meta.lore(" ")
		meta.lore("<r><gray>Level: $levelRequirement")

		meta.isUnbreakable = true
		meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_UNBREAKABLE)
		item.itemMeta = meta
		return item
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
		result = 31 * result + statType.hashCode()
		result = 31 * result + statAmount.hashCode()
		result = 31 * result + rarity.hashCode()
		return result
	}

}