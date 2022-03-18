package net.siegerpg.siege.core.items.types.weapons

import net.siegerpg.siege.core.items.enums.ItemTypes
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.enums.StatTypes
import net.siegerpg.siege.core.items.setNbtTags
import net.siegerpg.siege.core.items.statgems.StatGem
import net.siegerpg.siege.core.items.sets.GearSet
import net.siegerpg.siege.core.items.types.subtypes.CustomWeapon
import net.siegerpg.siege.core.miscellaneous.Utils
import net.siegerpg.siege.core.miscellaneous.lore
import net.siegerpg.siege.core.miscellaneous.name
import org.bukkit.Material
import org.bukkit.attribute.Attribute
import org.bukkit.attribute.AttributeModifier
import org.bukkit.inventory.ItemFlag
import org.bukkit.inventory.ItemStack

abstract class CustomWand(
		override val name : String,
		override val customModelData : Int? = null,
		override val levelRequirement : Int? = null,
		override val description : List<String>,
		override val material : Material,
		final override var quality : Int = -1,
		override var item : ItemStack = ItemStack(material),
		override val type : ItemTypes = ItemTypes.WAND,
		override val baseStats : HashMap<StatTypes, Double>,
		val range : Int = 12,
		val red : Int = 255,
		val green : Int = 255,
		val blue : Int = 255,
		val damageRadius : Double = 2.5,
		override var statGem : StatGem? = null,
		override var addedStats : HashMap<StatTypes, Double>? = null,
		override val gearSetInfo : List<List<String>>? = null

		) : CustomWeapon {

	override var rarity : Rarity = Rarity.COMMON

	init {
		this.rarity = Rarity.getFromInt(this.quality)
	}

	override fun updateMeta(hideRarity : Boolean) : ItemStack {
		super.updateMeta(hideRarity)
		val meta = item.itemMeta

		meta.removeAttributeModifier(Attribute.GENERIC_ATTACK_SPEED)
		val modifier = AttributeModifier(
				"generic.attackSpeed",
				(-4.0 + 0.65),
				AttributeModifier.Operation.ADD_NUMBER
		                                )
		meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, modifier)

		val shownRarity = if (hideRarity) Rarity.UNCOMMON else rarity

		meta.name(if (shownRarity == Rarity.SPECIAL) "<r><rainbow><b>$name</b></rainbow>" else "<r>${shownRarity.color}$name")

		if (meta.hasLore()) meta.lore(mutableListOf())

		if (hideRarity || quality < 0) {
			meta.lore("<r><yellow>Rarity <gray>1-100%")
		} else {
			meta.lore(if (shownRarity == Rarity.SPECIAL) "<r><rainbow><b>${shownRarity.id}</b></rainbow> <gray>${quality}%" else "<r>${shownRarity.color}${shownRarity.id} <gray>${quality}%")
		}
		statGem?.let {
			meta.lore(" ")
			meta.lore("<r><color:#F67DF6>+${it.amount} <light_purple>${it.type.stylizedName}")
		}
		if (statGem == null) {
			meta.lore(" ")
			meta.lore("<dark_gray>\u25C7 <italic>Gem Slot")
		}
		if (baseStats.size != 0) {
			item.itemMeta = statFormat(meta, hideRarity)
			meta.lore("")
		}
		meta.lore("<r><yellow>$damageRadius <gray>Radius")
		meta.lore("<r><yellow>$range <gray>Range")
		meta.lore("<r><color:#72E5D3>${getManaCost()} <gray>Mana")

		val length =
				if (name.length > 16) name.length
				else 16
		meta.lore(" ")
		gearSetInfo?.forEach{
			meta.lore("<r><color:#87d4a0>Set Bonus")
			Utils.getTextArray(it, length).forEach {
				meta.lore("<r><color:#82a18c>$it")
			}
			meta.lore(" ")
		}
		Utils.getTextArray(description, length).forEach {
			meta.lore("<r><dark_gray>$it")
		}
		meta.lore(" ")
		meta.lore("<r><gray>Level <color:#BC74EE>$levelRequirement   <r><color:#E2DE5D>${String.format("%,d",getSellValue())} \u26C1")

		meta.isUnbreakable = true
		meta.addItemFlags(
				ItemFlag.HIDE_ATTRIBUTES,
				ItemFlag.HIDE_UNBREAKABLE,
				ItemFlag.HIDE_ENCHANTS,
				ItemFlag.HIDE_DYE
		                 )
		item.itemMeta = meta
		return item
	}

	fun getManaCost() : Int {
		var statSum : Int = 5
		for (stat in baseStats) {
			statSum += (stat.value/2).toInt()
		}
		return statSum
	}

	override fun serialize() {
		super.serialize()
		item = item.setNbtTags(
				"wandRange" to range,
				"wandRed" to red,
				"wandGreen" to green,
				"wandBlue" to blue,
				"wandDamageRadius" to damageRadius
		                      )
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
		result = 31 * result + baseStats.hashCode()
		result = 31 * result + range
		result = 31 * result + red
		result = 31 * result + green
		result = 31 * result + blue
		result = 31 * result + damageRadius.hashCode()
		result = 31 * result + (statGem?.hashCode() ?: 0)
		result = 31 * result + rarity.hashCode()
		return result
	}
}