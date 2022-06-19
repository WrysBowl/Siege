package net.siegerpg.siege.core.items.types.misc

import net.siegerpg.siege.core.fishing.droptables.FishDropTable
import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.ItemTypes
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.enums.StatTypes
import net.siegerpg.siege.core.items.statgems.StatGem
import net.siegerpg.siege.core.items.types.subtypes.CustomEquipment
import net.siegerpg.siege.core.listeners.NPC.Herbert
import net.siegerpg.siege.core.miscellaneous.Utils
import net.siegerpg.siege.core.miscellaneous.lore
import net.siegerpg.siege.core.miscellaneous.name
import org.bukkit.Material
import org.bukkit.enchantments.Enchantment
import org.bukkit.inventory.ItemFlag
import org.bukkit.inventory.ItemStack

@Suppress("unused")
abstract class CustomRod(
		override val name : String,
		override val customModelData : Int? = null,
		override val levelRequirement : Int? = null,
		override val description : List<String>,
		override val material : Material,
		final override var quality : Int = -1,
		override var item : ItemStack = ItemStack(material),
		override val type : ItemTypes = ItemTypes.MATERIAL,
		override val baseStats : HashMap<StatTypes, Double>,
		override var statGem : StatGem? = null,
		val enchantments : MutableMap<Enchantment, Int>,
		val fishDropTable : FishDropTable,

		) : CustomEquipment {

	override var rarity : Rarity = Rarity.COMMON

	init {
		this.rarity = Rarity.getFromInt(this.quality)
		this.serialize()
	}

	override fun getSellValue() : Int {
		return 10 * quality
	}

	override fun updateMeta(hideRarity : Boolean) : ItemStack {

		val meta = item.itemMeta

		meta.name("<r><gray>$name")

		if (meta.hasLore()) meta.lore(mutableListOf())

		statGem?.let {
			meta.lore(" ")
			meta.lore("<r><color:#FF3CFF>+${it.amount} <light_purple>${it.type.stylizedName} Gem")
		}
		if (baseStats.size != 0) {
			item.itemMeta = statFormat(meta, hideRarity)
		}
		val length =
				if (name.length > 16) name.length
				else 16
		meta.lore(" ")
		Utils.getTextArray(description, length).forEach {
			meta.lore("<r><dark_gray>$it")
		}
		meta.lore(" ")
		if (hideRarity || quality < 0) {
			meta.lore("<r><gray>Level <color:#BC74EE>$levelRequirement")
		} else {
			meta.lore("<r><gray>Level <color:#BC74EE>$levelRequirement   <r><color:#E2DE5D>${String.format("%,d",getSellValue())} \u26C1")
		}

		meta.isUnbreakable = true
		meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_UNBREAKABLE)
		enchantments.forEach { (key, value) ->
			meta.addEnchant(key, value, true)
		}
		item.itemMeta = meta
		return item
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
		result = 31 * result + type.hashCode()
		result = 31 * result + enchantments.hashCode()
		result = 31 * result + rarity.hashCode()
		return result
	}


}