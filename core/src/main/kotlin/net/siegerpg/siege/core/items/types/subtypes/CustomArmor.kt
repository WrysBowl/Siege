package net.siegerpg.siege.core.items.types.subtypes

import net.siegerpg.siege.core.items.enums.StatTypes
import net.siegerpg.siege.core.items.getNbtTag
import net.siegerpg.siege.core.items.setNbtTags
import org.bukkit.Color
import org.bukkit.Material
import org.bukkit.attribute.Attribute
import org.bukkit.attribute.AttributeModifier
import org.bukkit.event.entity.EntityDamageEvent
import org.bukkit.inventory.ItemFlag
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.meta.LeatherArmorMeta

interface CustomArmor : CustomEquipment {

	var leatherColor : Color

	fun onHit(e : EntityDamageEvent) {

	}

	override fun updateMeta(hideRarity : Boolean) : ItemStack {
		super.updateMeta(hideRarity)
		item.type = this.material
		val meta = item.itemMeta

		if (item.type == Material.LEATHER_BOOTS ||
		    item.type == Material.LEATHER_LEGGINGS ||
		    item.type == Material.LEATHER_CHESTPLATE ||
		    item.type == Material.LEATHER_HELMET
		) {
			try {
				val leatherMeta = meta as LeatherArmorMeta
				meta.setColor(leatherColor)
				item.itemMeta = leatherMeta
			} catch (e : Error) {

			}
		}
		meta.addItemFlags(
				ItemFlag.HIDE_ATTRIBUTES,
				ItemFlag.HIDE_UNBREAKABLE,
				ItemFlag.HIDE_ENCHANTS,
				ItemFlag.HIDE_DYE
		                 )
		meta.removeAttributeModifier(Attribute.GENERIC_ARMOR)
		val modifier =
				AttributeModifier(
						"generic.armor",
						0.0,
						AttributeModifier.Operation.ADD_NUMBER
				                 )
		meta.addAttributeModifier(Attribute.GENERIC_ARMOR, modifier)

		item.itemMeta = meta
		return item
	}

	override fun serialize() {
		super.serialize()
		item = item.setNbtTags(
				"upgrades" to if (this.upgradeStats != null) upgradeStats.toString() else null
		                      )
	}

	override fun deserialize() {
		super.deserialize()
		try {
			item.getNbtTag<String>("upgrades")?.let { it ->
				if (it.isNotEmpty()) {
					val map : Map<StatTypes, Double> = it.split(",").associate {
						//This is ugly as heck
						val (left, right) = it.replace("{", "").replace("}", "").split("=")
						StatTypes.getFromId(left)!! to right.toDouble()
					}
					upgradeStats = HashMap(map)
				}
			}
		} catch (e : Exception) { }
	}
}