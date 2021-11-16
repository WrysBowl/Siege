package net.siegerpg.siege.core.items.types.subtypes

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


}