package net.siegerpg.siege.core.items.types.misc

import net.siegerpg.siege.core.items.CustomItem
import net.siegerpg.siege.core.items.enums.ItemTypes
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.enums.StatTypes
import net.siegerpg.siege.core.items.getNbtTag
import net.siegerpg.siege.core.items.implemented.misc.materials.FishingExplanation
import net.siegerpg.siege.core.items.setNbtTags
import net.siegerpg.siege.core.listeners.NPC.Herbert
import net.siegerpg.siege.core.miscellaneous.Utils
import net.siegerpg.siege.core.miscellaneous.lore
import net.siegerpg.siege.core.miscellaneous.name
import org.bukkit.Bukkit
import org.bukkit.Material
import org.bukkit.inventory.ItemFlag
import org.bukkit.inventory.ItemStack

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
	var tier : Int = 1
		set(value) {
			field = value
			this.serialize()
		}

	init {
		this.rarity = Rarity.getFromInt(this.quality)
	}

	override fun serialize() {
		super.serialize()
		item = item.setNbtTags(
				"materialTier" to tier
		                      )
	}

	override fun deserialize() {
		super.deserialize()
		item.getNbtTag<Int>("materialTier")?.let {
			tier = it
		}
	}

	override fun updateMeta(hideRarity : Boolean) : ItemStack {

		val meta = item.itemMeta

		meta.name("<r><gray>$name <yellow>${"\u272A".repeat(tier)}")

		if (meta.hasLore()) meta.lore(mutableListOf())

		meta.lore("<underlined><dark_gray>                    ")
		meta.lore(" ")
		//lazy coding here by Wrys
		if (this is FishingExplanation) {
			description.forEach {
				meta.lore("<r><dark_gray>$it")
			}
		} else {
			Utils.getTextArray(description, 16).forEach {
				meta.lore("<r><dark_gray>$it")
			}
		}

		meta.lore("<gray>/materials to upgrade")
		meta.lore("<underlined><dark_gray>                    ")
		meta.lore(" ")
		meta.lore("<r><color:#E2DE5D>${String.format("%,d",Herbert.getSellValue(item))} \u26C1")
		meta.isUnbreakable = true
		meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_UNBREAKABLE)
		item.itemMeta = meta
		return item
	}

	fun asQuantity(amount : Int) : CustomMaterial {
		this.item.amount = amount
		return this
	}

	override fun equals(other : Any?) : Boolean {
		if (other == null) return false
		Bukkit.getLogger().info("Other is not null")
		if (this::class.qualifiedName != other::class.qualifiedName) return false
		Bukkit.getLogger().info("Qualified names match")
		val castedOther = other as CustomMaterial

		if (this.tier != castedOther.tier) return false
		Bukkit.getLogger().info("Tiers match")
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
		result = 31 * result + tier
		return result
	}


}